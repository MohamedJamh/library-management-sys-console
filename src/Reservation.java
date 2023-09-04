import java.util.Date;

public class Reservation {
    private int id;
    private int bookCopyId;
    private Date date;
    private String status = "borrowed";

    public Reservation(int id, Date date, String status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getBookCopyId() {
        return bookCopyId;
    }
    public void setBookCopyId(int bookCopyId) {
        this.bookCopyId = bookCopyId;
    }
}
