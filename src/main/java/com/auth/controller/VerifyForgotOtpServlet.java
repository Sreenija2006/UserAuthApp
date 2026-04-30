package com.auth.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.auth.util.DBUtil;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verifyForgot")
public class VerifyForgotOtpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String otp = request.getParameter("otp");

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT otp FROM users WHERE email=?"
            );

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getString("otp").equals(otp)) {
                response.sendRedirect("reset-password.jsp?email=" + email);
            } else {
                response.getWriter().println("Invalid OTP");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}