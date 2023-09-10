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


    public Book(String isbn, String title, int quantity, float price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.quantity = quantity;
        this.available = this.quantity;
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

//    TODO: delete setavailable setter
//    public void setAvailable(int availableCopies, String from) {
//        available += availableCopies;
//        if (from.equals("lost")) {
//            lost -= availableCopies;
//        } else {
//            borrowed -= availableCopies;
//        }
//    }

    public int getBorrowed() {
        return borrowed;
    }
//    TODO: delete setBorrowed setter

//    public void setBorrowed(int borrowedCopies) {
//        borrowed += borrowedCopies;
//        available -= borrowedCopies;
//    }

    public int getLost() {
        return lost;
    }

//    TODO: delete setLost setter

//    public void setLost(int lostCopies, String from) {
//        lost += lostCopies;
//        if (from.equals("available")) {
//            available -= lostCopies;
//        } else {
//            borrowed -= lostCopies;
//        }
//    }

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
