package Services.Menu;//generic
import Entities.Book.Book;
import Services.FileProcessing.BookToFileProcessorImpl;

import java.util.Scanner;

public class MainMenuImpl implements Menu
{
    private Book book;

    Scanner scanner = new Scanner(System.in);

    //AGGREGATION - this menu contains a submenu that is the spreadsheet menu
    //I did this to prevent creating multiple instances of spreadsheet menu
    //I only have 1 spreadsheet menu object that can have its attributes i.e. book and spreadsheet number changed

    private SpreadsheetMenuImpl spreadsheetMenu = new SpreadsheetMenuImpl();


    public MainMenuImpl()
    {

    }

    public void changeBook(Book bookP)
    {
        book = bookP;
    }

    public void displayOptions()
    {
        System.out.println();

        System.out.println("1. Create new spreadsheet");
        System.out.println("2. View spreadsheets");
        System.out.println("3. Delete a spreadsheet");
        System.out.println("4. Open a spreadsheet");
        System.out.println("5. Go back to start menu");
        System.out.println("6. Save book");

    }


    public boolean handleInput()
    {

        System.out.println();
        System.out.print("Enter your choice: ");

        //Create new spreadsheet
        String option = scanner.nextLine();
        if (option.equals("1"))
        {
            book.createNewSpreadsheet(false);
        }

        //Show list of existing spreadsheets
        else if (option.equals("2"))
        {
            if (book.isEmpty())
            {
                System.out.println("No sheets to print");
            }
            else
            {
                book.showSpreadsheets();
            }

        }

        //Remove spreadsheets from the book
        else if (option.equals("3"))
        {
            if (book.isEmpty())
            {
                System.out.println("No sheets to remove");
            }

            else
            {
                try
                {
                    System.out.println("Enter the spreadsheet number to remove. ");
                    int spreadSheetNum = Integer.parseInt(scanner.nextLine()) - 1;
                    book.removeSpreadsheet(spreadSheetNum);
                }

                catch (Exception e)
                {
                    System.out.println("Invalid spreadsheet number");
                }
            }
        }

        //Open a spreadsheet to e.g. edit cells
        else if (option.equals("4"))
        {
            if (book.isEmpty())
            {
                System.out.println("No sheets to open");
            }

            else
            {
                try
                {
                    System.out.println("Enter the spreadsheet number to open. ");
                    int spreadSheetNum = Integer.parseInt(scanner.nextLine()) - 1;
                    book.openSpreadsheet(spreadSheetNum);

                    spreadsheetMenu.changeBook(book);
                    spreadsheetMenu.changeSpreadsheetNumber(spreadSheetNum);
                    spreadsheetMenu.loopOperations();


                }

                catch (Exception e)
                {
                    System.out.println("Invalid Entities.Spreadsheet.Spreadsheet Number");
                }
            }
        }

        //Leave and go back to the start menu
        else if (option.equals("5"))
        {
            return false;
        }

        //Save the contents of the book to a file
        else if (option.equals("6"))
        {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            String fileContent = BookToFileProcessorImpl.getInstance().generateString(book);
            BookToFileProcessorImpl.getInstance().writeTextToFile(fileContent, fileName);

        }
        return true;
    }


    //Same purpose as for spreadsheetmenu and start menu
    public void loopOperations()
    {
        boolean cont = true;
        while (cont)
        {
            displayOptions();
            cont = handleInput();
        }

    }



}
