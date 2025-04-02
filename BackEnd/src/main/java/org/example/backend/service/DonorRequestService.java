package org.example.backend.service;

import org.example.backend.dto.DonorRequestDTO;
import org.example.backend.enums.RequestStatus;

import java.util.List;

public interface DonorRequestService {

    // Submit a new donor request
    DonorRequestDTO submitDonorRequest(DonorRequestDTO donorRequestDTO);

    // Fetch all donor requests by status
    List<DonorRequestDTO> getAllDonorRequestsByStatus(RequestStatus status);

    // Fetch all donor requests for a specific hospital
    List<DonorRequestDTO> getAllDonorRequestsByHospital(String hospitalName);

    // Accept a donor request
    DonorRequestDTO acceptDonorRequest(Long requestId);

    // Reject a donor request (simply remove it from the system)
    void rejectDonorRequest(Long requestId);
}
