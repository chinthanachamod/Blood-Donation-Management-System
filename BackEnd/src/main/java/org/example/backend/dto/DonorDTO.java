package org.example.backend.dto;

import java.time.LocalDate;

public class DonorDTO {
    private Long id;
    private String donorName;
    private int donorAge;
    private String bloodGroup;
    private String gender;
    private String contactNumber;
    private String district;
    private String email;
    private String homeAddress;
    private String hospitalName;
    private LocalDate lastDonationDate;

    public DonorDTO() {
    }

    public DonorDTO(Long id, String donorName, int donorAge, String bloodGroup, String gender, String contactNumber,
                    String district, String email, String homeAddress, String hospitalName,
                    LocalDate lastDonationDate) {
        this.id = id;
        this.donorName = donorName;
        this.donorAge = donorAge;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.district = district;
        this.email = email;
        this.homeAddress = homeAddress;
        this.hospitalName = hospitalName;
        this.lastDonationDate = lastDonationDate;
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

    public int getDonorAge() {
        return donorAge;
    }

    public void setDonorAge(int donorAge) {
        this.donorAge = donorAge;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }
}
