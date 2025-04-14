package org.example.backend.controller;

import org.example.backend.dto.DonorRequestDTO;
import org.example.backend.enums.RequestStatus;
import org.example.backend.service.DonorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/donor-requests")
@CrossOrigin(origins = "*") // Allow frontend access
public class DonorRequestController {

    @Autowired
    private DonorRequestService donorRequestService;

    // Submit a new donor request
    @PostMapping("/submit")
    public ResponseEntity<DonorRequestDTO> submitDonorRequest(@RequestBody DonorRequestDTO donorRequestDTO) {
        DonorRequestDTO savedRequest = donorRequestService.submitDonorRequest(donorRequestDTO);
        return ResponseEntity.ok(savedRequest);
    }

    // Get all pending donor requests
    @GetMapping("/pending")
    public ResponseEntity<List<DonorRequestDTO>> getPendingRequests() {
        List<DonorRequestDTO> requests = donorRequestService.getAllDonorRequestsByStatus(RequestStatus.PENDING);
        return ResponseEntity.ok(requests);
    }

    // Accept a donor request
    @PutMapping("/accepted/{requestId}")
    public ResponseEntity<DonorRequestDTO> acceptDonorRequest(@PathVariable Long requestId) {
        try{
            System.out.println("called");
            DonorRequestDTO acceptedRequest = donorRequestService.acceptDonorRequest(requestId);
            return ResponseEntity.ok(acceptedRequest);
        }catch (RuntimeException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Reject a donor request
    @DeleteMapping("/reject/{requestId}")
    public ResponseEntity<String> rejectDonorRequest(@PathVariable Long requestId) {
        donorRequestService.rejectDonorRequest(requestId);
        return ResponseEntity.ok("Request rejected successfully");
    }
}
