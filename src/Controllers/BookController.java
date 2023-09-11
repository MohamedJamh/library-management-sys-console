package Controllers;

import Domains.Book;
import Domains.Person;
import Domains.Reservation;
import Services.BookService;
import Services.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookController {

    private static final Scanner myScanner = new Scanner(System.in);

    public static void showBooks(ArrayList<Book> books){
        System.out.println("+------------+--------------------------------+----------+-----------+----------+------+---------+-------------------+");
        System.out.println("|   ISBN     |            Title               | Quantity | Available | Borrowed | Lost |  Price  |      Author       |");
        System.out.println("+------------+--------------------------------+----------+-----------+----------+------+---------+-------------------+");
        for(Book book: books){
            System.out.printf("| %s |           %s               |    %d    |     %d     |    %d     |  %d   | %f  |     %s      |%n",
                    book.getIsbn(),
                    book.getTitle(),
                    book.getQuantity(),
                    book.getAvailable(),
                    book.getBorrowed(),
                    book.getLost(),
                    book.getPrice(),
                    book.getAuthor()
                    );
        }
        System.out.println("+------------+--------------------------------+----------+-----------+----------+------+---------+-------------------+");
    }
    public static void addBook(){
        ArrayList<Object> book = new ArrayList<>();
        boolean validated;

        System.out.println("---------- ADD BOOKS ----------");
        System.out.println("Please insert books details in this order: \b");
        System.out.println("Isbn :");
        book.add(myScanner.nextLine());
        System.out.println("Title :");
        book.add(myScanner.nextLine());
        do {
            validated = true;
            try {
                System.out.println("Quantity :");
                int quantity = Integer.parseInt(myScanner.nextLine());
                book.add(quantity);
                book.add(quantity); // available = quantity
                System.out.println("Price :");
                book.add(Float.parseFloat(myScanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Quantity & Available & Borrowed & Price should be numbers");
                validated = false;
            }
        } while (!validated);
        System.out.println("Author :");
        book.add(myScanner.nextLine());

        Book bookObj = BookService.addBook(book);
        if(bookObj != null) System.out.println("Book has been added .");
        else System.out.println("Book already exist");
        String choice;
        System.out.println("Add new Book - Press N .");
        System.out.println("Quit - Press key  .");
        choice = myScanner.nextLine();
        if(choice.equals("N")) addBook();
        else HomeController.menu();
    }
    public static void searchBook(){
        System.out.println("---------- BOOK DETAILS ----------");
        System.out.println("Search for book by : \b");
        System.out.println("1 - isbn : 1 \b");
        System.out.println("2 - title : 2 \b");
        System.out.println("3 - author : 3 \b");
        System.out.println("Quit : Key Press \b");



        String searchBy = myScanner.nextLine();
        System.out.println("Entre value: \b");
        String value = myScanner.nextLine();
        ArrayList<Book> bookArray = new ArrayList<Book>();
        switch (searchBy) {
            case "1" -> bookArray = BookService.searchForBook("isbn", value);
            case "2" ->  bookArray = BookService.searchForBook("title", value);
            case "3" -> bookArray = BookService.searchForBook("author", value);
            default -> HomeController.menu();
        }
        System.out.println(bookArray.size());
        if(bookArray.isEmpty()) System.out.println("Book not found");
        else BookController.showBooks(bookArray);
        HomeController.quit();
    }


    public static void listBooks(){
        System.out.println("---------- AVAILABLE BOOKS ----------");
        showBooks(BookService.listBooks());
        HomeController.quit();
    }
    public static void updateBook(){
        System.out.println("---------- UPDATE BOOK ----------");
        System.out.println("insert the book's isbn : ");
        String isbn = myScanner.nextLine();
        ArrayList<Book> bookArray = BookService.searchForBook("isbn",isbn);
        if( bookArray != null){
            Book book = bookArray.get(0);
            //Todo those scanses does not accept empty strings
            System.out.println("Update title (enter to skip) : ");
            String title = myScanner.next();
            System.out.println("Update author (enter to skip) : ");
            String author = myScanner.next();

            if(!title.isEmpty()) book.setTitle(title);
            if(!author.isEmpty()) book.setAuthor(author);
            boolean validated ;
            do {
                validated = true;
                try {
                    System.out.println("Update price (enter to skip) : ");
                    String price =  myScanner.next();
                    if(!price.isEmpty()) book.setPrice(Float.parseFloat(price));
                }catch (Exception e){
                    System.out.println(" ----- Warning :Price should be a number ----- ");
                    validated = false;
                }
            }while (!validated);
            if(BookService.updateBook(book) != null){
                System.out.println("Book has been printed succefully");
                showBooks(bookArray);
            }else{
                System.out.println("book has not been updated !");
            }
            HomeController.quit();

        }else{
            System.out.println("Book not found");
            HomeController.quit();
        }
    }

    public static void borrowBook(){
        System.out.println("---------- BORROWING A BOOK ----------");
        System.out.println("insert the book's isbn : ");
        String isbn = myScanner.nextLine();
        ArrayList<Book> bookArray = BookService.searchForBook("isbn",isbn);
        if( bookArray != null ){
            if(bookArray.get(0).getAvailable() != 0){
                System.out.println("User's cin : ");
                String cin = myScanner.nextLine();
                Person user = UserService.getUser(cin);
                if(user == null) user = UserController.addUser(cin);
                ArrayList<Object> reservation = new ArrayList<>();
//                reservation.add()
            }else System.out.println("Book copies has been expired");
        }else System.out.println("Book not found");

    }


}
