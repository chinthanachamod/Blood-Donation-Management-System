package org.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // ensures auto-incrementing primary keys.
    private Long id;

    // @Column(nullable = false) - constraints ensure required fields.
    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "contact_number", nullable = false, unique = true)
    private String contactNumber;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "hospital_name", nullable = false)
    private String hospitalName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "home_address", nullable = false)
    private String homeAddress;

    public Patient() {
    }

    public Patient(Long id, String patientName, int age, String bloodGroup, String gender, String contactNumber,
                   String district, String hospitalName, String email, String homeAddress) {
        this.id = id;
        this.patientName = patientName;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.district = district;
        this.hospitalName = hospitalName;
        this.email = email;
        this.homeAddress = homeAddress;
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
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

    // toString

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", age=" + age +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", district='" + district + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", email='" + email + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }
}
