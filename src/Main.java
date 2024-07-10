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



//Try catch in file to book impl (if statement usage)
//Lack of try catch in booktofile
//file format
//silent mode
//show file reading and writing & singleton
//only thing remaining is user interaction
//notes on cells and booktofile class


//singleton for scanner
//csv values + handling of extra commas
//throwing the exception


//===========All comments above are for my reference ===============================//


public class Main
{
    public static void main(String[] args)
    {


            Menu startMenu = new StartMenuImpl();
            startMenu.loopOperations();
            //loop operations ensures after the user completes actions he will return back to the start menu






    }
}