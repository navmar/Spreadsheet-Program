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

    public void editContents(String contentToAdd)
    {
        cellContents = contentToAdd;
    }


}
