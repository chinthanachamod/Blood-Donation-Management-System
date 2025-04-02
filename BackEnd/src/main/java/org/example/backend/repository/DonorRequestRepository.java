package org.example.backend.repository;


import org.example.backend.entity.DonorRequest;
import org.example.backend.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRequestRepository extends JpaRepository<DonorRequest, Long> {

    // Fetch donor requests by status (PENDING, ACCEPTED, REJECTED)
    List<DonorRequest> findByStatus(RequestStatus status);

    // Fetch donor requests for a specific hospital
    List<DonorRequest> findByHospitalName(String hospitalName);
}
