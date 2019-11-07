import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    private Basket basket;

    Book book = new Book("Małgosia", "Nowak", 20);
    Book book1 = new Book("Jaś", "Kowalski", 15);


    @BeforeEach
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void testAddToBasket() {
        int sizeBefore = basket.content.size();
        basket.add("Jaś","Kowalski", 2);
        basket.add("Małgosia", "Nowak", 1);
        int sizeAfter = basket.content.size();
        assertEquals((sizeBefore + 3), sizeAfter);
//        int sum = 0;
//        for (Integer amount : basket.content.values()) {
//            sum += amount;
//        }
//        int size = basket.content.size();
//        assertEquals(3, size);

    }

    @Test
    public void testShowBasket() {
        basket.add("Jaś","Kowalski", 2);
        basket.add("Małgosia", "Nowak", 1);
        int amount = 3;
        basket.showContent();
        assertEquals(basket.content.size(), amount);

    }

    @Test
    public void testCleanBasket() {
        basket.add("Jaś","Kowalski", 2);
        basket.add("Małgosia", "Nowak", 1);
        basket.cleanBasket();
        int sizeAfter = basket.content.size();
        assertTrue(sizeAfter == 0);
    }

    @Test
    public void testRemoveBookFromBasket() {
        basket.add("Jaś","Kowalski", 2);
        basket.add("Małgosia", "Nowak", 1);
        int sizeBefore = basket.content.size();
        basket.remove("Małgosia", "Nowak");
        int sizeAfter = basket.content.size();
        assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void testTotalAmountBooksInBasket() {
        basket.add("Jaś","Kowalski", 2);
        basket.add("Małgosia", "Nowak", 1);
        int total = 3;
        assertEquals(total, basket.totalAmountBooksInBasket());

    }

    @Test
    public void testTotalPrice() {
        basket.add("Jaś","Kowalski", 2);
        basket.add("Małgosia", "Nowak", 1);
        double expected = 50;
        double actual = basket.totalPrice();
        assertEquals(expected, actual);

    }
}