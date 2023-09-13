package Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Services.AuthenticationService;
public class HomeController {
    private static final Scanner myScanner = new Scanner(System.in);
    public static int menu(){

        String choice;
        do {
            System.out.println("---------- MENU ----------");
            System.out.println("1 - List All Available Books: 1");
            System.out.println("2 - Search For a Certain Book: 2");
            System.out.println("3 - Borrow a Book: 3");
            System.out.println("4 - Return a Book: 4");
            if(AuthenticationService.user.isAdmin()){
                System.out.println("5 - Add new Books: 5");
                System.out.println("6 - Update Books: 6");
                System.out.println("7 - Delete Books: 7");
                System.out.println("8 - List All Borrowed Books: 9");
                System.out.println("9 - Generate Statistics: 10");
            }
            System.out.println("10 - Exit: key press");
            System.out.println("Please Enter Your Choice : ");
            choice = myScanner.nextLine();
            switch (choice){
                case "1" -> BookController.listBooks();
                case "2" -> BookController.searchBook();
                case "3" -> BookController.borrowBook();
                case "4" -> BookController.returnBook();
                case "5" -> BookController.addBook();
                case "6" -> BookController.updateBook();
                case "7" -> BookController.deleteBook();
                case "8" -> BookController.listAllBorrowedBooks();
                case "9" -> HomeController.quit();
                default -> System.exit(0);
            }
        }while (true);
    }
    public static void quit(){
        System.out.println("Press key To Quit");
        myScanner.nextLine();
        menu();
    }
}
