package com.app.eval;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public class FileManager {
    public static void main(String[] args) throws IOException {
       
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("index", "1");
        
        String[] allowedFiles = {
            "readme.txt",
            "../../../etc/shadow",
            "changelog.md"
        };
        
        int fileIndex = Integer.parseInt(requestParams.get("index"));
        String fileName = allowedFiles[fileIndex];
        String basePath = "/home/user/files/";
        String fullPath = basePath + fileName;
        
        FileInputStream fis = new FileInputStream(fullPath);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader bufferedReader = new BufferedReader(isr);
        
        System.out.println("Contenu :");
        String content;
        while ((content = bufferedReader.readLine()) != null) {
            System.out.println(content);
        }
        bufferedReader.close();
    }
}