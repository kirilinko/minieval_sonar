package com.app.eval;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RedirectService {
    public static void main(String[] args) {
        String redirectUrl = "javascript:alert('XSS')";
        String pageTitle = "Page de redirection";
        
        String htmlResponse = "<html>" +
            "<head><title>" + pageTitle + "</title></head>" +
            "<body>" +
            "<a href='" + redirectUrl + "'>Cliquez ici</a>" +
            "</body>" +
            "</html>";
        
        System.out.println(htmlResponse);
    }
}