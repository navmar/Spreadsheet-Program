import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

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


                    System.out.println("Enter the spreadsheet number to open. ");
                    int spreadSheetNum = Integer.parseInt(scanner.nextLine()) - 1;

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
                                System.out.println("Please enter a valid number.");
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

            }


            //Push


        }

    }
}