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
        // dodać warunek, by nie przekraczać ilości książek w liście
        if (content.containsKey(book)) {
            int currentAmount = content.get(book);
            content.put(book, currentAmount + amount);
        } else {
            content.put(book, amount);
        }
    }

    public boolean checkIfAmountOfBooksIsAvailable(String title, String author, int amount) {
        Book book = booklist.findByTitleAndAuthor(title, author);
        int amountOfBooksAtStore = booklist.amountOfBooksAtStore(book);
        for (Entry<Book, Integer> entry : content.entrySet()) {
            if (entry.getValue() > amountOfBooksAtStore || amount > amountOfBooksAtStore) {
                System.out.println("Nie posiadamy podanej ilosci w magazynie. Dostępnych jest " + amountOfBooksAtStore + " szt.");
                return false;
            } else {
                return true;
            }
        }
        return true;
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
        // lub tak
        // sum = content.values().stream().reduce(0, (a,b) -> a + b);
        // lub jeszcze prosciej tak
        // return content.values().stream().mapToInt(Integer::intValue).sum();
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