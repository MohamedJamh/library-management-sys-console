package Controllers;

import Domains.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CopyController {
    public static void showBorrowedCopies(ResultSet res){
        System.out.println("+---------------+-----------------------+----------------------+---------------+----------------------+---------------------+");
        System.out.println("|   Copy id     |         isbn          |         date         |      cin      |      first_name      |      last_name      |");
        System.out.println("+---------------+-----------------------+----------------------+---------------+----------------------+---------------------+");
        try{
            do {
                System.out.printf("| %s |           %s               |        %s        |     %s     |      %s       |     %s      |%n",
                        res.getString("copyId"),
                        res.getString("isbn"),
                        res.getString("date"),
                        res.getString("cin"),
                        res.getString("first_name"),
                        res.getString("last_name")
                );
            }while (res.next());
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("+---------------+-----------------------+----------------------+---------------+----------------------+---------------------+");

    }
}
