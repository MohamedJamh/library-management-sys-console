package Repositories;

import Domains.Person;
import Domains.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CopyRepo {
    public static ResultSet getCopyById(String id) throws SQLException{
        return (ResultSet) _Db.queryDatabase(
                String.format("Select c.id, b.isbn, b.title, b.quantity, b.available, b.borrowed, b.lost, b.price, b.author from copies c , books b " +
                        "where c.bookIsbn = b.isbn " +
                        "and c.id like '%s';", id ),
                "ResultSet"
        );
    }
    public static ResultSet getAvailableCopyBy(String columnLabel, String value ) throws SQLException {
        return (ResultSet) _Db.queryDatabase(
                String.format("Select c.id, b.isbn, b.title, b.quantity, b.available, b.borrowed, b.lost, b.price, b.author from copies c , books b " +
                        "where c.bookIsbn = b.isbn " +
                        "and c.status = 'available' " +
                        "and c.%s like '%s' limit 1;", columnLabel , value),
                "ResultSet"
        );
    }
    public static ResultSet getBorrowedCopies() throws SQLException{
        return (ResultSet) _Db.queryDatabase(
                """
                        SELECT c.id AS 'copyId', b.isbn, r.date, u.cin, u.first_name, u.last_name from copies c, users u, books b, reservations r \s
                        WHERE c.bookIsbn = b.isbn
                        AND c.id = r.copyId
                        AND c.userCin = u.cin
                        AND c.`status` = 'borrowed';""",
                "ResultSet");
    }
}
