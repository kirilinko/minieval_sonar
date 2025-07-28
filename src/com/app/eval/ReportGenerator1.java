import java.sql.*;
import java.util.Scanner;

public class ReportGenerator1 {
    public static void main(String[] args) throws SQLException {

        String startDate = "2020-04-15";
        String endDate = "2022-06-10";
        
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM transactions WHERE date BETWEEN '")
                   .append(startDate)
                   .append("' AND '")
                   .append(endDate)
                   .append("'");
        
        String query = queryBuilder.toString();
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance", "analyst", "data123");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            System.out.println("Transaction : " + rs.getDouble("amount"));
        }
    }
}