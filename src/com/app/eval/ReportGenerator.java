package com.app.eval;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {
    public static void main(String[] args) throws SQLException {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("sortBy", "date");
        requestParams.put("status", "active");
        
        String sortByParam = requestParams.get("sortBy");
        String status = requestParams.get("status");
        
        Map<String, String> allowedSortColumns = new HashMap<>();
        allowedSortColumns.put("name", "name");
        allowedSortColumns.put("date", "created_date");
        allowedSortColumns.put("price", "price");
        
        Map<String, String> allowedStatusValues = new HashMap<>();
        allowedStatusValues.put("active", "ACTIVE");
        allowedStatusValues.put("inactive", "INACTIVE");
        allowedStatusValues.put("pending", "PENDING");
        
        String sortByColumn = allowedSortColumns.get(sortByParam);
        String statusValue = allowedStatusValues.get(status);
        
        if (sortByColumn == null || statusValue == null) {
            System.out.println("Paramètres de tri ou de statut invalides");
            return;
        }
        
        String query = "SELECT * FROM orders WHERE status = ? ORDER BY " + sortByColumn;
        
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, statusValue);
        
        ResultSet rs = pstmt.executeQuery();
        
        System.out.println("Commandes triées par " + sortByParam + " :");
        while (rs.next()) {
            System.out.println("Commande #" + rs.getString("id") + " - " + rs.getString("amount"));
        }
        
        pstmt.close();
        conn.close();
    }
}