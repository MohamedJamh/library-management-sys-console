package Controllers;

import Domains.Book;
import Domains.Reservation;

public class ReservationController {
    public static void showReceipt(Reservation reservation){
        System.out.println("+---------------------------------------+");
        System.out.println("|                Receipt                |");
        System.out.println("+---------------------------------------+");
        System.out.printf("| Reservation Reference :    %s |\n", reservation.getId());
        System.out.printf("| Reader Cin                 %s |\n", reservation.getBookCopy().getReservedByReader().getCin());
        System.out.printf("| Book Isbn                  %s |\n", reservation.getBookCopy().getBook().getIsbn());
        System.out.printf("| Copy Reference             %s |\n", reservation.getBookCopy().getId());
        System.out.printf("| Reservation Date     %s |\n", reservation.getDate());
        System.out.printf("| Return Date       %s |\n", reservation.getReturnDate());
        System.out.println("+--------------------------------+");

    }
}
