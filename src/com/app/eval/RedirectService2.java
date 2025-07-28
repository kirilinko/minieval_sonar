import java.util.HashMap;
import java.util.Map;

public class RedirectService2 {
    public static void main(String[] args) {
        // Simulation de paramètres de requête HTTP
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("redirect", "javascript:alert('XSS')");
        requestParams.put("title", "Page de redirection");
        
        String redirectUrl = requestParams.get("redirect");
        String pageTitle = requestParams.get("title");
        
        String htmlResponse = "<html>" +
            "<head><title>" + pageTitle + "</title></head>" +
            "<body>" +
            "<a href='" + redirectUrl + "'>Cliquez ici</a>" +
            "</body>" +
            "</html>";
        
        System.out.println(htmlResponse);
    }
}