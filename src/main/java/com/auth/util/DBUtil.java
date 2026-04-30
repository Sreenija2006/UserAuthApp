package com.auth.util;

import java.sql.*;

public class DBUtil {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/user_auth",
            "root",
            "root123"
        );
    }
}