import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Scanner myScanner = new Scanner(System.in);
    private static Connection connection;

    public static void main(String[] args) {
        connectToMysql();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                System.out.println("cin : " + resultSet.getString("cin")
                        + " name : " + resultSet.getString("first_name")
                        + resultSet.getString("last_name")
                );
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void connectToMysql(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ycminisas",
                    "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void disconnect(){
        connection.close();
    }
    public static void testObjects(){

        Librarian librarian = new Librarian("JM000","Hamid","elahmadi");
        Reader reader = new Reader("JH444","Idder","jamh","+212");


        System.out.println("------users------");
        System.out.println(librarian);
        System.out.println(reader);
        System.out.println("------book------");

        Book book1 = new Book("XCVSDF333","Harry Potter",4,4,0,0, 100.00F,"J.K Rolling");
        System.out.println(book1);
        System.out.println("------copies------");

        ArrayList<Copy> copies = new ArrayList<>();
        for (int i = 1; i <= book1.getAvailable(); i++) {
            Copy copy = new Copy(i,book1.getIsbn());
            copies.add(copy);
            System.out.println(copy);
        }
        System.out.println("------ reservation ------");
        System.out.println("Enter the copy number : ");
        int copyId = Integer.parseInt(myScanner.nextLine());
        Reservation res = new Reservation(1,copies.get(copyId - 1).getId(),"12/12/2020");
        System.out.println(res);
        reader.setReservations(res);
        copies.get(copyId - 1).setReservedByReaderCin(reader.getCin());

        System.out.println("------ reserved copy ------");
        copies.get(copyId - 1).isBorrowed();
        System.out.println(copies.get(copyId - 1));
        System.out.println("------book collection after reservation------");
        book1.setBorrowed(1);
        System.out.println(book1);
        System.out.println("------reader after reservation------");
        System.out.println(reader);
    }
}

