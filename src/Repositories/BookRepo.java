package Repositories;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepo {
    public static int getCountBooks() throws SQLException{
        ResultSet set = (ResultSet) _Db.queryDatabase("Select count(*) from books ","ResultSet");
        set.next();
        return set.getInt("count(*)");
    }
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
    public static ResultSet getBookByIsbn(String isbn) throws SQLException{
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(isbn);
        return (ResultSet) _Db.queryDatabase(
                "Select * from books where isbn like ? ;",
                parameters,
                "ResultSet"
        );
    }
    public static ResultSet getBookBy(String columnLabel, String value ) throws SQLException{
        return (ResultSet) _Db.queryDatabase(
                String.format("Select * from books where %s like '%s';", columnLabel , value),
                "ResultSet"
        );
    }

    public static boolean addBook(ArrayList<Object> parameters) throws SQLException {
        int affectedRow = (int) _Db.queryDatabase(
                "insert into books values (?,?,?,?,0,0,?,?);",
                parameters,
                "Int"
        );
        return affectedRow != 0;
    }
    public static int updateBook(ArrayList<Object> parameters) throws SQLException{
        return (int) _Db.queryDatabase("update books set title = ?, author = ?, price = ? where isbn = ?",
                parameters,
                "Int");
    }
    public static ResultSet getAllBooks() throws SQLException{
        return (ResultSet) _Db.queryDatabase(
                "Select * from books",
                "ResultSet");
    }

    public static boolean deleteBook(String isbn) throws SQLException{
        return (boolean) _Db.queryDatabase(
                String.format("delete from books where isbn like '%s';", isbn),
                "Bool"
        );
    }

//    public static ResultSet getBookStatics(){
//
//    }

}
