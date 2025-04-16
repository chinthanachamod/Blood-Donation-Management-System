package org.example.backend.service.impl;

import org.example.backend.dto.PatientAppointmentDTO;
import org.example.backend.dto.PatientRequestDTO;
import org.example.backend.entity.PatientAppointment;
import org.example.backend.repository.PatientAppointmentRepository;
import org.example.backend.service.EmailService;
import org.example.backend.service.PatientAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientAppointmentServiceImpl implements PatientAppointmentService {

    @Autowired
    private PatientAppointmentRepository patientAppointmentRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public PatientAppointmentDTO acceptAppointment(Long appointmentId) {
        PatientAppointment appointment = patientAppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus("Accepted");
        patientAppointmentRepository.save(appointment);

        // Send confirmation email to patient
        String subject = "Blood Request Appointment Confirmed";
        String body = "Dear " + appointment.getPatientName() + ",\n\n"
                + "Your blood request appointment has been confirmed.\n"
                + "Date & Time: " + appointment.getAppointmentDateTime() + "\n"
                + "Hospital: " + appointment.getHospitalName() + "\n\n"
                + "Thank you for using our service!\n\n"
                + "Blood Donation Management System Team";

        emailService.sendEmail(appointment.getPatientEmail(), subject, body);

        return convertToDTO(appointment);
    }

    @Override
    public PatientAppointmentDTO createAppointmentFromRequest(PatientRequestDTO requestDTO) {
        PatientAppointment appointment = new PatientAppointment();

        appointment.setPatientName(requestDTO.getPatientName());
        appointment.setBloodGroup(requestDTO.getBloodGroup());
        appointment.setRequestedPints(requestDTO.getRequestedPints());
        appointment.setPatientEmail(requestDTO.getEmail());
        appointment.setContactNumber(requestDTO.getContact());
        appointment.setAppointmentDateTime(LocalDateTime.now());
        appointment.setStatus("Pending");
        appointment.setAppointmentDateTime(java.time.LocalDateTime.now().plusDays(1)); // Example default

        patientAppointmentRepository.save(appointment);

        return convertToDTO(appointment);
    }

    @Override
    public List<PatientAppointmentDTO> getAllAppointments() {
        List<PatientAppointment> appointments = patientAppointmentRepository.findAll();

        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void rejectAppointment(Long appointmentId) {
        PatientAppointment appointment = patientAppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        patientAppointmentRepository.delete(appointment);
    }

    @Override
    public PatientAppointmentDTO getAppointmentById(Long appointmentId) {
        PatientAppointment appointment = patientAppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        return convertToDTO(appointment);
    }

    // Helper method to convert PatientAppointment to DTO
    private PatientAppointmentDTO convertToDTO(PatientAppointment appointment) {
        return new PatientAppointmentDTO(
                appointment.getId(),
                appointment.getPatientName(),
                appointment.getPatientEmail(),
                appointment.getBloodGroup(),
                appointment.getContactNumber(),
                appointment.getRequestedPints(),
                appointment.getHospitalName(),
                appointment.getAppointmentDateTime(),
                appointment.getStatus()
        );
    }
}