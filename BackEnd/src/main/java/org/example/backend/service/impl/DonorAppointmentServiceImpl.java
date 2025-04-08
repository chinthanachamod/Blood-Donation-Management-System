package org.example.backend.service.impl;

import org.example.backend.dto.DonorAppointmentDTO;
import org.example.backend.entity.DonorAppointment;
import org.example.backend.repository.DonorAppointmentRepository;
import org.example.backend.service.DonorAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonorAppointmentServiceImpl implements DonorAppointmentService {

    @Autowired
    private DonorAppointmentRepository donorAppointmentRepository;

    @Override
    public List<DonorAppointmentDTO> getAllAppointments() {
        // Fetch all donor appointments from the repository
        List<DonorAppointment> appointments = donorAppointmentRepository.findAll();

        // Convert to DTO list
        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DonorAppointmentDTO acceptAppointment(Long appointmentId) {
        // Fetch the appointment using the appointment ID
        DonorAppointment appointment = donorAppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Accept the appointment (update status to accepted)
        appointment.setStatus("Accepted");
        donorAppointmentRepository.save(appointment);

        // Convert to DTO and return
        return convertToDTO(appointment);
    }

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
