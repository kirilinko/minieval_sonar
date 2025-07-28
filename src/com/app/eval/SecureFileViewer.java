import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class SecureFileViewer {
    public static void main(String[] args) throws IOException {
      
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("filename", "document1.txt");
        
        String filename = requestParams.get("filename");
        String basePath = "/var/www/documents/";
        
        if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
            System.out.println("Nom de fichier invalide");
            return;
        }
        
        Path fullPath = Path.of(basePath).resolve(filename).normalize();
        
        if (!fullPath.startsWith(Path.of(basePath))) {
            System.out.println("Accès refusé");
            return;
        }
        
        if (Files.exists(fullPath) && Files.isRegularFile(fullPath)) {
            BufferedReader reader = Files.newBufferedReader(fullPath);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } else {
            System.out.println("Fichier non trouvé");
        }
    }
}