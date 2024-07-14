package Entities.Cell;

public class CellImpl implements Cell
{
    private String cellContents;

    public CellImpl()
    {
        cellContents = "";
    }

    public void displayContents()
    {
        System.out.print(cellContents);
    }

    public void editContents(String contentToAdd, boolean silentMode)
    {
        cellContents = contentToAdd;
        if (!silentMode)
        {
            System.out.println("Entities.Cell.Cell Updated Successfully");
        }
    }

    public String returnContents()
    {
        return cellContents;
    }


}
