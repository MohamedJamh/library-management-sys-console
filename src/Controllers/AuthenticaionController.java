package Controllers;
import Services.AuthenticationService;

import java.util.Scanner;

public class AuthenticaionController {
    public static void login(){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("---------- LOGIN ----------");
        System.out.println("Enter your username ( hint: firstname ) : ");
//        String username = myScanner.nextLine();
        String username = "aaa";
        System.out.println("Enter your password : ");
//        String password = myScanner.nextLine();
        String password = "aaa";

        AuthenticationService.login(username, password);
    }
    public static void logout(){
//        logout here
    }

}
