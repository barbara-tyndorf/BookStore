import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    private Basket basket;

//    Book book = new Book("Małgosia", "Nowak", 20);
//    Book book1 = new Book("Jaś", "Kowalski", 15);


    @BeforeEach
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void testAddToBasket() {
        int sizeBefore = basket.basket.size();
        basket.addToBasket("Jaś","Kowalski", 2);
        basket.addToBasket("Małgosia", "Nowak", 1);
        int sizeAfter = basket.basket.size();
        assertEquals((sizeBefore + 2), sizeAfter);

    }

    @Test
    public void testShowBasket() {
        basket.addToBasket("Jaś","Kowalski", 2);
        basket.addToBasket("Małgosia", "Nowak", 1);
        int amount = 2;
        basket.showBasket();
        assertEquals(basket.basket.size(), amount);
//        assertEquals(basket.basket.get(0).title, "Jaś");

    }

    @Test
    public void testCleanBasket() {
        basket.addToBasket("Jaś","Kowalski", 2);
        basket.addToBasket("Małgosia", "Nowak", 1);
        basket.cleanBasket();
        int sizeAfter = basket.basket.size();
        assertTrue(sizeAfter == 0);
    }

    @Test
    public void testRemoveBookFromBasket() {
        basket.addToBasket("Jaś","Kowalski", 2);
        basket.addToBasket("Małgosia", "Nowak", 1);
        int sizeBefore = basket.basket.size();
        basket.removeBookFromBasket("Małgosia", "Nowak");
        int sizeAfter = basket.basket.size();
        assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void testTotalAmountBooksInBasket() {
        basket.addToBasket("Jaś","Kowalski", 2);
        basket.addToBasket("Małgosia", "Nowak", 1);
        int total = 2;
        assertEquals(total, basket.totalAmountBooksInBasket());

    }

    @Test
    public void testTotalPrice() {
        basket.addToBasket("Jaś","Kowalski", 2);
        basket.addToBasket("Małgosia", "Nowak", 1);
        double expected = 50;
        double actual = basket.totalPrice();
        assertEquals(expected, actual);

    }
}