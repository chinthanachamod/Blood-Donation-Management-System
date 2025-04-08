package org.example.backend.controller;

import org.example.backend.dto.PatientRequestDTO;
import org.example.backend.service.PatientRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient-requests")
@CrossOrigin(origins = "*") // Allows cross-origin requests (Frontend can access APIs)
public class PatientRequestController {

    @Autowired
    private PatientRequestService patientRequestService;

    // Create a new patient request
    @PostMapping("/create")
    public ResponseEntity<PatientRequestDTO> createRequest(@RequestBody PatientRequestDTO requestDTO) {
        PatientRequestDTO createdRequest = patientRequestService.createRequest(requestDTO);
        return ResponseEntity.ok(createdRequest);
    }

    // Get all patient requests
    @GetMapping("/all")
    public ResponseEntity<List<PatientRequestDTO>> getAllRequests() {
        List<PatientRequestDTO> requests = patientRequestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    // Get patient requests by status (Pending, Accepted, Denied)
    @GetMapping("/status/{status}")
    public ResponseEntity<List<PatientRequestDTO>> getRequestsByStatus(@PathVariable String status) {
        List<PatientRequestDTO> requests = patientRequestService.getRequestsByStatus(status);
        return ResponseEntity.ok(requests);
    }

    // Accept a patient request
    @PutMapping("/accept/{id}")
    public ResponseEntity<String> acceptRequest(@PathVariable Long id) {
        patientRequestService.acceptRequest(id);
        return ResponseEntity.ok("Request accepted successfully.");
    }

    // Deny a patient request
    @PutMapping("/deny/{id}")
    public ResponseEntity<String> denyRequest(@PathVariable Long id) {
        patientRequestService.denyRequest(id);
        return ResponseEntity.ok("Request denied successfully.");
    }
}
