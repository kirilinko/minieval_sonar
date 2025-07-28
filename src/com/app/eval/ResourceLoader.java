package com.app.eval;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public class ResourceLoader {
    public static void main(String[] args) throws IOException {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("resource", "..\\..\\windows\\system32\\drivers\\etc\\hosts");
        
        String resourceName = requestParams.get("resource");
        String baseResourcePath = "app/resources/";
        String fullPath = baseResourcePath + resourceName;
        
        File resourceFile = new File(fullPath);
        if (resourceFile.exists()) {
           
            FileInputStream fis = new FileInputStream(resourceFile);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(isr);

            String line;
            System.out.println("Contenu de la ressource :");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } else {
            System.out.println("Ressource non trouvée");
        }
    }
}