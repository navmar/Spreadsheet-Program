

public class SpreadsheetImpl implements Spreadsheet
{
    private Cell[][] matrix;

    //Create the spreadsheet; add cells
    public SpreadsheetImpl()
    {
        matrix = new Cell[5][5];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                matrix[i][j] = new CellImpl();
            }
        }
    }

    public Cell navigateToCell(int row, int column)
    {
       return matrix[row][column];
    }

    //Show all the cells
    public void showAllCells()
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {

                matrix[i][j].displayContents();
                System.out.print("\t\t\t\t");
            }
            System.out.println();
        }
    }




}
