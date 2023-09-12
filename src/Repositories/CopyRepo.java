package Repositories;

import Domains.Person;
import Domains.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CopyRepo {
    public static ResultSet getCopyBy(String columnLabel, String value ) throws SQLException {
        return (ResultSet) _Db.queryDatabase(
                String.format("Select c.id, b.isbn, b.title, b.quantity, b.available, b.borrowed, b.lost, b.price, b.author from copies c , books b " +
                        "where c.bookIsbn = b.isbn " +
                        "and c.status = 'available' " +
                        "and c.%s like '%s' limit 1;", columnLabel , value),
                "ResultSet"
        );
    }
}
