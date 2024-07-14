package Services.FileProcessing;

import Entities.Book.Book;

import java.nio.file.Files;
import java.nio.file.Paths;


public class BookToFileProcessorImpl implements BookToFileProcessor
{
    private static BookToFileProcessor instance = new BookToFileProcessorImpl();

    private BookToFileProcessorImpl()
    {

    }

    //SINGLETON FOR FILE RESOURCE MANAGEMENT
    public static BookToFileProcessor getInstance()
    {
        return instance;
    }



    //Create the string first
    public String generateString(Book book)
    {


        String bookContents = "";
        int numOfSpreadsheets = book.getNumOfSpreadsheets();
        System.out.println(numOfSpreadsheets);

        //Traverse spreadsheets
        for (int x = 0; x< numOfSpreadsheets; x++)
        {
            int rows = book.openSpreadsheet(x).returnNumOfRows();
            int columns = book.openSpreadsheet(x).returnNumOfColumns();


            //Traverse rows in the spreadsheet
            for (int y = 0; y< rows; y++)
            {
                //Traverse columns in the spreadsheet
                for (int z = 0; z<columns; z++)
                {
                    bookContents = bookContents + book.openSpreadsheet(x).navigateToCell(y, z).returnContents() + "\n";


                }
                //Follow the appropriate format of the file for reading later on
                bookContents = bookContents + "$$$$$" + "\n";

            }
            bookContents = bookContents + "*****" + "\n";

        }
        return bookContents;

    }



    //Write to file
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

