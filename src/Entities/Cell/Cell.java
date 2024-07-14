package Entities.Cell;

public interface Cell
{
    void displayContents();
    void editContents(String contentToAdd, boolean silentMode);
    String returnContents();

    //Is this redundant? Should I just have return contents and print the contents out? Is it okay to modularise this much?
}