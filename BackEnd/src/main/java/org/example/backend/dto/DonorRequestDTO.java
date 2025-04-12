package org.example.backend.dto;

import org.example.backend.enums.RequestStatus;

import java.time.LocalDateTime;

public class DonorRequestDTO {

    private Long id;
    private String donorName;
    private String bloodGroup;
    private String contact;
    private String email;
    private String hospitalName;
    private RequestStatus status;
    private LocalDateTime requestDate;

    public DonorRequestDTO(Long id, String donorName, String bloodGroup, String contact,
                           String email, String hospitalName, RequestStatus status, LocalDateTime requestDate) {
        this.id = id;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.contact = contact;
        this.email = email;
        this.hospitalName = hospitalName;
        this.status = status;
        this.requestDate = requestDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    // toString

    @Override
    public String toString() {
        return "DonorRequestDTO{" +
                "id=" + id +
                ", donorName='" + donorName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", status=" + status +
                ", requestDate=" + requestDate +
                '}';
    }
}
