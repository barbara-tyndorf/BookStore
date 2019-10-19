import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    private Basket basket;

    Book book = new Book("Małgosia", "dgdh", 20);
    Book book1 = new Book("Jaś", "dgdh", 15);


    @BeforeEach
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void testAddToBasket() {
        basket.basket.add(book);
        int sizeBefore = basket.basket.size();
//        int iloscPrzed = ;
        basket.basket.add(book);
        basket.basket.add(book1);
        basket.basket.add(book1);
//        int iloscPo = ;
        int sizeAfter = basket.basket.size();
        assertEquals((sizeBefore + 3), sizeAfter);
//        assertEquals((iloscPrzed + 2), iloscPo);

    }

    @Test
    public void testShowBasket() {

        basket.addToBasket("Jaś");
        basket.addToBasket("Małgosia");
        int amount = 2;
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
        int sizeBefore = basket.basket.size();
        basket.removeBookFromBasket("Jaś");
        int sizeAfter = basket.basket.size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void testTotalAmountBooksInBasket() {  // ok
        basket.basket.add(book);
        basket.basket.add(book1);
        basket.basket.add(book1);
        int ilosc = 3;
        assertEquals(ilosc, basket.totalAmountBooksInBasket());

    }

    @Test
    public void testTotalPrice() {   // ok
        basket.basket.add(book);
        basket.basket.add(book1);
        basket.basket.add(book1);
        double expected = 50;
        double actual = basket.totalPrice();
        assertEquals(expected, actual);

    }
}