import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public class DownloadService {
    public static void main(String[] args) throws IOException {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("file", "../../config/database.properties");
        
        String requestedFile = requestParams.get("file");
        String downloadPath = "/app/uploads/" + requestedFile;
        
        File file = new File(downloadPath);
       
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader reader = new BufferedReader(isr);
        
        System.out.println("Contenu du fichier :");
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        
        reader.close();
    }
}