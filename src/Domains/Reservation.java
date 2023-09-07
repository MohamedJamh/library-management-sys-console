package Domains;

public class Reservation {
    private int id;
    private Copy copy;
    private String date;
    private String status = "borrowed";

    public Reservation(int id, Copy copy, String date) {
        this.id = id;
        this.date = date;
        this.copy = copy;
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
