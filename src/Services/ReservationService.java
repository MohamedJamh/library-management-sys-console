package Services;

import Domains.Reservation;
import Repositories.ReservationRepo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationService {

    public static Reservation getReservation(String reference){
        try {
            ResultSet res = ReservationRepo.getReservation(reference);
            if(res.next()){
                return new Reservation(
                        res.getInt("id"),
                        CopyService.getCopyById(String.valueOf(res.getInt("copyId"))),
                        res.getString("date"),
                        res.getString("status"),
                        res.getString("return_date")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
