package org.example.backend.repository;

import org.example.backend.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {

    boolean existsByEmail(String email);

    boolean existsByContactNumber(String contactNumber);
}
