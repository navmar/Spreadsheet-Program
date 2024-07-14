package Entities.Book;

import Entities.Spreadsheet.Spreadsheet;
import Entities.Spreadsheet.SpreadsheetImpl;

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
        else
        {
            return false;
        }
    }


    public void showSpreadsheets()
    {
            for (int i = 0; i < spreadsheets.size(); i++)
            {
                System.out.println("\t- " + (i + 1));

            }

    }


    public void createNewSpreadsheet(boolean silentMode)
    {
        Spreadsheet spreadsheet = new SpreadsheetImpl();
        spreadsheets.add(spreadsheet);
        if (!silentMode)
        {
            System.out.println("Entities.Spreadsheet.Spreadsheet created.");
        }
    }


    public void removeSpreadsheet(int spreadsheetNumber)
    {
        spreadsheets.remove(spreadsheetNumber);
        System.out.println("Entities.Spreadsheet.Spreadsheet removed");
    }


    public Spreadsheet openSpreadsheet(int spreadsheetNumber)
    {
        return spreadsheets.get(spreadsheetNumber);
    }

    public int getNumOfSpreadsheets()
    {
        return spreadsheets.size();
    }





}
