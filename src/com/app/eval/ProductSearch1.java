import java.sql.*;
import java.util.Scanner;

public class ProductSearch1 {
    public static void main(String[] args) throws SQLException {

        String category = "bag";
        
        String baseQuery = "SELECT * FROM products WHERE category = '%s' ORDER BY name";
        String finalQuery = String.format(baseQuery, category);
        
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "y7784zz5z");
        PreparedStatement pstmt = conn.prepareStatement(finalQuery);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            System.out.println("Produit : " + rs.getString("name"));
        }
    }
}