import java.util.ArrayList;
import java.util.List;

public class BookList {

    List<Book> bookList = new ArrayList<>();

    public void addNewBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book parameters can not be empty");
        } else {
            bookList.add(book);
        }
    }

    public static Book findByTitleAndAuthor(String title, String author) {
        Book book = null;
        List<Book> bookList = new BookList().getBookList();
        for (Book chosenBook : bookList) {
            if (chosenBook.title.equals(title)
                    && chosenBook.author.equals(author)) {
                book = chosenBook;
                break;
            }
        }
        return book;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void removeBook(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).title == title) {
                bookList.remove(i);
                break;
            }
        }
    }

    public void changeBookPrice(String title, String author, double nowaCena) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).title.equals(title) && bookList.get(i).author.equals(author)) {
                bookList.get(i).price = nowaCena;
                break;
            }
        }
    }
}
