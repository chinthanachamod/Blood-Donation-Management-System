package org.example.backend.repository;


import org.example.backend.entity.DonorRequest;
import org.example.backend.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRequestRepository extends JpaRepository<DonorRequest, Long> {

    // Get donor requests by status
    List<DonorRequest> findByStatus(RequestStatus status);

    // Get donor requests by donor name
    List<DonorRequest> findByDonorName(String donorName);

    // Get donor requests by contact
    List<DonorRequest> findByContact(String contact);
}
