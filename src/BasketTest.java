import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    private Basket basket;

    Book book = new Book("Małgosia", "Nowak", 20, 1);
    Book book1 = new Book("Jaś", "Kowalski", 15, 1);


    @BeforeEach
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void testAddToBasket() {
        BookList bookList = new BookList();
        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book1);
        int sizeBefore = basket.basket.size();
//        basket.basket.add(book);
//        basket.basket.add(book1);
//        basket.basket.add(book1);
        basket.addToBasket("Jaś");
        basket.addToBasket("Jaś");
        basket.addToBasket("Małgosyeessia");
        int sizeAfter = basket.basket.size();
        assertEquals((sizeBefore + 3), sizeAfter);

    }

    @Test
    public void testShowBasket() {
        basket.basket.add(book);
        basket.basket.add(book1);
        basket.basket.add(book1);
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Małgosia");
//        basket.addToBasket("Małgosia");
        int amount = 3;
        basket.showBasket();
        assertEquals(basket.basket.size(), amount);

    }

    @Test
    public void testCleanBasket() {
        basket.basket.add(book);
        basket.basket.add(book1);
        basket.basket.add(book1);
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Małgosia");
        basket.cleanBasket();
        int sizeAfter = basket.basket.size();
        assertTrue(sizeAfter == 0);
    }

    @Test
    public void testRemoveBookFromBasket(String tytuł) {
        basket.basket.add(book);
        basket.basket.add(book1);
        basket.basket.add(book1);
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Małgosia");
        int sizeBefore = basket.basket.size();
        basket.basket.remove(1);
//        basket.removeBookFromBasket("Małgosia");
        int sizeAfter = basket.basket.size();
        assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void testTotalAmountBooksInBasket() {
        basket.basket.add(book);
        basket.basket.add(book1);
        basket.basket.add(book1);
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Małgosia");

        int ilosc = 3;
        assertEquals(ilosc, basket.totalAmountBooksInBasket());

    }

    @Test
    public void testTotalPrice() {
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Jaś");
//        basket.addToBasket("Małgosia");

        basket.basket.add(book);
        basket.basket.add(book1);
        basket.basket.add(book1);
        double expected = 50;
        double actual = basket.totalPrice();
        assertEquals(expected, actual);

    }
}