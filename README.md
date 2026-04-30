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
<img width="1020" height="686" alt="image" src="https://github.com/user-attachments/assets/11617f06-8363-48ab-989c-f6239969b6c8" />

🔹 Login Page
<img width="457" height="308" alt="login" src="https://github.com/user-attachments/assets/bb0e474b-c021-4469-b22e-8ea8d8038051" />
🔹Forgot Password
<img width="909" height="564" alt="image" src="https://github.com/user-attachments/assets/2a3012f1-0189-4cc7-acda-efbf13b378fc" />
🔹Reset Password
<img width="364" height="259" alt="resetpassword" src="https://github.com/user-attachments/assets/0a8e50f3-abc5-4b0b-b30b-d02005c3df7d" />
🔹Password Reset succeessful
<img width="355" height="239" alt="resetsuccessful" src="https://github.com/user-attachments/assets/caaa8ea8-e210-4e0c-be6b-1052d654986f" />
🔹Home page

<img width="380" height="191" alt="home" src="https://github.com/user-attachments/assets/e4d366d4-583c-4eda-b133-ac042805af63" />


























## 👨‍💻 Author

TAMBIREDDY SREENIJA



