package com.app.eval;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserLogin {
    public static void main(String[] args) throws SQLException {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("username", "admin'; DROP TABLE users; --");
        requestParams.put("password", "password123");
        
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        
        String query = "SELECT id, username FROM users WHERE username = ? AND password = ?";
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdb", "root", "password");
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            System.out.println("Connexion réussie pour : " + rs.getString("username"));
        } else {
            System.out.println("Identifiants incorrects");
        }
        
        pstmt.close();
        conn.close();
    }
}