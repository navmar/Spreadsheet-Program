package Entities.Spreadsheet;

import Entities.Cell.Cell;

public interface Spreadsheet
{
    Cell navigateToCell(int row, int column);

    void  showAllCells();


    int returnNumOfColumns();
    int returnNumOfRows();
}


