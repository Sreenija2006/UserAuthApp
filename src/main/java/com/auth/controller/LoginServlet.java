package com.auth.controller;

import java.io.IOException;
import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

import com.auth.util.DBUtil;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT password, is_verified FROM users WHERE email=?"
            );

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String hashedPassword = rs.getString("password");
                boolean verified = rs.getBoolean("is_verified");

                //  (avoid null issues)
                if (hashedPassword != null && hashedPassword.startsWith("$2a$") 
                        && BCrypt.checkpw(password, hashedPassword)) {

                    if (!verified) {
                        request.setAttribute("error", "Please verify your account first.");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        return;
                    }

                    HttpSession session = request.getSession();
                    session.setAttribute("user", email);

                    response.sendRedirect("home.jsp");

                } else {
                    request.setAttribute("error", "Invalid password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("error", "User not found");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();

            // SHOW ERROR IN UI 
            response.setContentType("text/html");
            response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
