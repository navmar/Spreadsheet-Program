import java.util.List;
public interface FileToBookProcessor
{
    List<String> readTextFromFile() throws Exception;
    Book generateBook(List<String> textToDecode);
    void setFilePath(String path);


}
