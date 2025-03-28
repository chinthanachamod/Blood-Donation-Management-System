package org.example.backend.controller;

import org.example.backend.dto.DonorRequestDTO;
import org.example.backend.service.DonorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/donor-requests")
@CrossOrigin(origins = "*")
public class DonorRequestController {

   /* @Autowired
    private DonorRequestService donorRequestService;

    // Create a new donor request
    @PostMapping
    public ResponseEntity<DonorRequestDTO> createDonorRequest(@RequestBody DonorRequestDTO donorRequestDTO) {
        return ResponseEntity.ok(donorRequestService.createDonorRequest(donorRequestDTO));
    }

    // Get all donor requests
    @GetMapping
    public ResponseEntity<List<DonorRequestDTO>> getAllDonorRequests() {
        return ResponseEntity.ok(donorRequestService.getAllDonorRequests());
    }

    // Get a donor request by ID
    @GetMapping("/{id}")
    public ResponseEntity<DonorRequestDTO> getDonorRequestById(@PathVariable Long id) {
        return ResponseEntity.ok(donorRequestService.getDonorRequestById(id));
    }

    // Update donor request status (Accept/Deny)
    @PutMapping("/{id}/status")
    public ResponseEntity<DonorRequestDTO> updateDonorRequestStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(donorRequestService.updateDonorRequestStatus(id, status));
    }

    // Delete a donor request
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDonorRequest(@PathVariable Long id) {
        donorRequestService.deleteDonorRequest(id);
        return ResponseEntity.ok("Donor request deleted successfully");
    }*/
}
