package org.example.backend.dto;

public class PatientDTO {

    private Long id;
    private String patientName;
    private int age;
    private String bloodGroup;
    private String gender;
    private String contactNumber;
    private String district;
    private String hospitalName;
    private String email;
    private String homeAddress;
    private int requiredPints;  // New property
    private String urgencyLevel; // New property (e.g., High, Medium, Low)

    public PatientDTO() {
    }

    public PatientDTO(Long id, String patientName, int age, String bloodGroup, String gender,
                      String contactNumber, String district, String hospitalName, String email,
                      String homeAddress, int requiredPints, String urgencyLevel) {
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
        this.requiredPints = requiredPints;
        this.urgencyLevel = urgencyLevel;
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

    public int getRequiredPints() {
        return requiredPints;
    }

    public void setRequiredPints(int requiredPints) {
        this.requiredPints = requiredPints;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    // toString()

    @Override
    public String toString() {
        return "PatientDTO{" +
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
                ", requiredPints=" + requiredPints +
                ", urgencyLevel='" + urgencyLevel + '\'' +
                '}';
    }
}
