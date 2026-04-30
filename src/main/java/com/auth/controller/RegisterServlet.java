package com.auth.controller;

import java.io.IOException;
import java.sql.*;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

import com.auth.util.DBUtil;
import com.auth.util.EmailService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection con = DBUtil.getConnection();

            // 🔐 HASH PASSWORD (IMPORTANT)
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            String otp = String.valueOf(new Random().nextInt(999999));

            PreparedStatement check = con.prepareStatement(
                "SELECT is_verified FROM users WHERE email=?"
            );
            check.setString(1, email);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {

                boolean verified = rs.getBoolean("is_verified");

                if (verified) {
                    request.setAttribute("error", "Email already registered.");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    return;
                }

                // 🔥 UPDATE OTP + PASSWORD (FIXED)
                PreparedStatement update = con.prepareStatement(
                    "UPDATE users SET otp=?, otp_created_at=NOW(), password=? WHERE email=?"
                );

                update.setString(1, otp);
                update.setString(2, hashedPassword); // 🔐 update hashed password
                update.setString(3, email);
                update.executeUpdate();

            } else {

                PreparedStatement insert = con.prepareStatement(
                    "INSERT INTO users(name,email,password,otp,otp_created_at,is_verified) VALUES(?,?,?,?,NOW(),false)"
                );

                insert.setString(1, name);
                insert.setString(2, email);
                insert.setString(3, hashedPassword); // 🔐 store hashed password
                insert.setString(4, otp);

                insert.executeUpdate();
            }

            EmailService.sendOTP(email, otp);

            HttpSession session = request.getSession();

            // 🔥 KEEP YOUR EXISTING SESSION LOGIC
            session.setAttribute("otpEmail", email);
            session.setAttribute("otpTime", System.currentTimeMillis());

            // 🔥 ALSO ADD (for verify servlet consistency)
            session.setAttribute("otpStartTime", System.currentTimeMillis());

            request.setAttribute("email", email);
            request.setAttribute("msg", "OTP sent successfully");

            request.getRequestDispatcher("verify.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}