package com.auth.controller;

import java.io.IOException;
import java.sql.*;
import java.util.Random;

import com.auth.util.DBUtil;
import com.auth.util.EmailService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/resend-otp")
public class ResendServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");

        try {
            Connection con = DBUtil.getConnection();

            String otp = String.valueOf(new Random().nextInt(999999));

            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET otp=?, otp_created_at=NOW() WHERE email=?"
            );

            ps.setString(1, otp);
            ps.setString(2, email);
            ps.executeUpdate();

            EmailService.sendOTP(email, otp);

            // ---------------- RESET TIMER ----------------
            HttpSession session = request.getSession();
            session.setAttribute("otpStartTime", System.currentTimeMillis());

            session.setAttribute("msg", "OTP resent successfully");

            response.sendRedirect("verify.jsp?email=" + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}