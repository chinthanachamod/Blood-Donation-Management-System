package org.example.backend.controller;

import org.example.backend.dto.PatientDTO;
import org.example.backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // http://localhost:8080/api/v1/patients/register
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PatientDTO> registerPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO savedPatient = patientService.registerPatient(patientDTO);
        System.out.println("PatientDTO saved");
        return ResponseEntity.ok(savedPatient);
    }

    // http://localhost:8080/api/v1/patients/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // http://localhost:8080/api/v1/patients/1
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        PatientDTO patientDTO = patientService.getPatientById(id);
        return patientDTO != null ? ResponseEntity.ok(patientDTO) : ResponseEntity.notFound().build();
    }

    // http://localhost:8080/api/v1/patients/contact-number/{contactNumber}
    @GetMapping("/contact-number/{contactNumber}")
    public ResponseEntity<List<PatientDTO>> getPatientsByContactNumber(@PathVariable String contactNumber) {
        return ResponseEntity.ok(patientService.getPatientsByContactNumber(contactNumber));
    }

    // http://localhost:8080/api/v1/patients/email/{email}
    @GetMapping("/email/{email}")
    public ResponseEntity<List<PatientDTO>> getPatientsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(patientService.getPatientsByEmail(email));
    }

    // http://localhost:8080/api/v1/patients/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}

