import java.util.Objects;

public class Book {

    String title;
    String author;
    double price;


    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && price == book.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }


    @Override
    public String toString() {
        return "[" +
                "Tytuł: '" + title + "'\t " +
                "Autor: '" + author + "'\t " +
                "Cena: '" + price + " zł'" +
                "]";
    }
}