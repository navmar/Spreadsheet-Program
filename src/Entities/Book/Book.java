package Entities.Book;

import Entities.Spreadsheet.Spreadsheet;

public interface Book
{
    void showSpreadsheets();
    Spreadsheet openSpreadsheet(int spreadsheetNumber);
    void createNewSpreadsheet(boolean silentMode);
    void removeSpreadsheet(int spreadsheetNumber);
    boolean isEmpty();
    int getNumOfSpreadsheets();


}
