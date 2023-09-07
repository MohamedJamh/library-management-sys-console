package Repositories;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthRepo {
    public static ResultSet login(ArrayList<Object> parameters) throws SQLException {
        String sql = "SELECT * FROM users WHERE first_name like ? AND PASSWORD LIKE ? ;";
        return (ResultSet) _Db.queryDatabase(sql,parameters,"ResultSet");
    }
}
