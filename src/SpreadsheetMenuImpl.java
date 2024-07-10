
import java.util.Scanner;

public class SpreadsheetMenuImpl implements Menu
{

    private Book book;
    private int spreadSheetNum;
    Scanner scanner = new Scanner(System.in);

    public SpreadsheetMenuImpl()
    {

    }

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
        else if (option2.equals("2"))
        {
            System.out.println("");
            book.openSpreadsheet(spreadSheetNum).showAllCells();
        }

        else if (option2.equals("3"))
        {
            return false;
        } //fix this

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
