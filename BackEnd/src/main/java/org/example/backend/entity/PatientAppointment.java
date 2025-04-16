package org.example.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "patient_appointments")
public class PatientAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String patientEmail;
    private String bloodGroup;
    private String contactNumber;
    private int requestedPints;
    private String hospitalName;

    private LocalDateTime appointmentDateTime;
    private String status; // "Accepted", "Rejected"

    public PatientAppointment() {
    }

    public PatientAppointment(Long id, String patientName, String patientEmail, String bloodGroup,
                              String contactNumber, int requestedPints, String hospitalName,
                              LocalDateTime appointmentDateTime, String status) {
        this.id = id;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
        this.bloodGroup = bloodGroup;
        this.contactNumber = contactNumber;
        this.requestedPints = requestedPints;
        this.hospitalName = hospitalName;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getRequestedPints() {
        return requestedPints;
    }

    public void setRequestedPints(int requestedPints) {
        this.requestedPints = requestedPints;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString

    @Override
    public String toString() {
        return "PatientAppointment{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", requestedPints=" + requestedPints +
                ", hospitalName='" + hospitalName + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", status='" + status + '\'' +
                '}';
    }
}
