package Services;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domains.Book;
import Repositories.BookRepo;
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
}
