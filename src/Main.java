import Domains.Person;
import Repositories._Db;
import Controllers.AuthenticaionController;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner myScanner = new Scanner(System.in);
    private _Db mysql;

    public static void main(String[] args) {
        _Db mysql = new _Db();
        AuthenticaionController.login();
//        Person user = AuthenticationService.login();
//        menu(user);


    }
    public static void menu(Person user){

    }

//    public static void testObjects(){
//
//        Domain.Librarian librarian = new Domain.Librarian("JM000","Hamid","elahmadi","+212");
//        Domain.Reader reader = new Domain.Reader("JH444","Idder","jamh","+212");
//
//
//        System.out.println("------users------");
//        System.out.println(librarian);
//        System.out.println(reader);
//        System.out.println("------book------");
//
//        Domain.Book book1 = new Domain.Book("XCVSDF333","Harry Potter",4,4,0,0, 100.00F,"J.K Rolling");
//        System.out.println(book1);
//        System.out.println("------copies------");
//
//        ArrayList<Domain.Copy> copies = new ArrayList<>();
//        for (int i = 1; i <= book1.getAvailable(); i++) {
//            Domain.Copy copy = new Domain.Copy(i,book1);
//            copies.add(copy);
//            System.out.println(copy);
//        }
//        System.out.println("------ reservation ------");
//        System.out.println("Enter the copy number : ");
//        int copyId = Integer.parseInt(myScanner.nextLine());
//        Domain.Reservation res = new Domain.Reservation(1,copies.get(copyId - 1),"12/12/2020");
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

