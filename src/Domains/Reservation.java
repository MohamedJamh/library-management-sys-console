package Domains;

public class Reservation {
    private int id;
    private Copy copy;
    private String date;
    private String status ;

    private final String returnDate;

    public Reservation(int id, Copy copy, String date,String status ,String returnDate) {
        this.id = id;
        this.date = date;
        this.copy = copy;
        this.status = status;
        this.returnDate = returnDate;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Copy getBookCopy() {
        return copy;
    }
    public void setBookCopy(Copy copy) {
        this.copy = copy;
    }

    public String getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Domain.Reservation{" +
                "id=" + id +
                ", bookCopyId=" + copy.getId() +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
