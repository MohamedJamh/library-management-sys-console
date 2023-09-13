import Repositories._Db;
import Controllers.AuthenticaionController;

import java.util.Scanner;
public class Main {
    private _Db mysql;
    public static void main(String[] args) {

        _Db mysql = new _Db();
        AuthenticaionController.login();
    }
}

