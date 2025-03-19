package org.example.backend.entity;

import jakarta.persistence.*;


public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospitalName;
    private String bloodType;
    private int pintsAvailable;

    public Hospital() {
    }

    public Hospital(String hospitalName, String bloodType, int pintsAvailable) {
        this.hospitalName = hospitalName;
        this.bloodType = bloodType;
        this.pintsAvailable = pintsAvailable;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getPintsAvailable() {
        return pintsAvailable;
    }

    public void setPintsAvailable(int pintsAvailable) {
        this.pintsAvailable = pintsAvailable;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", hospitalName='" + hospitalName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", pintsAvailable=" + pintsAvailable +
                '}';
    }
}
