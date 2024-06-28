
import java.util.List;
import java.util.ArrayList;

public class BookImpl implements Book
{
    private List<Spreadsheet> spreadsheets;

    public BookImpl()
    {
        spreadsheets = new ArrayList();
    }


    public boolean isEmpty()
    {
        if (spreadsheets.size() == 0)
        {
            return true;
        }
        else return false;
    }


    public void showSpreadsheets()
    {
            for (int i = 0; i < spreadsheets.size(); i++)
            {
                System.out.println("\t- " + (i + 1));

            }

    }


    public void createNewSpreadsheet()
    {
        Spreadsheet spreadsheet = new SpreadsheetImpl();
        spreadsheets.add(spreadsheet);
        System.out.println("Spreadsheet created.");
    }


    public void removeSpreadsheet(int spreadsheetNumber)
    {
        spreadsheets.remove(spreadsheetNumber);
        System.out.println("Spreadsheet removed");
    }


    public Spreadsheet openSpreadsheet(int spreadsheetNumber)
    {
        return spreadsheets.get(spreadsheetNumber);
    }


}
