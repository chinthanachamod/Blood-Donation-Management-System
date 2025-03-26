package org.example.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class DonorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "donor_name", nullable = false)
    private String donorName;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "hospital", nullable = false)
    private String hospital;

    @Column(name = "status")
    private String status = "Pending"; // Default value

    public DonorRequest() {
    }

    public DonorRequest(Long id, String donorName, String bloodGroup, String contact, String hospital, String status) {
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
        return "DonorRequest{" +
                "id=" + id +
                ", donorName='" + donorName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contact='" + contact + '\'' +
                ", hospital='" + hospital + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
