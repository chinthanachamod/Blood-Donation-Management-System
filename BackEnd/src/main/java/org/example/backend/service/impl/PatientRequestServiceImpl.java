package org.example.backend.service.impl;

import org.example.backend.dto.PatientRequestDTO;
import org.example.backend.entity.PatientRequest;
import org.example.backend.repository.PatientRequestRepository;
import org.example.backend.service.PatientRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientRequestServiceImpl implements PatientRequestService {

    @Autowired
    private PatientRequestRepository patientRequestRepository;

    @Override
    public PatientRequestDTO createRequest(PatientRequestDTO requestDTO) {
        // Convert DTO to Entity
        PatientRequest patientRequest = new PatientRequest();
        patientRequest.setPatientName(requestDTO.getPatientName());
        patientRequest.setBloodGroup(requestDTO.getBloodGroup());
        patientRequest.setRequestedPints(requestDTO.getRequestedPints());
        patientRequest.setHospital(requestDTO.getHospital());
        patientRequest.setContact(requestDTO.getContact());
        patientRequest.setStatus("PENDING"); // Default status

        // Save entity in database
        PatientRequest savedRequest = patientRequestRepository.save(patientRequest);

        // Convert Entity back to DTO
        return mapToDTO(savedRequest);
    }

    @Override
    public List<PatientRequestDTO> getAllRequests() {
        List<PatientRequest> requests = patientRequestRepository.findAll();
        return requests.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PatientRequestDTO> getRequestsByStatus(String status) {
        List<PatientRequest> requests = patientRequestRepository.findByStatus(status);
        return requests.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void acceptRequest(Long requestId) {
        PatientRequest request = patientRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Patient Request not found"));
        request.setStatus("ACCEPTED");
        patientRequestRepository.save(request);
    }

    @Override
    public void denyRequest(Long requestId) {
        PatientRequest request = patientRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Patient Request not found"));
        request.setStatus("DENIED");
        patientRequestRepository.save(request);
    }

    // Helper method to convert Entity to DTO
    private PatientRequestDTO mapToDTO(PatientRequest patientRequest) {
        PatientRequestDTO dto = new PatientRequestDTO();
        dto.setId(patientRequest.getId());
        dto.setPatientName(patientRequest.getPatientName());
        dto.setBloodGroup(patientRequest.getBloodGroup());
        dto.setRequestedPints(patientRequest.getRequestedPints());
        dto.setHospital(patientRequest.getHospital());
        dto.setContact(patientRequest.getContact());
        dto.setStatus(patientRequest.getStatus());
        return dto;
    }
}
