import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Spreadsheet ss = new SpreadsheetImpl();


        Cell c = new CellImpl();
        c.editContents("Content");
        ss.navigateToCell(0, 0).editContents("Content");
        ss.navigateToCell(0, 1).editContents("Content");
        ss.navigateToCell(0, 2).editContents("Content");
        ss.navigateToCell(0, 3).editContents("Content");
        ss.navigateToCell(0, 4).editContents("Content");




        Scanner scanner = new Scanner(System.in);
        System.out.print("Row: ");
        int row = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Column: ");
        int column = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Content: ");
        String content = scanner.nextLine();

        ss.navigateToCell(row, column).editContents(content);








        ss.showAllCells();
    }
}