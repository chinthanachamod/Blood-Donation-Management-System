package org.example.backend.service;

import org.example.backend.dto.DonorAppointmentDTO;
import org.example.backend.dto.DonorRequestDTO;

import java.util.List;

public interface DonorAppointmentService {

    // Method to get all appointments for a hospital
    List<DonorAppointmentDTO> getAllAppointments();

    // Method to accept the donor's appointment request
    DonorAppointmentDTO acceptAppointment(Long appointmentId);

    // Method to reject the donor's appointment request
    void rejectAppointment(Long appointmentId);

    // Method to get appointment details by appointment ID
    DonorAppointmentDTO getAppointmentById(Long appointmentId);

    // Method to create a new appointment from a donor request
    DonorAppointmentDTO createAppointmentFromRequest(DonorRequestDTO requestDTO);
}
