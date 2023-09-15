package Domains;

public class Book {
    private String isbn;
    private String title;
    private int quantity;
    private int available;
    private int borrowed = 0;
    private int lost = 0;
    private float price;
    private String author;


    public Book(String isbn, String title, int quantity,int available,int borrowed,int lost, float price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.quantity = quantity;
        this.available = available;
        this.borrowed = borrowed;
        this.lost = lost;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailable() {
        return available;
    }


    public int getBorrowed() {
        return borrowed;
    }


    public int getLost() {
        return lost;
    }



    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Domain.Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", available=" + available +
                ", borrowed=" + borrowed +
                ", lost=" + lost +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
