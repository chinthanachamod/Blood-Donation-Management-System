package org.example.backend.dto;

public class PatientRequestDTO {

    private Long id;
    private String patientName;
    private String bloodGroup;
    private int requestedPints;
    private String hospital;
    private String contact;
    private String status; // "PENDING", "ACCEPTED", "DENIED"

    public PatientRequestDTO() {
    }

    public PatientRequestDTO(Long id, String patientName, String bloodGroup, int requestedPints, String hospital,
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

    // to String

    @Override
    public String toString() {
        return "PatientRequestDTO{" +
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
