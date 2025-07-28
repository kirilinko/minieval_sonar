package com.app.eval;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class SanitizedResourceLoader {
    public static void main(String[] args) throws IOException {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("fileId", "2");
 
        Map<String, String> allowedFiles = new HashMap<>();
        allowedFiles.put("1", "readme.txt");
        allowedFiles.put("2", "changelog.md");
        allowedFiles.put("3", "license.txt");

        String basePath = "/app/documents/";
        String fileId = requestParams.get("fileId");
        String filename = allowedFiles.get(fileId);

        if (filename == null) {
            System.out.println("Accès refusé : fichier non autorisé");
            return;
        }

        Path filePath = Path.of(basePath, filename);

        if (Files.isRegularFile(filePath)) {
            System.out.println("Contenu du fichier : " + filename);
 
            BufferedReader reader = Files.newBufferedReader(filePath, Charset.forName("UTF-8"));
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } finally {
                reader.close();
            }
        } else {
            System.out.println("Erreur : fichier introuvable ou invalide");
        }
    }
}