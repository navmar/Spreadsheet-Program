import java.nio.file.Files;
import java.nio.file.Paths;

//csv writer



public class FileToSpreadsheetProcessorImpl implements FileToSpreadsheetProcessor
{
    String filePath;

    public FileToSpreadsheetProcessorImpl(String path)
    {
        filePath = path;
    }

    public String readTextFromFile()
    {
        String fileContent = "";
        try
        {
            fileContent = Files.readString(Paths.get(filePath));

           System.out.println(fileContent);
        }

        catch(Exception e)
        {
            System.out.println("Error.");
        }
        return fileContent;
    }

    public String decodeText()
    {
        return "";
    }
}
