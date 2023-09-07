import javax.sound.sampled.Mixer;

public class Copy {
    private int id;
    private String status = "available";
    private Book book;
    private Person reservedByReader;


    public Copy(int id, Book book) {
        this.id = id;
        this.book = book;
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


    public Person getReservedByReader() {
        return reservedByReader;
    }
    public void setReservedByReaderCin(Person reservedByReader) {
        this.reservedByReader = reservedByReader;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public Book getBook() {
        return book;
    }
    public void isBorrowed(){
        status = "borrowed";
    }
    public void returned(){
        status = "available";
    }

    @Override
    public String toString() {
        String copy = "Copy {" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", bookIsbn='" + book.getIsbn() + '\'' ;
        if( reservedByReader != null ){ copy += ", reservedByReaderCin='" + reservedByReader.getCin() + '\'' ; }
        return copy + '}';
    }
}
