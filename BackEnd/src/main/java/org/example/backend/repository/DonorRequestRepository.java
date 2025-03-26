package org.example.backend.repository;

import org.example.backend.entity.DonorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRequestRepository extends JpaRepository<DonorRequest, Long> {
    List<DonorRequest> findByStatus(String status);     // Custom query to find donor requests by status
    List<DonorRequest> findByHospital(String hospital); // Custom query to find donor requests by hospital
    List<DonorRequest> findByDonorName(String donorName); // Custom query to find donor requests by donor name
    List<DonorRequest> findByContact(String contact); // Custom query to find donor requests by contact
}
