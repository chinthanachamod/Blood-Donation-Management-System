package org.example.backend.controller;

import org.example.backend.dto.DonorDTO;
import org.example.backend.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/donors")
@CrossOrigin(origins = "*")
public class DonorController {

    @Autowired
    private DonorService donorService;

    // Register a new donor
    @PostMapping("/register")
    public ResponseEntity<DonorDTO> registerDonor(@RequestBody DonorDTO donorDTO) {
        System.out.println(donorDTO);

        System.out.println("controller >> age :"+ donorDTO.getDonorAge());

        DonorDTO savedDonor = donorService.registerDonor(donorDTO);
        return new ResponseEntity<>(savedDonor, HttpStatus.CREATED);

        /*
        @PostMapping - registerDonor(): Handles creating a new donor.
        ResponseEntity<DonorDTO>: Returns the created donor with HttpStatus.CREATED
         */
    }

    // Get all donors
    @GetMapping("/getAll")
    public ResponseEntity<List<DonorDTO>> getAllDonors() {
        List<DonorDTO> donors = donorService.getAllDonors();
        return new ResponseEntity<>(donors, HttpStatus.OK);

        /*
        @GetMapping("/getAll") - getAllDonors(): Retrieves all donors.
        Returns a list of donors with HttpStatus.OK.
        */
    }

    // Get a specific donor by ID
    @GetMapping("/{id}")
    public ResponseEntity<DonorDTO> getDonorById(@PathVariable Long id) {
        DonorDTO donorDTO = donorService.getDonorById(id);
        return new ResponseEntity<>(donorDTO, HttpStatus.OK);

        /*
        @GetMapping("/{id}") - getDonorById(): Retrieves a specific donor by their ID.
        Returns the donor data with HttpStatus.OK.
        */
    }

    // Update donor details
    @PutMapping("/{id}")
    public ResponseEntity<DonorDTO> updateDonor(@PathVariable Long id, @RequestBody DonorDTO donorDTO) {
        DonorDTO updatedDonor = donorService.updateDonor(id, donorDTO);
        return new ResponseEntity<>(updatedDonor, HttpStatus.OK);

        /*
        @PutMapping("/{id}") - updateDonor(): Updates an existing donor.
        Returns the updated donor data with HttpStatus.OK.
        */
    }

    // Delete a donor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        /*
        @DeleteMapping("/{id}") - deleteDonor(): Deletes a donor by their ID.
        Returns HttpStatus.NO_CONTENT to indicate successful deletion.
        */
    }
}
