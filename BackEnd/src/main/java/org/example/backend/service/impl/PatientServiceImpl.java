package org.example.backend.service.impl;

import org.example.backend.dto.PatientDTO;
import org.example.backend.entity.Patient;
import org.example.backend.repository.PatientRepository;
import org.example.backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDTO registerPatient(PatientDTO patientDTO) {
        /*
         * Checks for existing patient using email or contact number.
         * Converts DTO to entity, saves it, and returns the saved DTO.
         */
        if (patientRepository.existsByEmail(patientDTO.getEmail())) {
            throw new RuntimeException("Email already registered.");
        }
        if (patientRepository.existsByContactNumber(patientDTO.getContactNumber())) {
            throw new RuntimeException("Contact number already registered.");
        }

        Patient patient = mapToEntity(patientDTO);
        patient = patientRepository.save(patient);

        if (patient != null) {
            System.out.println("Patient Registered Successfully");
            return mapToDTO(patient);
        } else {
            throw new RuntimeException("Patient registration failed.");
        }
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        // Retrieves all patients and maps them to DTOs
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        // Finds a patient by ID or throws an exception
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found."));
        return mapToDTO(patient);
    }

    @Override
    public List<PatientDTO> getPatientsByContactNumber(String contactNumber) {
        // Retrieves patients by contact number
        List<Patient> patients = patientRepository.findByContactNumber(contactNumber);
        return patients.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> getPatientsByEmail(String email) {
        // Retrieves patients by email
        List<Patient> patients = patientRepository.findByEmail(email);
        return patients.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void deletePatient(Long id) {
        // Deletes patient if exists, else throws exception
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found!");
        }
        patientRepository.deleteById(id);
    }

    // Converts Entity to DTO
    private PatientDTO mapToDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setPatientName(patient.getPatientName());
        dto.setAge(patient.getAge());
        dto.setBloodGroup(patient.getBloodGroup());
        dto.setGender(patient.getGender());
        dto.setContactNumber(patient.getContactNumber());
        dto.setDistrict(patient.getDistrict());
        dto.setHospitalName(patient.getHospitalName());
        dto.setEmail(patient.getEmail());
        dto.setHomeAddress(patient.getHomeAddress());
        dto.setRequiredPints(patient.getRequiredPints());
        dto.setUrgencyLevel(patient.getUrgencyLevel());
        return dto;
    }

    // Converts DTO to Entity
    private Patient mapToEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setPatientName(dto.getPatientName());
        patient.setAge(dto.getAge());
        patient.setBloodGroup(dto.getBloodGroup());
        patient.setGender(dto.getGender());
        patient.setContactNumber(dto.getContactNumber());
        patient.setDistrict(dto.getDistrict());
        patient.setHospitalName(dto.getHospitalName());
        patient.setEmail(dto.getEmail());
        patient.setHomeAddress(dto.getHomeAddress());
        patient.setRequiredPints(dto.getRequiredPints());
        patient.setUrgencyLevel(dto.getUrgencyLevel());
        return patient;
    }
}
