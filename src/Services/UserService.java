package Services;

import Domains.Person;
import Repositories.UserRepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    public static Person getUser(String cin){
        try {
            if(UserRepo.isExist(cin)){
                ResultSet set = UserRepo.getUser(cin);
                set.next();
                return new Person(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getBoolean(5),
                        set.getBoolean(6)
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static Person addUser(ArrayList<Object> person){
        try {
            if(!UserRepo.isExist(person.get(0).toString())){
                if(UserRepo.addUser(person)){
                    return new Person(
                            (String) person.get(0),
                            (String) person.get(1),
                            (String) person.get(2),
                            (String) person.get(3),
                            false,
                            false
                    );
                }
            }
            return null;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
