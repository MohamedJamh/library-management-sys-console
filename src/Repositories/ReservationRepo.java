package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ReservationRepo {
    public static ResultSet getLastReservation() throws SQLException {
        return (ResultSet) _Db.queryDatabase("select id,date from reservations order by id desc LIMIT 1;",
                "ResultSet");
    }
    public static int addReservation(int copyId, String userCin) throws SQLException {
         return (int) _Db.queryDatabase(
                String.format("update copies set status = 'borrowed', userCin = '%s' where id = '%s';", userCin , copyId),
                "Int"
        );
    }
}
