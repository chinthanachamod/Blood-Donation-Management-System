package org.example.backend.controller;

import org.example.backend.dto.PatientAppointmentDTO;
import org.example.backend.dto.PatientRequestDTO;
import org.example.backend.service.PatientAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patientAppointments")
@CrossOrigin(origins = "*") // Allow frontend to access the API
public class PatientAppointmentController {

    @Autowired
    private PatientAppointmentService patientAppointmentService;

    // Get all patient appointments
    @GetMapping("/getAll")
    public List<PatientAppointmentDTO> getAllAppointments() {
        return patientAppointmentService.getAllAppointments();
    }

    // Accept a patient appointment
    @PutMapping("/accept/{appointmentId}")
    public ResponseEntity<PatientAppointmentDTO> acceptAppointment(@PathVariable Long appointmentId) {
        PatientAppointmentDTO appointmentDTO = patientAppointmentService.acceptAppointment(appointmentId);
        return ResponseEntity.ok(appointmentDTO);
    }

    // Reject a patient appointment
    @DeleteMapping("/reject/{appointmentId}")
    public ResponseEntity<String> rejectAppointment(@PathVariable Long appointmentId) {
        patientAppointmentService.rejectAppointment(appointmentId);
        return ResponseEntity.ok("Appointment rejected successfully.");
    }

    // Get a specific patient appointment by ID
    @GetMapping("/{appointmentId}")
    public ResponseEntity<PatientAppointmentDTO> getAppointmentById(@PathVariable Long appointmentId) {
        try {
            PatientAppointmentDTO appointmentDTO = patientAppointmentService.getAppointmentById(appointmentId);
            return ResponseEntity.ok(appointmentDTO);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create patient appointment from request
    @PostMapping("/fromRequest")
    public ResponseEntity<PatientAppointmentDTO> createFromRequest(@RequestBody PatientRequestDTO requestDTO) {
        PatientAppointmentDTO appointment = patientAppointmentService.createAppointmentFromRequest(requestDTO);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }
}
