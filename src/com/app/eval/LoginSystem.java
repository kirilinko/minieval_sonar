import java.sql.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) throws SQLException {
        
        String username = "Mark";
        String password = "X215ei09";
        
        String query = String.format("SELECT id FROM accounts WHERE login='%s' AND passwd='%s'", username, password);
        
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "useradmin", "4s5d8ea7");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.next()) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Identifiants incorrects");
        }
    }
}