package Services;

import Domains.Copy;
import Repositories.CopyRepo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CopyService {
    public static Copy getCopy(String searchBy, String value){
        try {
            ResultSet set = CopyRepo.getCopyBy(searchBy,value);
            if(set.next()){
                return new Copy(
                        set.getInt(0),
                        set.get
                )
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
