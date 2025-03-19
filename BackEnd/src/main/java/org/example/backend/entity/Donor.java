package org.example.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String donorName;

    @Column(nullable = false)
    private int donorAge;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String contactNumber;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String homeAddress;

    @Column(nullable = false)
    private String hospitalName;

    @Column(name = "last_donation_date")
    private LocalDate lastDonationDate;

    public Donor() {
    }

    public Donor(Long id, String donorName, int donorAge, String bloodGroup, String gender, String contactNumber,
                 String district, String email, String homeAddress, String hospitalName, LocalDate lastDonationDate) {
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

    @Override
    public String toString() {
        return "Donor{" +
                "id=" + id +
                ", donorName='" + donorName + '\'' +
                ", donorAge=" + donorAge +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", district='" + district + '\'' +
                ", email='" + email + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", lastDonationDate=" + lastDonationDate +
                '}';
    }
}
