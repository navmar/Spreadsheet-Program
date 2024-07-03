//////Questions to Ask

//Discuss these first
//SOLID - Go through your understanding of it
//To better follow SRP - should I have created a menuhandler class?
//This is something on top of IPEA you need to consider no?

//Open/Closed is solely to do with abstraction and polymorphism (inheritance)?
//Need to consider it separately?

//Liskov - would this also automatically come when following abstraction  and implementing child classes correctly?
//Interface Segregation - also automatically will come with abstraction?

//Dependency Inversion is just polymorphism?

//Firstly follow IPEA and then SOLID? How to integrate this thought process into what I already do?

//Singleton does not directly implement SOLID - you must control this based on program spec.
// Lazy vs Eager
//How much on the singleton to know?  . multithreaded - concepts like breaking etc...?

//Factory design pattern - is it necessary for basic programs like this
//I need an example - if main purpose is to you don't know the type of object to create - why can't u use a switch statement and
//not go through factory classes


///////This program

//Show current program - feedback on features/ structure
//Ask on logic solution > try/catch
//Ask about while loop block try and catch
//Suggestions on how to display cells
//Discuss next steps - user to open book using path or create new book

////FILE WRITING PLAN
//Format for files
//Any recommended libraries for file writing /reading
//my own file writer & reader class -
// increase their functionality e.g. decode the format too? Will it violate single responsibility? Since it makes sense
//e.g. call it file processor not really?
////file writer as singleton?





import java.util.Scanner;
import java.io.FileWriter;


public class Main
{
    public static void main(String[] args)
    {

        FileToSpreadsheetProcessor fp = new FileToSpreadsheetProcessorImpl("Text.txt");
        fp.readTextFromFile();

        Scanner scanner = new Scanner(System.in);

        Book book = new BookImpl();

        while (true)
        {
            System.out.println();

            System.out.println("1. Create new spreadsheet");
            System.out.println("2. View spreadsheets");
            System.out.println("3. Delete a spreadsheet");
            System.out.println("4. Open a spreadsheet");

            System.out.println();
            System.out.print("Enter your choice: ");

            String option = scanner.nextLine();
            if (option.equals("1"))
            {
                book.createNewSpreadsheet();
            }

            else if (option.equals("2"))
            {
                if (book.isEmpty())
                {
                    System.out.println("No sheets to print");
                }

                else
                {
                    book.showSpreadsheets();
                }

            }

            else if (option.equals("3"))
            {
                if (book.isEmpty())
                {
                    System.out.println("No sheets to remove");
                }

                else
                {
                    try
                    {
                        System.out.println("Enter the spreadsheet number to remove. ");
                        int spreadSheetNum = Integer.parseInt(scanner.nextLine()) - 1; //this kind of inputting
                        //modularise code
                        book.removeSpreadsheet(spreadSheetNum);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Invalid spreadsheet number");
                    }
                }
            }



            else if (option.equals("4"))
            {
                if (book.isEmpty())
                {
                    System.out.println("No sheets to open");
                }

                else
                {

                    try //is it okay to encapsulate the entire while loop in the try block? Any try statements within will be given precedence for internal errors right?
                    {
                        System.out.println("Enter the spreadsheet number to open. ");
                        int spreadSheetNum = Integer.parseInt(scanner.nextLine()) - 1;
                        book.openSpreadsheet(spreadSheetNum); //is it okay to use this line of code to test validity? // to keep at moment but better solution later

                        while (true)
                        {
                            System.out.println();

                            System.out.println("Pick an operation: ");
                            System.out.println("1. Edit Cell");
                            System.out.println("2. View spreadsheet");
                            System.out.println("3. Go back");

                            System.out.print("Your choice: ");
                            String option2 = scanner.nextLine(); //Here chose to have a different name to prevent clash

                            if (option2.equals("1"))
                            {
                                String content = "";
                                int row; //example
                                int column;


                                try
                                {
                                    System.out.print("Row: ");
                                    row = Integer.parseInt(scanner.nextLine());

                                    System.out.print("Column: ");
                                    column = Integer.parseInt(scanner.nextLine());

                                    System.out.print("Content: ");
                                    content = scanner.nextLine();

                                    book.openSpreadsheet(spreadSheetNum).navigateToCell(row, column).editContents(content);


                                } catch (Exception e)
                                {
                                    System.out.println("Please enter a valid number for the row and column.");
                                }


                            } else if (option2.equals("2"))
                            {
                                System.out.println("");
                                book.openSpreadsheet(spreadSheetNum).showAllCells();
                            } else if (option2.equals("3"))
                            {
                                break;
                            }

                        }
                    }

                    catch(Exception e)
                    {
                        System.out.println("Invalid Spreadsheet Number");
                    }
                }

            }


            //Push


        }

    }
}