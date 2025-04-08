package org.example.backend.repository;

import org.example.backend.entity.DonorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorAppointmentRepository extends JpaRepository<DonorAppointment, Long> {

    // You can create custom queries if needed. For example:
    List<DonorAppointment> findByStatus(String status); // Find appointments by status (e.g., "Confirmed", "Pending")

    // You can also add other queries as needed, such as finding appointments by hospital name, donor name, etc.
}
