package com.auth.controller;

import java.io.IOException;
import java.sql.*;

import com.auth.util.DBUtil;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/verify")
public class VerifyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String otp = request.getParameter("otp");

        try {
            Connection con = DBUtil.getConnection();

            HttpSession session = request.getSession();

            // ---------------- START TIME INIT ----------------
            if (session.getAttribute("otpStartTime") == null) {
                session.setAttribute("otpStartTime", System.currentTimeMillis());
            }

            long startTime = (Long) session.getAttribute("otpStartTime");

            PreparedStatement ps = con.prepareStatement(
                "SELECT otp FROM users WHERE email=?"
            );

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String dbOtp = rs.getString("otp");

                // ---------------- OTP EXPIRE CHECK ----------------
                long diff = (System.currentTimeMillis() - startTime) / 1000;

                if (diff > 300) {
                    request.setAttribute("error", "OTP expired. Please resend OTP.");
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("verify.jsp").forward(request, response);
                    return;
                }

                // ---------------- WRONG OTP ----------------
                if (!otp.equals(dbOtp)) {
                    request.setAttribute("error", "Invalid OTP");
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("verify.jsp").forward(request, response);
                    return;
                }

                // ---------------- SUCCESS ----------------
                PreparedStatement up = con.prepareStatement(
                    "UPDATE users SET is_verified=true, otp=NULL WHERE email=?"
                );

                up.setString(1, email);
                up.executeUpdate();

                session.removeAttribute("otpStartTime");

                response.sendRedirect("login.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}