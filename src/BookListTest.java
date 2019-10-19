
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookListTest {
    private BookList bookList;
    Book book = new Book("Małgosia", "dgdh", 20);
    Book book1 = new Book("Jaś", "dgdh", 15);

    @BeforeEach
    public void setUp() {
        bookList = new BookList();
    }

    @Test
    public void testAddNewBook(Book book) {
        int sizeBefore = bookList.bookList.size();
        bookList.addNewBook(book);
        int sizeAfter = bookList.bookList.size();
        assertEquals((sizeBefore + 1), sizeAfter);
    }

    @Test
    public void testRemoveBook() {
        String tytul = "Jaś";
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
        bookList.addNewBook(book1);
        String tytul = "Jaś";
        bookList.changeBookPrice("Jaś", 25);
        double priceAfter = bookList.bookList.get(i).cena;
        assertEquals(25, priceAfter);

    }
}
