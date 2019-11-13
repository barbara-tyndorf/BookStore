import java.util.*;
import java.util.Map.Entry;

public class Basket {

    Map<Book, Integer> content = new HashMap<>();
    BookList booklist = new BookList();

    public void add(String title, String author) {
        add(title, author, 1);
    }

    public void add(String title, String author, int amount) {
        Book book = booklist.findByTitleAndAuthor(title, author);
        int amountOfBooksAtStore = booklist.amountOfBooksAtStore(book);
        String messageNotEnoughBooks = "Nie posiadamy podanej ilości w magazynie. Dostępnych jest %d szt.%nCzy dodać je do koszyka?";
        if (content.containsKey(book)) {
            int currentAmount = content.get(book);
            if ((currentAmount + amount) <= amountOfBooksAtStore) {
                content.put(book, currentAmount + amount);
            } else {
                System.out.printf(messageNotEnoughBooks, amountOfBooksAtStore);
            }
        } else {
            if (amount <= amountOfBooksAtStore) {
                content.put(book, amount);
            } else {
                System.out.printf(messageNotEnoughBooks, amountOfBooksAtStore);
            }
        }
    }


    public void cleanBasket() {
        content.clear();
    }

    public void remove(String title, String author) {
        Book book = booklist.findByTitleAndAuthor(title, author);
        content.remove(book);
    }

    public int totalAmountBooksInBasket() {
        int sum = 0;
        for (Integer amount : content.values()) {
            sum += amount;
        }
        return sum;

    }

    public double totalPrice() {
        double totalPrice = 0;
        for (Entry<Book, Integer> entry : content.entrySet()) {
            totalPrice += entry.getKey().price * entry.getValue();
        }
        return totalPrice;
    }

    public void showContent() {
        for (Entry<Book, Integer> entry : content.entrySet()) {
            System.out.printf(("Pozycja: %s \tIlość: %d\tWartość: %.2f zł"),
                    entry.getKey(), entry.getValue(), entry.getKey().price * entry.getValue());
        }
    }
}