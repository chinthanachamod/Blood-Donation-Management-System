package org.example.backend.service;

import org.example.backend.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientDTO registerPatient(PatientDTO patientDTO);

    List<PatientDTO> getAllPatients();

    PatientDTO getPatientById(Long id);

    List<PatientDTO> getPatientsByContactNumber(String contactNumber);

    List<PatientDTO> getPatientsByEmail(String email);


    void deletePatient(Long id);
}
