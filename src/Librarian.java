public class Librarian extends Person{

    public Librarian(String cin,String firstName, String lastName,Reservation reservation){
        super(cin,firstName,lastName,reservation);
    }



    public void addBooks(){}
    public void updateBook(){}
    public void deleteBook(){}
    public void listBorrowedBooks(){}
    public void renderStatistics(){}


    @Override
    public String toString() {
        return "Librarian{" +
                "cin='" + cin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reservations=" + reservations.size() +
                '}';
    }
}
