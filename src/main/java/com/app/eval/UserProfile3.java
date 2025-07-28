package com.app.eval;

import java.util.HashMap;
import java.util.Map;

public class UserProfile3 {
    public static void main(String[] args) {
        
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("username", "<script>alert('XSS')</script>");
        
        String username = requestParams.get("username");
        
        System.out.println("<html><body>");
        System.out.println("<h1>Bienvenue " + username + "</h1>");
        System.out.println("</body></html>");
    }
}