package org.example.backend.service.impl;

import org.example.backend.dto.DonorAppointmentDTO;
import org.example.backend.dto.DonorRequestDTO;
import org.example.backend.entity.DonorAppointment;
import org.example.backend.repository.DonorAppointmentRepository;
import org.example.backend.service.DonorAppointmentService;
import org.example.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonorAppointmentServiceImpl implements DonorAppointmentService {

    @Autowired
    private DonorAppointmentRepository donorAppointmentRepository;

    //////////////////////////////////////////////////////////////////////////
    // Email service to send appointment confirmation emails
    @Autowired
    private EmailService emailService;

    @Override
    public DonorAppointmentDTO acceptAppointment(Long appointmentId) {
        DonorAppointment appointment = donorAppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus("Accepted");
        donorAppointmentRepository.save(appointment);

        // Send confirmation email to donor
        String subject = "Blood Donation Appointment Confirmed";
        String body = "Dear " + appointment.getDonorName() + ",\n\n"
                + "Your blood donation appointment has been confirmed.\n"
                + "Date & Time: " + appointment.getAppointmentDateTime() + "\n"
                + "Hospital: " + appointment.getHospitalName() + "\n\n"
                + "Thank you for your generous contribution!\n\n"
                + "Blood Donation Management System Team";

        emailService.sendEmail(appointment.getDonorEmail(), subject, body);

        return convertToDTO(appointment);
    }


    @Override
    public DonorAppointmentDTO createAppointmentFromRequest(DonorRequestDTO requestDTO) {
        DonorAppointment appointment = new DonorAppointment();

        appointment.setDonorName(requestDTO.getDonorName());
        appointment.setDonorEmail(requestDTO.getEmail()); // Automatically assign email
        appointment.setBloodGroup(requestDTO.getBloodGroup());
        appointment.setContactNumber(requestDTO.getContact());
        appointment.setHospitalName(requestDTO.getHospitalName());
        appointment.setStatus("Pending");
        appointment.setAppointmentDateTime(java.time.LocalDateTime.now().plusDays(1)); // Default time for now

        donorAppointmentRepository.save(appointment);

        return convertToDTO(appointment);
    }

    //////////////////////////////////////////////////////////////////////////


    @Override
    public List<DonorAppointmentDTO> getAllAppointments() {
        // Fetch all donor appointments from the repository
        List<DonorAppointment> appointments = donorAppointmentRepository.findAll();

        // Convert to DTO list
        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /*@Override
    public DonorAppointmentDTO acceptAppointment(Long appointmentId) {
        // Fetch the appointment using the appointment ID
        DonorAppointment appointment = donorAppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Accept the appointment (update status to accepted)
        appointment.setStatus("Accepted");
        donorAppointmentRepository.save(appointment);

        // Convert to DTO and return
        return convertToDTO(appointment);
    }*/

    @Override
    public void rejectAppointment(Long appointmentId) {
        // Fetch the appointment using the appointment ID
        DonorAppointment appointment = donorAppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Reject the appointment (delete it)
        donorAppointmentRepository.delete(appointment);
    }

    @Override
    public DonorAppointmentDTO getAppointmentById(Long appointmentId) {
        // Fetch the appointment using the appointment ID
        DonorAppointment appointment = donorAppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Convert to DTO and return
        return convertToDTO(appointment);
    }

    // Helper method to convert DonorAppointment to DonorAppointmentDTO
    private DonorAppointmentDTO convertToDTO(DonorAppointment appointment) {
        return new DonorAppointmentDTO(
                appointment.getId(),
                appointment.getDonorName(),
                appointment.getDonorEmail(),
                appointment.getBloodGroup(),
                appointment.getContactNumber(),
                appointment.getHospitalName(),
                appointment.getAppointmentDateTime(),
                appointment.getStatus()
        );
    }
}
