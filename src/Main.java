import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner myScanner = new Scanner(System.in);
    private Db mysql;

    public static void main(String[] args) {
        Db mysql = new Db();
        Person user = Authentication.login();
        menu(user);


    }
    public static void menu(Person user){
        String choice;
        do {
            System.out.println("---------- MENU ----------");
            System.out.println("1 - List All Available Books: 1");
            System.out.println("2 - Search For a Certain Book: 2");
            System.out.println("3 - Borrow a Book: 3");
            System.out.println("4 - Borrow a Book: 4");
            if(user.isAdmin()){
                System.out.println("5 - Add new Books: 5");
                System.out.println("6 - Update Books: 6");
                System.out.println("7 - Delete Books: 7");
                System.out.println("8 - List a Book's Details: 8");
                System.out.println("9 - List All Borrowed Books: 9");
                System.out.println("10 - Generate Statistics: 10");

            }
            System.out.println("11 - Exit: key press");
            System.out.println("Please Enter Your Choice : ");
            choice = Main.myScanner.nextLine();
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
                    ArrayList<Object> parameters = new ArrayList<>();

                    System.out.println("---------- ADD BOOKS ----------");
                    System.out.println("Please insert books details in this order: \b");
                    System.out.println("Isbn :");
                    parameters.add(Main.myScanner.nextLine());
                    System.out.println("Title :");
                    parameters.add(Main.myScanner.nextLine());

                    boolean validated = true;
                    do {
                        try {
                            System.out.println("Quantity :");
                            parameters.add(Integer.parseInt(Main.myScanner.nextLine()));
                            System.out.println("Available :");
                            parameters.add(Integer.parseInt(Main.myScanner.nextLine()));
                            System.out.println("Borrowed :");
                            parameters.add(Integer.parseInt(Main.myScanner.nextLine()));
                            System.out.println("Lost :");
                            parameters.add(Integer.parseInt(Main.myScanner.nextLine()));
                            System.out.println("Price :");
                            parameters.add(Float.parseFloat(Main.myScanner.nextLine()));
                        } catch (Exception e) {
                            System.out.println("Quantity & Available & Borrowed & Price should be numbers");
                            validated = false;
                        }
                    } while (!validated);

                    System.out.println("Author :");
                    parameters.add(Main.myScanner.nextLine());

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

//    public static void testObjects(){
//
//        Librarian librarian = new Librarian("JM000","Hamid","elahmadi","+212");
//        Reader reader = new Reader("JH444","Idder","jamh","+212");
//
//
//        System.out.println("------users------");
//        System.out.println(librarian);
//        System.out.println(reader);
//        System.out.println("------book------");
//
//        Book book1 = new Book("XCVSDF333","Harry Potter",4,4,0,0, 100.00F,"J.K Rolling");
//        System.out.println(book1);
//        System.out.println("------copies------");
//
//        ArrayList<Copy> copies = new ArrayList<>();
//        for (int i = 1; i <= book1.getAvailable(); i++) {
//            Copy copy = new Copy(i,book1);
//            copies.add(copy);
//            System.out.println(copy);
//        }
//        System.out.println("------ reservation ------");
//        System.out.println("Enter the copy number : ");
//        int copyId = Integer.parseInt(myScanner.nextLine());
//        Reservation res = new Reservation(1,copies.get(copyId - 1),"12/12/2020");
//        System.out.println(res);
//        reader.setReservations(res);
//        copies.get(copyId - 1).setReservedByReaderCin(reader);
//
//        System.out.println("------ reserved copy ------");
//        copies.get(copyId - 1).isBorrowed();
//        System.out.println(copies.get(copyId - 1));
//        System.out.println("------book collection after reservation------");
//        book1.setBorrowed(1);
//        System.out.println(book1);
//        System.out.println("------reader after reservation------");
//        System.out.println(reader);
//    }
}

