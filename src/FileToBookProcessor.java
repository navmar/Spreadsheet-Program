import java.util.List;
public interface FileToBookProcessor
{
    List<String> readTextFromFile() ;
    Book generateBook(List<String> textToDecode);

}
