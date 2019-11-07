
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookListTest {

    private BookList bookList;
    Book book = new Book("Małgosia", "Nowak", 20);
    Book book1 = new Book("Jaś", "Kowalski", 15);
//    Book book2 = new Book(null, null, 0);

    @BeforeEach
    public void setUp() {
        bookList = new BookList();
    }

    @Test
    public void testAddNewBook() {
        int sizeBefore = bookList.bookList.size();
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
//        bookList.addNewBook(null);
        int sizeAfter = bookList.bookList.size();
        assertEquals(sizeBefore + 2, sizeAfter);
//        assertThrows(Exception);
    }

    @Test
    public void testRemoveBook() {
        String title = "Małgosia";
        String author = "Nowak";
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        int sizeBefore = bookList.bookList.size();
        bookList.removeBook(title, author);
        int sizeAfter = bookList.bookList.size();
        assertEquals((sizeBefore - 1), sizeAfter);

    }

    @Test
    public void testChangeBookPrice() {
        int i = 0;
        bookList.addNewBook(book1);
        String title = "Jaś";
        String author = "Kowalski";
        bookList.changeBookPrice(title, author, 25);
        double priceAfter = bookList.bookList.get(i).price;
        assertEquals(25, priceAfter);

    }
}
