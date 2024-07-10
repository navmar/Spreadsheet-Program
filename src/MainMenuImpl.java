
import java.util.Scanner;

public class MainMenuImpl implements Menu
{
    private Book book;

    Scanner scanner = new Scanner(System.in);

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
        //scanner
        System.out.println();
        System.out.print("Enter your choice: ");

        String option = scanner.nextLine();
        if (option.equals("1"))
        {
            book.createNewSpreadsheet(false);
        }

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
                    System.out.println("Invalid Spreadsheet Number");
                }
            }
        }
        else if (option.equals("5"))
        {
            return false;
        }

        else if (option.equals("6"))
        {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            String fileContent = BookToFileProcessorImpl.getInstance().generateString(book);
            BookToFileProcessorImpl.getInstance().writeTextToFile(fileContent, fileName);

        }
        return true;
    }

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
