package org.example.backend.dto;

public class PatientRequestDTO {

    private Long id;
    private String patientName;
    private String bloodGroup;
    private int requestedPints;
    private String email;
    private String contact;
    private String urgencyLevel; // e.g., "High", "Medium", "Low"
    private String status; // "PENDING", "ACCEPTED", "DENIED"

    public PatientRequestDTO() {
    }

    public PatientRequestDTO(Long id, String patientName, String bloodGroup, int requestedPints, String email,
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
        return "PatientRequestDTO{" +
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
