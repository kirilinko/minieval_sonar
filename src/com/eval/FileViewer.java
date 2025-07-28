package com.app.eval;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public class FileViewer {
    public static void main(String[] args) throws IOException {
       
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("filename", "../../../etc/passwd");
        
        String filename = requestParams.get("filename");
        String basePath = "/var/www/documents/";
        String fullPath = basePath + filename;
        
        FileInputStream fis = new FileInputStream(fullPath);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader reader = new BufferedReader(isr);

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}