import java.util.ArrayList;
import java.util.List;

public class BookList {

    Book book = new Book("Jaś i Małgosia", "Ignacy", 20);
    List<Book> bookList = new ArrayList<>();

    public Book addNewBook(Book book) {
        bookList.add(book);
        return book;
    }

    public void removeBook(String tytul) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).tytul == tytul) {
                bookList.remove(i);
                break;
            }
        }
    }

    public void changeBookPrice(String tytul, double nowaCena) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).tytul == tytul) {
                bookList.get(i).cena = nowaCena;
                break;
            }
        }
    }
}
