import java.util.ArrayList;
import java.util.List;

public class BookListSingleton {

    private Map<Book> bookList;

    // singleton - there is only one instance
    static BookListSingleton INSTANCE = new BookListSingleton();

    private BookListSingleton() {
        bookList = new HashMap<>();
    }

    void addNewBook(Book book, int amount) {
        if (book == null) {
            throw new IllegalArgumentException("Book parameters can not be empty");
        } else {
            bookList.put(book, amount);
        }
    }

    Integer amountOfBooksAtStore(Book book) {
       return booklist.get(book);
    }

    Book findByTitleAndAuthor(String title, String author) {
        for (Book book : bookList.keySet()) {
           if (book.title.equals(title) && book.author.equals(author)) {
              return book;
         }
}    
    }


    Map<Book> getBookList() {
        return bookList;
    }

    void removeBook(String title, String author) {
        Book book = findByTitleAndAuthor(title, author);
        bookList.remove(book);
    }

    void changeBookPrice(String title, String author, double newPrice) {
        Book book = findByTitleAndAuthor(title, author);
        book.price = newPrice;
    }
}
