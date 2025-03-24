package org.example.backend.service;

import org.example.backend.dto.DonorDTO;

import java.util.List;

public interface DonorService {

    DonorDTO registerDonor(DonorDTO donorDTO);      // Saves a new donor.

    DonorDTO getDonorById(Long id);     // Retrieves a donor by their ID.

    List<DonorDTO> getAllDonors();      // Retrieves all registered donors.

    DonorDTO updateDonor(Long id, DonorDTO donorDTO);       // Updates donor details.

    void deleteDonor(Long id);      // Deletes a donor by their ID.
}
