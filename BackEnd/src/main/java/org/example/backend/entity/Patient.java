package org.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

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

    public Patient() {
    }

    public Patient(Long id, String name, int age, String bloodGroup, String gender, String contactNumber,
                   String district, String email, String homeAddress, String hospitalName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.district = district;
        this.email = email;
        this.homeAddress = homeAddress;
        this.hospitalName = hospitalName;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", district='" + district + '\'' +
                ", email='" + email + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }
}
