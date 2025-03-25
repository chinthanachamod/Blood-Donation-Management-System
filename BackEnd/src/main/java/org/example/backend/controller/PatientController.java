package org.example.backend.controller;

import org.example.backend.dto.PatientDTO;
import org.example.backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<PatientDTO> registerPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO savedPatient = patientService.registerPatient(patientDTO);
        return ResponseEntity.ok(savedPatient);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        PatientDTO patientDTO = patientService.getPatientById(id);
        return patientDTO != null ? ResponseEntity.ok(patientDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/patient-name/{patientName}")
    public ResponseEntity<List<PatientDTO>> getPatientsByPatientName(@PathVariable String patientName) {
        return ResponseEntity.ok(patientService.getPatientsByPatientName(patientName));
    }

    @GetMapping("/blood-group/{bloodGroup}")
    public ResponseEntity<List<PatientDTO>> getPatientsByBloodGroup(@PathVariable String bloodGroup) {
        return ResponseEntity.ok(patientService.getPatientsByBloodGroup(bloodGroup));
    }

    @GetMapping("/contact-number/{contactNumber}")
    public ResponseEntity<List<PatientDTO>> getPatientsByContactNumber(@PathVariable String contactNumber) {
        return ResponseEntity.ok(patientService.getPatientsByContactNumber(contactNumber));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<PatientDTO>> getPatientsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(patientService.getPatientsByEmail(email));
    }

    @GetMapping("/district/{district}")
    public ResponseEntity<List<PatientDTO>> getPatientsByDistrict(@PathVariable String district) {
        return ResponseEntity.ok(patientService.getPatientsByDistrict(district));
    }

    @GetMapping("/hospital/{hospitalName}")
    public ResponseEntity<List<PatientDTO>> getPatientsByHospital(@PathVariable String hospitalName) {
        return ResponseEntity.ok(patientService.getPatientsByHospital(hospitalName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}

