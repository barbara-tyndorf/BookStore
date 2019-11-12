
import java.util.List;

public class BookList {


    public void addNewBook(Book book) {
        BookListSingleton.INSTANCE.addNewBook(book);
    }

    int amountOfBooksAtStore(Book book) {
        int amountOfBooks = BookListSingleton.INSTANCE.amountOfBooksAtStore(book);
        return amountOfBooks;
    }

    public Book findByTitleAndAuthor(String title, String author) {
        Book book = BookListSingleton.findByTitleAndAuthor(title, author);
        return book;
    }

    public List<Book> getBookList() {
        return BookListSingleton.INSTANCE.getBookList();
    }

    public void removeBook(String title, String author) {
        BookListSingleton.INSTANCE.removeBook(title, author);
        }

    public void changeBookPrice(String title, String author, double newPrice) {
        BookListSingleton.INSTANCE.changeBookPrice(title, author, newPrice);
    }
}
