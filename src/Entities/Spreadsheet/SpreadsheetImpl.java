package Entities.Spreadsheet;

import Entities.Cell.Cell;
import Entities.Cell.CellImpl;

public class SpreadsheetImpl implements Spreadsheet
{
    private Cell[][] matrix;

    //Create the spreadsheet; add cells
    public SpreadsheetImpl()
    {
        matrix = new Cell[5][5]; //get size values from user in the future
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

                System.out.print("[");
                matrix[i][j].displayContents();
                System.out.print("]");
            }
            System.out.println();
        }
    }


    public int returnNumOfColumns()
    {
        return 5;
    }

    public int returnNumOfRows()
    {
        return 5;
    }






}
