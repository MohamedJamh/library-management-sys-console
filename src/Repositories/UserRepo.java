package Repositories;

import Domains.Book;
import Domains.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepo {
    public static boolean isExist(String cin) throws SQLException {
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(cin);
        ResultSet set = (ResultSet) _Db.queryDatabase(
                "Select count(*) as count from users where cin like ? ;",
                parameters,
                "ResultSet"
        );
        set.next();
        int count = set.getInt("count");
        return count != 0;
    }
    public static ResultSet getUser(String cin) throws SQLException{
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(cin);
        return (ResultSet) _Db.queryDatabase(
                "Select cin, first_name, last_name, phone, banned, is_admin from users where cin like ? ;",
                parameters,
                "ResultSet"
        );
    }
    public static boolean addUser(ArrayList<Object> parameters) throws SQLException {
        int affectedRow = (int) _Db.queryDatabase(
                "insert into users values (?,?,?,?,0,0,?);",
                parameters,
                "Int"
        );
        return affectedRow != 0;
    }
}
