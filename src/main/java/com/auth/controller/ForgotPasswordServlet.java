package com.auth.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.auth.util.DBUtil;
import com.auth.util.EmailService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgot")
public class ForgotPasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");

        String otp = String.valueOf(new Random().nextInt(999999));

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET otp=? WHERE email=?"
            );

            ps.setString(1, otp);
            ps.setString(2, email);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                EmailService.sendOTP(email, otp);
                response.sendRedirect("reset-otp.jsp?email=" + email);
            } else {
                response.getWriter().println("Email not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}