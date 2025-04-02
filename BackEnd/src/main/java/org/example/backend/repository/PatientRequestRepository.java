package org.example.backend.repository;

import org.example.backend.entity.PatientRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRequestRepository extends JpaRepository<PatientRequest, Long> {

    // Custom query to find pending requests
    List<PatientRequest> findByStatus(String status);

}

