
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookListTest {

    private BookList bookList;

    private String title = "Małgosia";
    private String author = "Nowak";
    private String title1 = "Jaś";
    private String author1 = "Kowalski";
    private Book book = new Book(title, author, 20);
    private Book book1 = new Book(title1, author1, 15);


    @BeforeEach
    public void setUp() {
        bookList = new BookList();
    }

    @Test
    public void testAddNewBook() {
        int sizeBefore = bookList.getBookList().size();
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        int sizeAfter = bookList.getBookList().size();
        assertEquals((sizeBefore + 2), sizeAfter);

    }

//    @Test
//    public void testAmountOfBooksAtStore(Book book) {
//        bookList.addNewBook(book);
//        bookList.addNewBook(book);
//        bookList.addNewBook(book1);
//        bookList.addNewBook(book1);
//        bookList.addNewBook(book1);
//        assertEquals(bookList.amountOfBooksAtStore(book), 2);
//        assertEquals(bookList.amountOfBooksAtStore(book1), 3);
//
//    }

    @Test
    public void testFindByTitleAndAuthor() {
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.findByTitleAndAuthor(book.title, book.author);
        assertEquals(bookList.findByTitleAndAuthor(book.title, book.author), book);

    }

    @Test
    public void testRemoveBook() {
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        int sizeBefore = bookList.getBookList().size();
        bookList.removeBook(title, author);
        int sizeAfter = bookList.getBookList().size();
        assertEquals((sizeBefore - 1), sizeAfter);

    }

    @Test
    public void testChangeBookPrice() {
        int i = 0;
        bookList.addNewBook(book1);
        bookList.changeBookPrice(title1, author1, 25);
        double priceAfter = bookList.getBookList().get(i).price;
        assertEquals(25, priceAfter);

    }
}
