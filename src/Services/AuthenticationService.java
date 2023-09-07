package Services;

import Controllers.HomeController;
import Domains.Person;
import Repositories.AuthRepo;
import Controllers.AuthenticaionController;

import java.net.Authenticator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthenticationService {

    public static Person user;

    public static void login(String username, String password){
        if(username.isEmpty() || password.isEmpty() ){
            System.out.println("Please fill all fields ! ");
            AuthenticaionController.login();
        }
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(username);
        parameters.add(password);
        try{
            ResultSet set = AuthRepo.login(parameters);
            if (set.next()){
                user = new Person(
                        set.getString("cin"),
                        set.getString("first_name"),
                        set.getString("last_name"),
                        set.getString("phone"),
                        set.getBoolean("banned"),
                        set.getBoolean("is_admin"));
                HomeController.menu();
            }else{
                System.out.println("Incorrect Username or Password ;");
                Thread.sleep(1000);
                AuthenticaionController.login();
            }
        } catch (SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

//        do {
//            try {
//
//
//            } catch (SQLException | InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }while (true);
    }


}
