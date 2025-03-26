package org.example.backend.dto;

import org.example.backend.enums.RequestStatus;

public class DonorRequestDTO {
    private Long id;
    private String donorName;
    private String bloodGroup;
    private String contactNumber;
    private String hospitalName;
    private RequestStatus status;

    public DonorRequestDTO() {
    }

    public DonorRequestDTO(Long id, String donorName, String bloodGroup, String contactNumber, String hospitalName, RequestStatus status) {
        this.id = id;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.contactNumber = contactNumber;
        this.hospitalName = hospitalName;
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

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    // toString()

    @Override
    public String toString() {
        return "DonorRequestDTO{" +
                "id=" + id +
                ", donorName='" + donorName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", status=" + status +
                '}';
    }
}
