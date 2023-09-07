import java.io.Console;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Authentication {

    public static Person login(){
        do {
            System.out.println("---------- LOGIN ----------");
            System.out.println("Enter your username ( hint: firstname ) : ");
//            String first_name = Main.myScanner.nextLine();
            String first_name = "aaa";
            System.out.println("Enter your password : ");
//            String password = Main.myScanner.nextLine();
            String password = "aaa";

            try {
                String sql = "SELECT * FROM users WHERE first_name like ? AND PASSWORD LIKE ? ;";
                ArrayList<Object> parameters = new ArrayList<>();
                parameters.add(first_name);
                parameters.add(password);
                ResultSet set = (ResultSet) Db.queryDatabase(sql,parameters,"ResultSet");
                if (set.next()){
                    System.out.println("correct");
                    return new Person(
                            set.getString("cin"),
                            set.getString("first_name"),
                            set.getString("last_name"),
                            set.getString("phone"),
                            set.getBoolean("banned"),
                            set.getBoolean("is_admin"));
                }else{
                    System.out.println("Incorrect Username or Password ;");
                    Thread.sleep(1000);
//                    clear console here
                }
            } catch (SQLException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while (true);
    }


}
