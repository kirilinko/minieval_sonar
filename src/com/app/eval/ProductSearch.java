import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ProductSearch {
    public static void main(String[] args) throws SQLException {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("category", "electronics'; DELETE FROM products; --");
        requestParams.put("limit", "10");
        
        String category = requestParams.get("category");
        String limitStr = requestParams.get("limit");
        
        if (!Pattern.matches("^[a-zA-Z0-9]+$", category)) {
            System.out.println("Catégorie invalide");
            return;
        }
        
        int limit;
        try {
            limit = Integer.parseInt(limitStr);
            if (limit < 1 || limit > 100) {
                System.out.println("Limite invalide");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Format de nombre invalide");
            return;
        }
        
        String query = "SELECT * FROM products WHERE category = ? ORDER BY name LIMIT ?";
        
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/store", "user", "pass");
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, category);
        pstmt.setInt(2, limit);
        
        ResultSet rs = pstmt.executeQuery();
        
        System.out.println("Produits trouvés :");
        while (rs.next()) {
            System.out.println("- " + rs.getString("name"));
        }
        
        pstmt.close();
        conn.close();
    }
}