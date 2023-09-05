
public class Reservation {
    private int id;
    private int bookCopyId;
    private String date;
    private String status = "borrowed";

    public Reservation(int id, int bookCopyId, String date) {
        this.id = id;
        this.date = date;
        this.bookCopyId = bookCopyId;
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

    public int getBookCopyId() {
        return bookCopyId;
    }
    public void setBookCopyId(int bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", bookCopyId=" + bookCopyId +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
