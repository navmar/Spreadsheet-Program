import java.util.Scanner;
import java.util.List;

public class StartMenuImpl implements Menu
{
    Scanner scanner = new Scanner(System.in);
    private MainMenuImpl mainMenu = new MainMenuImpl();

    public StartMenuImpl()
    {

    }

    public void displayOptions()
    {
        System.out.println("1. Create a new book. ");
        System.out.println("2. Open an existing book. ");
    }

    public boolean handleInput()
    {
        System.out.println();
        System.out.print("Enter your choice: ");

        String option = scanner.nextLine();
        if (option.equals("1"))
        {
            Book book = new BookImpl();

            mainMenu.changeBook(book);
            mainMenu.loopOperations();
        }

        else if (option.equals("2"))
        {
            System.out.print("Enter the path of the book: ");
            String path = scanner.nextLine();

            FileToBookProcessor fp = FileToBookProcessorImpl.getInstance();
            fp.setFilePath(path);
            try
            {
                List<String> fileContent = fp.readTextFromFile();
                Book book = fp.generateBook(fileContent);

                mainMenu.changeBook(book);
                mainMenu.loopOperations();
            }
            catch(Exception e)
            {
                System.out.println("Error when reading file. ");
            }
        }
        return true;
    }


    public void loopOperations()
    {
        boolean cont = true;
        while (cont)
        {
            displayOptions();
            cont = handleInput();
        }

    }
}
