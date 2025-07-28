import java.util.HashMap;
import java.util.Map;

public class UserProfile {
    public static void main(String[] args) {
       
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("username", "<script>alert('XSS')</script>");
        
        String username = requestParams.get("username");
        
        String safeUsername = username.replace("&", "&amp;")
                                     .replace("<", "<")
                                     .replace(">", ">")
                                     .replace("\"", "&quot;")
                                     .replace("'", "&#x27;");
        
        System.out.println("<html><body>");
        System.out.println("<h1>Bienvenue " + safeUsername + "</h1>");
        System.out.println("</body></html>");
    }
}