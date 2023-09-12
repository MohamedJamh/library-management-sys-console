package Services;

import Domains.Book;
import Domains.Copy;
import Repositories.CopyRepo;
import Repositories.UserRepo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CopyService {
    public static Copy getCopy(String searchBy, String value){
        try {
            ResultSet set = CopyRepo.getCopyBy(searchBy,value);
            if(set.next()){
                return new Copy(
                    set.getInt(1),
                    new Book(
                            set.getString(2),
                            set.getString(3),
                            set.getInt(4),
                            set.getInt(5),
                            set.getInt(6),
                            set.getInt(7),
                            set.getFloat(8),
                            set.getString(9)
                    )
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
