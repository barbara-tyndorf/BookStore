import java.util.Objects;

public class Book {

    String title;
    String author;
    double price;

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }

//    public void setAuthor(String author) {
//        this.author = author;
//    }

//    public double getPrice() {
//        return price;
//    }

//    public void setPrice(double price) {
//        this.price = price;
//    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
// ???

        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof Book)) {
            return false;
        }
        Book otherBook = (Book) other;

        if (!Objects.equals(this.title, otherBook.title)) {
            return false;
        }
        if (!Objects.equals(this.author, otherBook.author)) {
            return false;
        }
        if (!Objects.equals(this.price, otherBook.price)) {
            return false;
        }
        return true;
    }
}