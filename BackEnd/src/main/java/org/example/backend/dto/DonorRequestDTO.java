package org.example.backend.dto;

public class DonorRequestDTO {
    private Long id;
    private String donorName;
    private String bloodGroup;
    private String contact;
    private String hospital;
    private String status;

    public DonorRequestDTO() {
    }

    public DonorRequestDTO(Long id, String donorName, String bloodGroup, String contact, String hospital, String status) {
        this.id = id;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.contact = contact;
        this.hospital = hospital;
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString()

    @Override
    public String toString() {
        return "DonorRequestDTO{" +
                "id=" + id +
                ", donorName='" + donorName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contact='" + contact + '\'' +
                ", hospital='" + hospital + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
