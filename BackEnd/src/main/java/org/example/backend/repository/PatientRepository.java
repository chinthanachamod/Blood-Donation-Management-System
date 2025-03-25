package org.example.backend.repository;

import org.example.backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByBloodGroup(String bloodGroup);

    List<Patient> findByDistrict(String district);

    List<Patient> findByHospitalName(String hospitalName);

    Patient findByEmail(String email);
}
