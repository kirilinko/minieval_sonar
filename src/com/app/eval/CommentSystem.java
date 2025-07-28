import java.util.HashMap;
import java.util.Map;

public class CommentSystem {
    public static void main(String[] args) {
      
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("comment", "Hello <script>alert('XSS')</script> world");
        requestParams.put("author", "John'; alert('hack'); //");
        requestParams.put("url", "http://example.com?<script>alert('XSS')</script>");
        
        String userComment = requestParams.get("comment");
        String author = requestParams.get("author");
        String redirectUrl = requestParams.get("url");
        
        String htmlComment = simpleEscape(userComment);
        String htmlAttribute = simpleEscape(author);
        String uriComponent = simpleUrlEncode(redirectUrl);
        
        System.out.println("<div class='comment' data-author='" + htmlAttribute + "'>");
        System.out.println("<p>" + htmlComment + "</p>");
        System.out.println("<a href='/redirect?url=" + uriComponent + "'>Lien sécurisé</a>");
        System.out.println("</div>");
    }
    
    public static String simpleEscape(String input) {
        if (input == null) return null;
        return input.replace("&", "&amp;")
                   .replace("<", "<")
                   .replace(">", ">")
                   .replace("\"", "&quot;")
                   .replace("'", "&#x27;");
    }
 
    public static String simpleUrlEncode(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.' || c == '~') {
                sb.append(c);
            } else {
                sb.append(String.format("%%%02X", (int)c));
            }
        }
        return sb.toString();
    }
}