package org.example.backend.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "patient_requests")
public class PatientRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "requested_pints", nullable = false)
    private int requestedPints;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contact;

    @Column(name = "urgency_level", nullable = false)
    private String urgencyLevel;

    @Column(nullable = false)
    private String status; // PENDING, ACCEPTED, DENIED

    // Constructors
    public PatientRequest() {
    }

    public PatientRequest(Long id, String patientName, String bloodGroup, int requestedPints, String email,
                          String contact, String urgencyLevel, String status) {
        this.id = id;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.requestedPints = requestedPints;
        this.email = email;
        this.contact = contact;
        this.urgencyLevel = urgencyLevel;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
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
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", urgencyLevel='" + urgencyLevel + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
