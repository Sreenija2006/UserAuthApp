# 🔐 User Authentication System (JSP + Servlets + MySQL)

## 📌 Overview

This project is a complete user authentication system built using Java Servlets, JSP, and MySQL. It includes OTP-based email verification, secure login, and password reset functionality.

---

## 🚀 Features

* User Registration
* OTP Email Verification
* Login System
* Forgot Password (OTP based)
* Reset Password
* Session Management
* Secure Password Hashing (BCrypt)

---

## 🛠 Tech Stack

* Java (Servlets, JSP)
* MySQL
* JDBC
* HTML, CSS, JavaScript

---

## 🔒 Security Features

* Password hashing using BCrypt
* OTP expiration (5 minutes)
* Session-based authentication
* Verified users only login

---

## 🧩 Project Structure

UserAuthApp/
│
├── src/
│   └── com.auth.controller
│   └── com.auth.util
│
├── webapp/
│   ├── css/
│   ├── js/
│   ├── register.jsp
│   ├── login.jsp
│   ├── verify.jsp
│   ├── forgot.jsp
│   ├── reset.jsp
│   ├── home.jsp
│
├── README.md

---

## ⚙️ Setup Instructions

1. Clone the repository:
   git clone https://github.com/Sreenija2006/UserAuthApp.git

2. Import into Eclipse / IntelliJ

3. Configure MySQL database:
   Create table:

   CREATE TABLE users (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(100),
   email VARCHAR(100) UNIQUE,
   password VARCHAR(255),
   is_verified BOOLEAN DEFAULT FALSE,
   otp VARCHAR(10),
   otp_created_at TIMESTAMP
   );

4. Update DB credentials in DBUtil.java

5. Run on Apache Tomcat Server

---

## 📧 Email Configuration

Update EmailService.java:

* Use your Gmail
* Enable App Password
* Replace:
  [your_email@gmail.com](mailto:your_email@gmail.com)
  your_app_password

---

## 🎯 How It Works

1. User registers → OTP sent to email
2. User verifies OTP → account activated
3. User logs in → session created
4. Forgot password → OTP verification
5. Reset password → secure update

---

## 🧠 Key Concepts

* MVC Architecture (Servlet + JSP)
* JDBC Database Connectivity
* OTP Authentication
* Password Encryption
* Session Management

---
##########################outpput##################################

Landing Page

<img width="490" height="314" alt="landingpage" src="https://github.com/user-attachments/assets/d1dddab3-af10-461b-ac37-1f3fe659d21c" />
🔹 Register Page
<img width="482" height="412" alt="register" src="https://github.com/user-attachments/assets/698f2c7d-6267-45e0-bc5d-1972079d533a" />
🔹Otp Verification
<img width="723" height="639" alt="image" src="https://github.com/user-attachments/assets/c90f5b47-086b-426f-92ac-ae64e3f40d0a" />

🔹 Login Page
<img width="754" height="557" alt="image" src="https://github.com/user-attachments/assets/bac19a99-7a60-4b2b-99b8-6a7c399f7238" />
🔹Forgot Password
<img width="698" height="385" alt="image" src="https://github.com/user-attachments/assets/2299af67-d805-4211-b7be-30d289433b16" />























## 👨‍💻 Author

TAMBIREDDY SREENIJA



