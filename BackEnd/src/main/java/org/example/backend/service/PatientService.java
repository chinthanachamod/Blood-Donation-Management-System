package org.example.backend.service;

import org.example.backend.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientDTO registerPatient(PatientDTO patientDTO);

    List<PatientDTO> getAllPatients();

    PatientDTO getPatientById(Long id);

    List<PatientDTO> getPatientsByBloodGroup(String bloodGroup);

    List<PatientDTO> getPatientsByDistrict(String district);

    List<PatientDTO> getPatientsByHospital(String hospitalName);

    void deletePatient(Long id);
}
