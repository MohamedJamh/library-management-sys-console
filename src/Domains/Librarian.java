package Domains;

public class Librarian extends Person {

    public Librarian(String cin,String firstName, String lastName, String phone, boolean banned, boolean isAdmin){
        super(cin,firstName,lastName, phone, banned, isAdmin);
    }


//    move to services
    public void addBooks(){}
    public void updateBook(){}
    public void deleteBook(){}
    public void listBorrowedBooks(){}
    public void renderStatistics(){}



}
