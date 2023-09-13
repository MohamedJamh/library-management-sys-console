package Services;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domains.Book;
import Domains.Copy;
import Domains.Person;
import Domains.Reservation;
import Repositories.BookRepo;
import Repositories.ReservationRepo;
import Repositories.UserRepo;
import Repositories._Db;

public class BookService {

    public static Book addBook(ArrayList<Object> book){
        try {
            if(!BookRepo.isExist(book.get(0).toString())){
                if(BookRepo.addBook(book)){
                    return new Book(
                            (String) book.get(0),
                            (String) book.get(1),
                            (int) book.get(3),
                            (int) book.get(3), // available = quantity
                            0,
                            0,
                            (float) book.get(4),
                            (String) book.get(5)
                    );
                };
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Book> searchForBook(String searchBy, String value){
        ArrayList<Book> booksArray = new ArrayList<>();
        try {
            ResultSet set = null;
            if(searchBy.equals("isbn") && BookRepo.isExist(value)){
                set = BookRepo.getBookByIsbn(value);
            }else if(searchBy.equals("title") || searchBy.equals("author")){
                set = BookRepo.getBookBy(searchBy,value);
            }
            if(set != null){
                while(set.next()){
                    booksArray.add(new Book(
                            set.getString("isbn"),
                            set.getString("title"),
                            set.getInt("quantity"),
                            set.getInt("available"),
                            set.getInt("borrowed"),
                            set.getInt("lost"),
                            set.getFloat("price"),
                            set.getString("author")
                    ));
                }
                return booksArray;
            }
            return null;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Book> listBooks(){
        try {
            ResultSet set = BookRepo.getAllBooks();
            ArrayList<Book> booksArray = new ArrayList<>();
            while(set.next()){
                booksArray.add(new Book(
                        set.getString("isbn"),
                        set.getString("title"),
                        set.getInt("quantity"),
                        set.getInt("available"),
                        set.getInt("borrowed"),
                        set.getInt("lost"),
                        set.getFloat("price"),
                        set.getString("author")
                ));
            }
            return booksArray;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Book updateBook(Book book){
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(book.getTitle());
        parameters.add(book.getAuthor());
        parameters.add(book.getPrice());
        parameters.add(book.getIsbn());
        try {
            int affectedRows = BookRepo.updateBook(parameters);
            if(affectedRows != 0) return book;
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Reservation borrowBook(Book book, Copy copy, Person user){
        try {
            if(ReservationRepo.addReservation(copy.getId(),user.getCin()) != 0){
                ResultSet reservationSet = ReservationRepo.getLastReservation();
                reservationSet.next();
                return new Reservation(
                    reservationSet.getInt("id"),
                        copy,
                        reservationSet.getString("date"),
                        "Borrowed",
                        reservationSet.getString("return_date")
                );
            };
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean returnBook(Reservation reservation){
        try{
            return ReservationRepo.returnBook(reservation.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean deleteBook(String isbn){
        try{
            if(BookRepo.isExist(isbn)){
                return BookRepo.deleteBook(isbn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public static ArrayList<Integer> getStatistics(){
        ArrayList<Integer> bookUserArray = new ArrayList<>();
        try {
            bookUserArray.add(BookRepo.getCountBooks());
            bookUserArray.add(UserRepo.getCountUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookUserArray;
    }

}
