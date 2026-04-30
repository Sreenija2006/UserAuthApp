package com.auth.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.mindrot.jbcrypt.BCrypt;

import com.auth.util.DBUtil;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String newPassword = request.getParameter("password");

        try {
            Connection con = DBUtil.getConnection();

            // HASH PASSWORD 
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET password=? WHERE email=?"
            );

            ps.setString(1, hashedPassword); // ✔ FIXED
            ps.setString(2, email);

            int rows = ps.executeUpdate();

            if (rows > 0) {
            	response.setContentType("text/html");

            	response.getWriter().println(
            	    "<!DOCTYPE html>" +
            	    "<html>" +
            	    "<head>" +
            	    "<style>" +
            	    "body {" +
            	    "  margin: 0;" +
            	    "  height: 100vh;" +
            	    "  display: flex;" +
            	    "  justify-content: center;" +
            	    "  align-items: center;" +
            	    "  background: linear-gradient(135deg, #667eea, #764ba2);" +
            	    "  font-family: Arial, sans-serif;" +
            	    "}" +

            	    ".card {" +
            	    "  background: white;" +
            	    "  padding: 30px;" +
            	    "  border-radius: 12px;" +
            	    "  box-shadow: 0 10px 25px rgba(0,0,0,0.2);" +
            	    "  text-align: center;" +
            	    "  width: 300px;" +
            	    "}" +

            	    ".card h2 {" +
            	    "  color: #333;" +
            	    "}" +

            	    ".card p {" +
            	    "  color: #666;" +
            	    "}" +

            	    ".btn {" +
            	    "  display: inline-block;" +
            	    "  margin-top: 20px;" +
            	    "  padding: 10px 20px;" +
            	    "  background: #667eea;" +
            	    "  color: white;" +
            	    "  text-decoration: none;" +
            	    "  border-radius: 6px;" +
            	    "}" +

            	    ".btn:hover {" +
            	    "  background: #5a67d8;" +
            	    "}" +

            	    "</style>" +
            	    "</head>" +

            	    "<body>" +
            	    "  <div class='card'>" +
            	    "    <h2>✅ Success</h2>" +
            	    "    <p>Password reset successful</p>" +
            	    "    <a class='btn' href='login.jsp'>Go to Login</a>" +
            	    "  </div>" +
            	    "</body>" +

            	    "</html>"
            	);
            
            } else {
                response.getWriter().println("Error resetting password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
