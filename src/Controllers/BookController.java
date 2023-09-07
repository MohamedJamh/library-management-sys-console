package Controllers;

import Services.BookService;

import java.util.ArrayList;
import java.util.Scanner;

public class BookController {

    public static void AddBook(){
        Scanner myScanner = new Scanner(System.in);
        ArrayList<Object> book = new ArrayList<>();

        System.out.println("---------- ADD BOOKS ----------");
        System.out.println("Please insert books details in this order: \b");
        System.out.println("Isbn :");
        book.add(myScanner.nextLine());
//        System.out.println("Title :");
//        book.add(myScanner.nextLine());
//        boolean validated;
//        do {
//            validated = true;
//            try {
//                System.out.println("Quantity :");
//                book.add(Integer.parseInt(myScanner.nextLine()));
//                System.out.println("Available :");
//                book.add(Integer.parseInt(myScanner.nextLine()));
//                System.out.println("Borrowed :");
//                book.add(Integer.parseInt(myScanner.nextLine()));
//                System.out.println("Lost :");
//                book.add(Integer.parseInt(myScanner.nextLine()));
//                System.out.println("Price :");
//                book.add(Float.parseFloat(myScanner.nextLine()));
//            } catch (Exception e) {
//                System.out.println("Quantity & Available & Borrowed & Price should be numbers");
//                validated = false;
//            }
//        } while (!validated);
//
//        System.out.println("Author :");
//        book.add(myScanner.nextLine());
        BookService.AddBook(book);
    }
}
