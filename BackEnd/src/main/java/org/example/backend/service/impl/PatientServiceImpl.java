package org.example.backend.service.impl;

import org.example.backend.dto.PatientDTO;
import org.example.backend.entity.Patient;
import org.example.backend.repository.PatientRepository;
import org.example.backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDTO registerPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setPatientName(patientDTO.getPatientName());
        patient.setAge(patientDTO.getAge());
        patient.setBloodGroup(patientDTO.getBloodGroup());
        patient.setGender(patientDTO.getGender());
        patient.setContactNumber(patientDTO.getContactNumber());
        patient.setDistrict(patientDTO.getDistrict());
        patient.setHospitalName(patientDTO.getHospitalName());
        patient.setEmail(patientDTO.getEmail());
        patient.setHomeAddress(patientDTO.getHomeAddress());

        Patient savedPatient = patientRepository.save(patient);
        return mapToDTO(savedPatient);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public List<PatientDTO> getPatientsByContactNumber(String contactNumber) {
        return patientRepository.findByContactNumber(contactNumber).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> getPatientsByPatientName(String patientName) {
        return patientRepository.findByPatientName(patientName).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> getPatientsByBloodGroup(String bloodGroup) {
        return patientRepository.findByBloodGroup(bloodGroup).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> getPatientsByDistrict(String district) {
        return patientRepository.findByDistrict(district).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> getPatientsByHospital(String hospitalName) {
        return patientRepository.findByHospitalName(hospitalName).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> getPatientsByEmail(String email) {
        return patientRepository.findByEmail(email).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    private PatientDTO mapToDTO(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getPatientName(),
                patient.getAge(),
                patient.getBloodGroup(),
                patient.getGender(),
                patient.getContactNumber(),
                patient.getDistrict(),
                patient.getHospitalName(),
                patient.getEmail(),
                patient.getHomeAddress()
        );
    }
}
