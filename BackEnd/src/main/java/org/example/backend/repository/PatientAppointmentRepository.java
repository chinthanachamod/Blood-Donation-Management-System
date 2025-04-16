package org.example.backend.repository;

import org.example.backend.entity.PatientAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientAppointmentRepository extends JpaRepository<PatientAppointment, Long> {

    // Find appointments by status (e.g., "Confirmed", "Pending")
    List<PatientAppointment> findByStatus(String status);

    // You can add more queries if needed, for example:
    List<PatientAppointment> findByHospitalName(String hospitalName);

    // List<PatientAppointment> findByHospitalName(String hospitalName);
}
