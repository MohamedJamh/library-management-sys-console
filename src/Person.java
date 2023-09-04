import java.util.List;

public class  Person {
    protected String cin;
    protected String firstName;
    protected String lastName;
    protected List<Reservation> reservations;

    public Person(String cin,String firstName, String lastName,Reservation reservation){
        this.cin = cin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservations.add(reservation);
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


    public void BorrowBooks(){}
    public void returnBooks(){}
    public void availableBooks(){}
    public void searchForBooks(){}

}
