package com.app.eval;

import java.util.HashMap;
import java.util.Map;

public class UserProfile2 {
    public static void main(String[] args) {
       
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("username", "<script>alert('XSS')</script>");
        requestParams.put("title", "Profil utilisateur & spécial <test>");
        
        String username = requestParams.get("username");
        String title = requestParams.get("title");
        
        String safeUsername = encodeHtml(username);
        String safeTitle = encodeHtml(title);
        
        System.out.println("<html><head><title>" + safeTitle + "</title></head><body>");
        System.out.println("<h1>Bienvenue " + safeUsername + "</h1>");
        System.out.println("</body></html>");
    }
    
    public static String encodeHtml(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '&':
                    encoded.append("&amp;");
                    break;
                case '<':
                    encoded.append("<");
                    break;
                case '>':
                    encoded.append(">");
                    break;
                case '"':
                    encoded.append("&quot;");
                    break;
                case '\'':
                    encoded.append("&#x27;");
                    break;
                case '/':
                    encoded.append("&#x2F;");
                    break;
                default:
                    encoded.append(c);
                    break;
            }
        }
        return encoded.toString();
    }
}