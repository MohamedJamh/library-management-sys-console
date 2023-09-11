package Controllers;

import Domains.Person;
import Services.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    private static final Scanner myScanner = new Scanner(System.in);
    public static Person addUser(String cin){
        ArrayList<Object> parameters = new ArrayList<>();
        System.out.println("---------- ADD A USER ----------");
        if(cin.isEmpty()){
            System.out.println("Cin : ");
            parameters.add(myScanner.nextLine());
        }else parameters.add(cin);
        System.out.println("First Name: ");
        parameters.add(myScanner.nextLine()); // used as username while authenticating
        System.out.println("Last Name: ");
        parameters.add(myScanner.nextLine());
        System.out.println("Phone: ");
        parameters.add(myScanner.nextLine());
        System.out.println("Password: ");
        parameters.add(myScanner.nextLine());
        Person person = UserService.addUser(parameters);
        if( person != null){
            System.out.println("--- Info : Book has been added ");
            return person;
        }
        return null;
    }
}
