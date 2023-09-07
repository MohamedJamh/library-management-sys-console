package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepo {
    public static boolean isExist(String isbn) throws SQLException {
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(isbn);
        ResultSet set = (ResultSet) _Db.queryDatabase(
                "Select count(*) as count from books where isbn like ? ;",
                parameters,
                "ResultSet"
        );
        set.next();
        int count = set.getInt("count");
        return count != 0;
    }
}
