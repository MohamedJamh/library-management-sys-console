public class Copy {
    private int id;
    private String status = "available";
    private String bookIsbn;
    private String reservedByReaderCin;


    public Copy(int id, String bookIsbn) {
        this.id = id;
        this.bookIsbn = bookIsbn;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public String getReservedByReaderCin() {
        return reservedByReaderCin;
    }
    public void setReservedByReaderCin(String reservedByReaderCin) {
        this.reservedByReaderCin = reservedByReaderCin;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }
    public String getBookIsbn() {
        return bookIsbn;
    }
    public void isBorrowed(){
        status = "borrowed";
    }
    public void returned(){
        status = "available";
    }

    @Override
    public String toString() {
        return "Copy{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", reservedByReaderCin='" + reservedByReaderCin + '\'' +
                '}';
    }
}
