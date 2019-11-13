import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    private Basket basket;

    private String title = "Małgosia";
    private String title1 = "Jaś";
    private String author = "Nowak";
    private String author1 = "Kowalski";

    private Book book = new Book(title, author, 20);
    private Book book1 = new Book(title1, author1, 15);
    private BookList bookList = new BookList();


    @BeforeEach
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void testAddToBasket() {
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book1);
        int sizeBefore = basket.content.size();
        basket.add(title1, author1,2);
        basket.add(title, author,1);
        int sizeAfter = basket.content.size();
        assertEquals(sizeAfter, (sizeBefore + 2));

    }

    @Test
    public void testShowBasket() {
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book1);
        basket.add(title1, author1,2);
        basket.add(title, author,1);
        int sum = 0;
        for (Integer amount : basket.content.values()) {
            sum += amount;
        }
        int amount = 3;
        assertEquals(amount, sum);


    }

    @Test
    public void testCleanBasket() {
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book1);
        basket.add(title1, author1,2);
        basket.add(title, author,1);
        int sizeBefore = basket.totalAmountBooksInBasket();
        basket.cleanBasket();
        int sizeAfter = basket.content.size();
        assertEquals((sizeBefore - 3), sizeAfter);
    }

    @Test
    public void testRemoveBookFromBasket() {
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book1);
        basket.add(title1, author1,2);
        basket.add(title, author,1);
        int sizeBefore = basket.content.size();
        basket.remove(title, author);
        int sizeAfter = basket.content.size();
        assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void testTotalAmountBooksInBasket() {
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book1);
        basket.add(title1, author1,2);
        basket.add(title, author,1);
        int total = 3;
        assertEquals(total, basket.totalAmountBooksInBasket());

    }

    @Test
    public void testTotalPrice() {
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book1);
        basket.add(title1, author1,2);
        basket.add(title, author,1);
        double expected = 50;
        double actual = basket.totalPrice();
        assertEquals(expected, actual);

    }
}