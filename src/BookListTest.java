
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookListTest {
    private BookList bookList;
    Book book = new Book("Małgosia", "Nowak", 20, 1);
    Book book1 = new Book("Jaś", "Kowalski", 15, 1);
    Book book2 = new Book(null, null, 0, 0);

    @BeforeEach
    public void setUp() {
        bookList = new BookList();
    }

    @Test
    public void testAddNewBook() {
        int sizeBefore = bookList.bookList.size();
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(null);
        int sizeAfter = bookList.bookList.size();
        assertEquals(sizeBefore + 2, sizeAfter);
        assertNotNull(null);
    }

    @Test
    public void testRemoveBook() {
        String tytul = "Małgosia";
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        int sizeBefore = bookList.bookList.size();
        bookList.removeBook(tytul);
        int sizeAfter = bookList.bookList.size();
        assertEquals((sizeBefore - 1), sizeAfter);

    }

    @Test
    public void testChangeBookPrice() {
        int i = 0;
        bookList.addNewBook(book);
        String tytul = "Jaś";
        bookList.changeBookPrice(tytul, 25);
        double priceAfter = bookList.bookList.get(i).price;
        assertEquals(25, priceAfter);

    }
}
