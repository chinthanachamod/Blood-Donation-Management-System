package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.example.backend.enums.RequestStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "donor_requests")
@Builder
public class DonorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String donorName;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false, unique = true)
    private String contact;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String hospitalName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(nullable = false)
    private LocalDateTime requestDate;

    public DonorRequest() {
    }

    public DonorRequest(Long id, String donorName, String bloodGroup, String contact, String email,
                        String hospitalName, RequestStatus status, LocalDateTime requestDate) {
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
        return "DonorRequest{" +
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
