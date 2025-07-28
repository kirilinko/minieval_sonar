import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public class DocumentManager {
    public static void main(String[] args) throws IOException {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("docId", "../logs/system.log");
        
        String docId = requestParams.get("docId");
        String documentsDir = "C:\\server\\documents\\";
        String filePath = documentsDir + docId + ".txt";
        
        InputStreamReader fileReader = new InputStreamReader(new FileInputStream(filePath), Charset.forName("UTF-8"));
        BufferedReader reader = new BufferedReader(fileReader);
        
        System.out.println("Contenu du document :");
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}