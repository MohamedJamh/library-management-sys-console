import Domains.Person;
import Repositories._Db;
import Controllers.AuthenticaionController;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner myScanner = new Scanner(System.in);
    private _Db mysql;

    public static void main(String[] args) {
        _Db mysql = new _Db();
        AuthenticaionController.login();

    }
}

