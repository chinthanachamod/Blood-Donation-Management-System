package org.example.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "donor_appointments")
public class DonorAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String donorName;
    private String donorEmail;
    private String bloodGroup;
    private String contactNumber;
    private String hospitalName;
    private LocalDateTime appointmentDateTime;

    private String status; // e.g., Confirmed, Pending

    public DonorAppointment() {
    }

    public DonorAppointment(Long id, String donorName, String donorEmail, String bloodGroup, String contactNumber,
                            String hospitalName, LocalDateTime appointmentDateTime, String status) {
        this.id = id;
        this.donorName = donorName;
        this.donorEmail = donorEmail;
        this.bloodGroup = bloodGroup;
        this.contactNumber = contactNumber;
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

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
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
        return "DonorAppointment{" +
                "id=" + id +
                ", donorName='" + donorName + '\'' +
                ", donorEmail='" + donorEmail + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", status='" + status + '\'' +
                '}';
    }
}
