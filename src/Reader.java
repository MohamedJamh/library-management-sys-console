public final class  Reader extends Person {
    private String phone;
    private boolean banned = false;

    public Reader(String cin, String firstName, String lastName, String phone) {
        super(cin, firstName, lastName);
        this.phone = phone;
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

    @Override
    public String toString() {
        return "Reader{" +
                "phone='" + phone + '\'' +
                ", banned=" + banned +
                ", cin='" + cin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reservations= " + reservations.size() +
                '}';
    }
}
