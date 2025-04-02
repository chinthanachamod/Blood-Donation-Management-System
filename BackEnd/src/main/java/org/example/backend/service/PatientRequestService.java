package org.example.backend.service;

import org.example.backend.dto.PatientRequestDTO;

import java.util.List;

public interface PatientRequestService {

    // Create a new patient request
    PatientRequestDTO createRequest(PatientRequestDTO requestDTO);

    // Retrieve all patient requests
    List<PatientRequestDTO> getAllRequests();

    // Retrieve patient requests by status (PENDING, ACCEPTED, DENIED)
    List<PatientRequestDTO> getRequestsByStatus(String status);

    // Accept a patient request
    void acceptRequest(Long requestId);

    // Deny a patient request
    void denyRequest(Long requestId);
}
