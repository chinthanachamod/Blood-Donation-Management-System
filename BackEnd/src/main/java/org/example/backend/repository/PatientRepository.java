package org.example.backend.repository;

import org.example.backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    List<Patient> findByContactNumber(String contactNumber);  // Find patients by contact number.

    List<Patient> findByPatientName(String patientName);  // Find patients by name.

    List<Patient> findByBloodGroup(String bloodGroup);  // Find patients by blood group.

    List<Patient> findByDistrict(String district);      // Find patients by district.

    List<Patient> findByHospitalName(String hospitalName);      // Find patients associated with a specific hospital.

    //Patient findByEmail(String email);  // Retrieve a patient by email.

    List<Patient> findByEmail(String email);  // Retrieve a patient by email.

}
