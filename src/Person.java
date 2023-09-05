import java.util.ArrayList;

public class  Person {
    protected String cin;
    protected String firstName;
    protected String lastName;
    protected ArrayList<Reservation> reservations = new ArrayList<>();

    public Person(String cin,String firstName, String lastName){
        this.cin = cin;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(Reservation reservations) {
        this.reservations.add(reservations);
    }


    public void BorrowBooks(){}
    public void returnBooks(){}
    public void availableBooks(){}
    public void searchForBooks(){}

    @Override
    public String toString() {
        return "Librarian{" +
                "cin='" + cin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reservations= " + reservations.size() +
                '}';
    }

}
