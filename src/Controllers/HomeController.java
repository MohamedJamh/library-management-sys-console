package Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Services.AuthenticationService;
public class HomeController {
    public static int menu(){
        Scanner myScanner = new Scanner(System.in);

        String choice;
        do {
            System.out.println("---------- MENU ----------");
            System.out.println("1 - List All Available Books: 1");
            System.out.println("2 - Search For a Certain Domain.Book: 2");
            System.out.println("3 - Borrow a Domain.Book: 3");
            System.out.println("4 - Borrow a Domain.Book: 4");
            if(AuthenticationService.user.isAdmin()){
                System.out.println("5 - Add new Books: 5");
                System.out.println("6 - Update Books: 6");
                System.out.println("7 - Delete Books: 7");
                System.out.println("8 - List a Domain.Book's Details: 8");
                System.out.println("9 - List All Borrowed Books: 9");
                System.out.println("10 - Generate Statistics: 10");
            }
            System.out.println("11 - Exit: key press");
            System.out.println("Please Enter Your Choice : ");
            choice = myScanner.nextLine();
            switch (choice){
                case "1" :{

                }
                case "2" :{

                }
                case "3" :{

                }
                case "4" :{

                }
                case "5" : {
                    BookController.AddBook();
                }
                case "6" :{
                }
                case "7" :{
                }
                case "8" :{
                }
                case "9" :{
                }
                case "10" :{
                }
                default:{
                    System.exit(0);
                }
            }
        }while (true);
    }
}
