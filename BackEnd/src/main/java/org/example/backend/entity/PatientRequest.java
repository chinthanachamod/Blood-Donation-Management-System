package org.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_requests")
public class PatientRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false)
    private int requestedPints;

    @Column(nullable = false)
    private String hospital;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String status; // "PENDING", "ACCEPTED", "DENIED"

    public PatientRequest() {
    }

    public PatientRequest(Long id, String patientName, String bloodGroup, int requestedPints, String hospital,
                          String contact, String status) {
        this.id = id;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.requestedPints = requestedPints;
        this.hospital = hospital;
        this.contact = contact;
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getRequestedPints() {
        return requestedPints;
    }

    public void setRequestedPints(int requestedPints) {
        this.requestedPints = requestedPints;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
        return "PatientRequest{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", requestedPints=" + requestedPints +
                ", hospital='" + hospital + '\'' +
                ", contact='" + contact + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
