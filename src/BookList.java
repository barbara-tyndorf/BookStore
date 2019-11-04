import java.util.ArrayList;
import java.util.List;

public class BookList {

    // Book book = new Book("Jaś i Małgosia", "Ignacy", 20, 1);
    List<Book> bookList = new ArrayList<>();

    public void addNewBook(Book book) {
        if (book == null && book.equals("")) {
            throw new IllegalArgumentException("Book parameters can not be empty");
        } else {
            bookList.add(book);
        }
    }

    public void removeBook(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).title == title) {
                bookList.remove(i);
                break;
            }
        }
    }

    public void changeBookPrice(String tytul, double nowaCena) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).title == tytul) {
                bookList.get(i).price = nowaCena;
                break;
            }
        }
    }
}
