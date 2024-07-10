import java.nio.file.Files;
import java.nio.file.Paths;


public class BookToFileProcessorImpl implements BookToFileProcessor
{
    private static BookToFileProcessor instance = new BookToFileProcessorImpl();

    private BookToFileProcessorImpl()
    {

    }

    public static BookToFileProcessor getInstance()
    {
        return instance;
    }

    public String generateString(Book book)
    {

        //other option is to use try catch

        String bookContents = "";
        int numOfSpreadsheets = book.getNumOfSpreadsheets();
        System.out.println(numOfSpreadsheets);
        for (int x = 0; x< numOfSpreadsheets; x++)
        {
            int rows = book.openSpreadsheet(x).returnNumOfRows();
            int columns = book.openSpreadsheet(x).returnNumOfColumns();
            System.out.println(rows + " " + columns);
            for (int y = 0; y< rows; y++)
            {
                for (int z = 0; z<columns; z++)
                {
                    bookContents = bookContents + book.openSpreadsheet(x).navigateToCell(y, z).returnContents() + "\n";


                }
                bookContents = bookContents + "$$$$$" + "\n";

            }
            bookContents = bookContents + "*****" + "\n";

        }
        return bookContents;

    }



    public void writeTextToFile(String text, String fileName)
    {
        try
        {
            Files.writeString(Paths.get(fileName), text);
            System.out.println("File writing complete.");
        }
        catch(Exception e)
        {
            System.out.println("Error when generating file");
        }
    }
}

