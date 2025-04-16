package org.example.backend.service;

import org.example.backend.dto.PatientAppointmentDTO;
import org.example.backend.dto.PatientRequestDTO;

import java.util.List;

public interface PatientAppointmentService {

    // Method to get all patient appointments
    List<PatientAppointmentDTO> getAllAppointments();

    // Method to accept the patient's request and create an appointment
    PatientAppointmentDTO acceptAppointment(Long requestId);

    // Method to reject the patient's request
    void rejectAppointment(Long requestId);

    // Method to get patient appointment by ID
    PatientAppointmentDTO getAppointmentById(Long appointmentId);

    // Method to create an appointment from a patient request
    PatientAppointmentDTO createAppointmentFromRequest(PatientRequestDTO requestDTO);
}
