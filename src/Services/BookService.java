package Services;

import java.sql.SQLException;
import java.util.ArrayList;
import Repositories.BookRepo;
public class BookService {

    public static boolean AddBook(ArrayList<Object> book){
        try {
            if(!BookRepo.isExist(book.get(0).toString())){
                System.out.println("book does not exist");
            }else{
                System.out.println("book exist");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
