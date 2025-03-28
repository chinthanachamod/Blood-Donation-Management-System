package org.example.backend.service.impl;

import org.example.backend.dto.DonorRequestDTO;
import org.example.backend.entity.DonorRequest;
import org.example.backend.repository.DonorRequestRepository;
import org.example.backend.service.DonorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonorRequestServiceImpl implements DonorRequestService {

/*    @Autowired
    private DonorRequestRepository donorRequestRepository;

    @Override
    public DonorRequestDTO createDonorRequest(DonorRequestDTO donorRequestDTO) {
        DonorRequest donorRequest = new DonorRequest();
        donorRequest.setDonorName(donorRequestDTO.getDonorName());
        donorRequest.setBloodGroup(donorRequestDTO.getBloodGroup());
        donorRequest.setContact(donorRequestDTO.getContact());
        donorRequest.setHospital(donorRequestDTO.getHospital());
        donorRequest.setStatus("Pending");

        DonorRequest savedRequest = donorRequestRepository.save(donorRequest);
        return mapToDTO(savedRequest);
    }

    @Override
    public List<DonorRequestDTO> getAllDonorRequests() {
        List<DonorRequest> donorRequests = donorRequestRepository.findAll();
        return donorRequests.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public DonorRequestDTO getDonorRequestById(Long id) {
        DonorRequest donorRequest = donorRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor Request not found"));
        return mapToDTO(donorRequest);
    }

    @Override
    public DonorRequestDTO updateDonorRequestStatus(Long id, String status) {
        DonorRequest donorRequest = donorRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor Request not found"));

        donorRequest.setStatus(status);
        DonorRequest updatedRequest = donorRequestRepository.save(donorRequest);
        return mapToDTO(updatedRequest);
    }

    @Override
    public void deleteDonorRequest(Long id) {
        donorRequestRepository.deleteById(id);
    }

    private DonorRequestDTO mapToDTO(DonorRequest donorRequest) {
        return new DonorRequestDTO(
                donorRequest.getId(),
                donorRequest.getDonorName(),
                donorRequest.getBloodGroup(),
                donorRequest.getContact(),
                donorRequest.getHospital(),
                donorRequest.getStatus()
        );
    }*/
}
