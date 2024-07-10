import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

//csv writer

//confirmation msgs from each class here.
//throws exception

public class FileToBookProcessorImpl implements  FileToBookProcessor
{

    private static FileToBookProcessor instance = new FileToBookProcessorImpl();

    String filePath;

    private FileToBookProcessorImpl()
    {

    }


    public static FileToBookProcessor getInstance()
    {
        return instance;
    }


    public void setFilePath(String path)
    {
        filePath = path;
    }






    public List<String> readTextFromFile() throws Exception
    {
        List<String> fileContent = new ArrayList();
        try
        {
            fileContent = Files.readAllLines(Paths.get(filePath));
        }
        catch(Exception e)
        {

            throw e;


        }


        return fileContent;
    }

    public Book generateBook(List<String> textToDecode)
    {
        Book temporaryBook = new BookImpl();
        if (!textToDecode.isEmpty())
        {
            int rowNum = 0;
            int columnNum = 0;
            int spreadSheetNum = 0;


            temporaryBook.createNewSpreadsheet(true);

            try
            {
                for (String row : textToDecode)
                {

                    //System.out.println(rowNum + " " + columnNum);
                    if (!row.equals("*****"))
                    {
                        if (!row.equals("$$$$$"))
                        {

                            temporaryBook.openSpreadsheet(spreadSheetNum).navigateToCell(rowNum, columnNum).editContents(row, true);

                            columnNum += 1;
                        } else
                        {
                            rowNum += 1;
                            columnNum = 0;

                        }
                    } else
                    {
                        temporaryBook.createNewSpreadsheet(true);
                        spreadSheetNum += 1;
                        rowNum = 0;
                        columnNum = 0;
                    }


                }
                System.out.println("Data transferred succesfully");


            }
            catch (Exception e)
            {
                System.out.println("An error occured when generating the spreadsheet book. Please double check the entered data.");
            }

            //figure out the try catch logic

        }
        return temporaryBook;



    }
}
