# Blood-Donation-Management-System
The Blood Donation Management System is a web-based application developed for my 2nd semester final project.

## Project Description

The Blood Donation Management System is a full-stack web application developed to simplify the process of blood donation by connecting donors, patients, and hospitals. It offers:
  1.Role-based access for Donors, Patients, and Hospitals (Admins).
  2.Blood request management and tracking.
  3.Donor appointment scheduling and email notifications.
  4.Centralized dashboard for hospitals to manage blood stock and requests.
This system ensures that patients can request the required blood group easily, and hospitals can manage donors efficiently. The application is built using Spring Boot (Backend), MySQL (Database), and HTML/CSS/Bootstrap (Frontend).

## Screenshots

1. Home Page
   
![image](https://github.com/user-attachments/assets/edba3fd0-c698-49e9-b545-6c0d5504d144)
![image](https://github.com/user-attachments/assets/58e7aa9f-da3f-47c5-b52f-52752c1a6563)

2. Donor Dashboard

![image](https://github.com/user-attachments/assets/132f134a-1e7e-4435-953e-5862f14dbbf9)
![image](https://github.com/user-attachments/assets/6734825f-5160-4754-b196-ce3553d74331)

3. Patient Dashboard

![image](https://github.com/user-attachments/assets/42f699a8-87a9-4740-8701-80316087a8c4)
![image](https://github.com/user-attachments/assets/13d2e41a-b164-4419-b17b-9871f05e2736)

4. Hospital Dashboard

![image](https://github.com/user-attachments/assets/6bddcfa6-d334-49fc-ae5d-91777b3d88dd)

5. Donor Requests

![image](https://github.com/user-attachments/assets/8ee0bc2a-b5fc-4fd1-bbf5-87e638b61a62)

6. Donor Appointment

![image](https://github.com/user-attachments/assets/881c3da8-cb31-4c00-814f-c405aa670464)

* The "patient requests" and "patient appointments" pages appear the same as on the donor side...


## Setup Instructions

### Prerequisites

* Java 17+
* Maven
* MySQL Server
* IntelliJ IDEA or any preferred IDE 

### Backend Setup (Spring Boot)
1. Clone the Repository - https://github.com/chinthanachamod/Blood-Donation-Management-System
2. Configure MySQL Database

Create a MySQL database named : blood_donation_ms
Update application.properties : 

1. spring.datasource.url=jdbc:mysql://localhost:3306/blood_donation_db
2. spring.datasource.username=yourUsername
3. spring.datasource.password=yourPassword
4. spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   
4. Run the Backend Application
     mvn spring-boot:run  (The backend will start at: http://localhost:8080)

### Frontend Setup (HTML/CSS/Bootstrap)
1. Navigate to the frontend folder
2. Open index.html in any browser to test locally.
3. Optionally serve using Live Server (VS Code) or a local server tool for better integration.

## Demo Video
Watch the complete walkthrough of the project : ... 

## Technologies Used

Java, Spring Boot, Spring Security
Hibernate, JPA
MySQL
HTML, CSS, Bootstrap
RESTful API

## Credits
Developed by: Chinthana Chamod For the 2nd Semester Final Project submission

## License
This project is for educational purposes. You are free to use it with attribution.




