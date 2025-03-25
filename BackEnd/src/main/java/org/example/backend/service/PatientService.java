package org.example.backend.service;

import org.example.backend.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientDTO registerPatient(PatientDTO patientDTO);

    List<PatientDTO> getAllPatients();

    PatientDTO getPatientById(Long id);

    List<PatientDTO> getPatientsByPatientName(String patientName);

    List<PatientDTO> getPatientsByContactNumber(String contactNumber);

    List<PatientDTO> getPatientsByEmail(String email);

    List<PatientDTO> getPatientsByBloodGroup(String bloodGroup);

    List<PatientDTO> getPatientsByDistrict(String district);

    List<PatientDTO> getPatientsByHospital(String hospitalName);

    void deletePatient(Long id);
}
