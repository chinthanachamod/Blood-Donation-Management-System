package org.example.backend.service.impl;

import org.example.backend.dto.DonorRequestDTO;
import org.example.backend.entity.DonorRequest;
import org.example.backend.enums.RequestStatus;
import org.example.backend.repository.DonorRequestRepository;
import org.example.backend.service.DonorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonorRequestServiceImpl implements DonorRequestService {

    @Autowired
    private DonorRequestRepository donorRequestRepository;

    @Override
    public DonorRequestDTO submitDonorRequest(DonorRequestDTO donorRequestDTO) {
        DonorRequest donorRequest = new DonorRequest();
        donorRequest.setDonorName(donorRequestDTO.getDonorName());
        donorRequest.setBloodGroup(donorRequestDTO.getBloodGroup());
        donorRequest.setContact(donorRequestDTO.getContact());
        donorRequest.setEmail(donorRequestDTO.getEmail());
        donorRequest.setHospitalName(donorRequestDTO.getHospitalName());
        donorRequest.setStatus(RequestStatus.PENDING);

        DonorRequest savedRequest = donorRequestRepository.save(donorRequest);
        return mapToDTO(savedRequest);
    }

    @Override
    public List<DonorRequestDTO> getAllDonorRequestsByStatus(RequestStatus status) {
        List<DonorRequest> requests = donorRequestRepository.findByStatus(status.toString());
        System.out.println(requests);
        return requests.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DonorRequestDTO> getAllDonorRequestsByHospital(String hospitalName) {
        List<DonorRequest> requests = donorRequestRepository.findByHospitalName(hospitalName);
        return requests.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public DonorRequestDTO acceptDonorRequest(Long requestId) {
        Optional<DonorRequest> requestOpt = donorRequestRepository.findById(requestId);
        if (requestOpt.isPresent()) {
            DonorRequest request = requestOpt.get();
            request.setStatus(RequestStatus.ACCEPTED);
            donorRequestRepository.save(request);
            return mapToDTO(request);
        }
        throw new RuntimeException("Request not found");
    }

    @Override
    public void rejectDonorRequest(Long requestId) {
        donorRequestRepository.deleteById(requestId);
    }

    // Helper method to map entity to DTO
    private DonorRequestDTO mapToDTO(DonorRequest donorRequest) {
        return new DonorRequestDTO(
                donorRequest.getId(),
                donorRequest.getDonorName(),
                donorRequest.getBloodGroup(),
                donorRequest.getContact(),
                donorRequest.getEmail(),
                donorRequest.getHospitalName(),
                donorRequest.getStatus(),
                donorRequest.getRequestDate()
        );
    }
}