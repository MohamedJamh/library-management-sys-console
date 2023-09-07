package Domains;

import java.util.ArrayList;

public class  Person {
    protected String cin;
    protected String firstName;
    protected String lastName;
    private String phone;
    private boolean banned = false;
    private boolean isAdmin = false;
    private String password;
    protected ArrayList<Reservation> reservations = new ArrayList<>();

    public Person(String cin,String firstName, String lastName, String phone, boolean banned, boolean isAdmin){
        this.cin = cin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.banned = banned;
        this.isAdmin = isAdmin;
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isBanned() {
        return banned;
    }
    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(Reservation reservations) {
        this.reservations.add(reservations);
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    public void BorrowBooks(){}
    public void returnBooks(){}
    public void availableBooks(){}
    public void searchForBooks(){}

    @Override
    public String toString() {
        return "Domain.Librarian{" +
                "cin='" + cin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reservations= " + reservations.size() +
                ", phone='" + phone + '\'' +
                ", banned=" + banned +
                '}';
    }

}
