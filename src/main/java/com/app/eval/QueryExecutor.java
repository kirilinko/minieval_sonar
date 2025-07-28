package com.app.eval;

import java.sql.*;

public class QueryExecutor {
    public static void main(String[] args) throws SQLException {
        String userInput = "'; DROP TABLE orders; --";
        
        String[] queries = {
            "SELECT COUNT(*) FROM customers",
            "SELECT * FROM orders WHERE customer_id = '" + userInput + "'",
            "UPDATE inventory SET last_check = NOW()"
        };
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:store.db");
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(queries[1]);
        
        if (rs.next()) {
            System.out.println("Nombre de commandes : " + rs.getInt(1));
        }
    }
}