
import java.util.Scanner;

public class SpreadsheetMenuImpl implements Menu
{

    private Book book;
    private int spreadSheetNum;
    Scanner scanner = new Scanner(System.in);

    public SpreadsheetMenuImpl()
    {

    }

    //When the user wants to reference a new book or change the spreadsheet number to look at
    public void changeBook(Book bookP)
    {
        book = bookP;
    }
    public void changeSpreadsheetNumber(int spreadSheetNumP)
    {
        spreadSheetNum = spreadSheetNumP;
    }



    public void displayOptions()
    {
        System.out.println();
        System.out.println("Pick an operation: ");
        System.out.println("1. Edit Cell");
        System.out.println("2. View spreadsheet");
        System.out.println("3. Go back");
    }

    public boolean handleInput()
    {

        System.out.print("Your choice: ");
        String option2 = scanner.nextLine();

        //Change data in the spreadsheet
        if (option2.equals("1"))
        {
            String content = "";
            int row;
            int column;


            try
            {
                System.out.print("Row: ");
                row = Integer.parseInt(scanner.nextLine());

                System.out.print("Column: ");
                column = Integer.parseInt(scanner.nextLine());

                System.out.print("Content: ");
                content = scanner.nextLine();

                book.openSpreadsheet(spreadSheetNum).navigateToCell(row, column).editContents(content, false);


            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid number for the row and column.");
            }


        }

        //Display all the data in the spreadsheet
        else if (option2.equals("2"))
        {
            System.out.println("");
            book.openSpreadsheet(spreadSheetNum).showAllCells();
        }

        //Break out of the loop and get back to the previous menu
        else if (option2.equals("3"))
        {
            return false;
        } //fix this

        return true;
    }

    //Handles returning back to the menu after some operations are complete
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
