package com.app.eval;

import java.sql.*;

public class UserService {
    public static void main(String[] args) throws SQLException {
        String email = "user@test.com";
        String query = "SELECT * FROM users WHERE email = '" + email + "' AND active = 1";
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdb", "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.next()) {
            System.out.println("Utilisateur trouvé : " + rs.getString("username"));
        } else {
            System.out.println("Aucun utilisateur trouvé");
        }
    }
}