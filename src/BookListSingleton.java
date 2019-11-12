import java.util.ArrayList;
import java.util.List;

public class BookListSingleton {

    private List<Book> bookList;

    // singleton - there is only one instance
    static BookListSingleton INSTANCE = new BookListSingleton();

    private BookListSingleton() {
        bookList = new ArrayList<>();
    }

    void addNewBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book parameters can not be empty");
        } else {
            bookList.add(book);
        }
    }

    int amountOfBooksAtStore(Book book) {
        int amountOfBooks = 0;

        for (int i = 0; i < bookList.size(); i++) {
            if (book.equals(bookList.get(i))) {
                amountOfBooks++;
            }
        }
        return amountOfBooks;
    }

    static Book findByTitleAndAuthor(String title, String author) {
        Book book = null;
        List<Book> bookList = INSTANCE.bookList;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).title.equals(title)
                    && bookList.get(i).author.equals(author)) {
                book = bookList.get(i);
                break;
            }
        }
        return book;
    }

    List<Book> getBookList() {
        return bookList;
    }

    void removeBook(String title, String author) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).title.equals(title) && bookList.get(i).author.equals(author)) {
                bookList.remove(i);
                break;
            }
        }
    }

    void changeBookPrice(String title, String author, double newPrice) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).title.equals(title) && bookList.get(i).author.equals(author)) {
                bookList.get(i).price = newPrice;
                break;
            }
        }
    }
}
