public interface BookToFileProcessor
{
    String generateString (Book book);
    void writeTextToFile(String text, String fileName);


}
