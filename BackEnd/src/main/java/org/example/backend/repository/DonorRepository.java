package org.example.backend.repository;

import org.example.backend.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {

    boolean existsByEmail(String email);      // Checks if a donor with the given email exists.

    boolean existsByContactNumber(String contactNumber);      // Checks if a donor with the given contact number exists.
}
