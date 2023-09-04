public class copy {
    private int id;
    private String status = "available";
    private int bookIsbn;
    private String reservedByReaderCin;


    public copy(int id, String status) {
        this.id = id;
        this.status = status;
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

    public void setBookIsbn(int bookIsbn) {
        this.bookIsbn = bookIsbn;
    }
    public int getBookIsbn() {
        return bookIsbn;
    }

}
