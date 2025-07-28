import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class WebService {
    public static void main(String[] args) throws SQLException {
       
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");
        params.put("sort", "name");
        params.put("filter", "active=1' OR '1'='1");
        
        String filterValue = params.get("filter");
        String query = "SELECT * FROM profiles WHERE " + filterValue + " ORDER BY " + params.get("sort");
        
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/users", "app", "pass");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            System.out.println("Profil : " + rs.getString("username"));
        }
    }
}