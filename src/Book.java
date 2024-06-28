public interface Book
{
    void showSpreadsheets();
    Spreadsheet openSpreadsheet(int spreadsheetNumber);
    void createNewSpreadsheet();
    void removeSpreadsheet(int spreadsheetNumber);
    boolean isEmpty();


}
