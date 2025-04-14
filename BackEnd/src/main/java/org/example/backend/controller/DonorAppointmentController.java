package org.example.backend.controller;

import org.example.backend.dto.DonorAppointmentDTO;
import org.example.backend.dto.DonorRequestDTO;
import org.example.backend.service.DonorAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/donorAppointments")
@CrossOrigin(origins = "*") // Allow frontend to access the API
public class DonorAppointmentController {

    @Autowired
    private DonorAppointmentService donorAppointmentService;

    // Get all donor appointments
    @GetMapping("/getAll")
    public List<DonorAppointmentDTO> getAllAppointments() {
        return donorAppointmentService.getAllAppointments();
    }

    // Accept a donor appointment
    @PutMapping("/accept/{appointmentId}")
    public ResponseEntity<DonorAppointmentDTO> acceptAppointment(@PathVariable Long appointmentId) {
        //System.out.println("Acceped");
        DonorAppointmentDTO appointmentDTO = donorAppointmentService.acceptAppointment(appointmentId);
        return ResponseEntity.ok(appointmentDTO);
    }

    // Reject a donor appointment
    @DeleteMapping("/reject/{appointmentId}")
    public ResponseEntity<String> rejectAppointment(@PathVariable Long appointmentId) {
        donorAppointmentService.rejectAppointment(appointmentId);
        return ResponseEntity.ok("Appointment rejected successfully.");
    }

    // Get a specific donor appointment by ID
    @GetMapping("/{appointmentId}")
    public ResponseEntity<DonorAppointmentDTO> getAppointmentById(@PathVariable Long appointmentId) {
        try{
            DonorAppointmentDTO appointmentDTO = donorAppointmentService.getAppointmentById(appointmentId);
            return ResponseEntity.ok(appointmentDTO);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/donorAppointments/fromRequest")
    public ResponseEntity<DonorAppointmentDTO> createFromRequest(@RequestBody DonorRequestDTO requestDTO) {
        DonorAppointmentDTO appointment = donorAppointmentService.createAppointmentFromRequest(requestDTO);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }


}
