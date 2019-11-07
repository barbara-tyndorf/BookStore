import java.util.*;
import java.util.Map.Entry;

public class Basket {

    Map<Book, Integer> content = new HashMap<>();

    /**
     * If you want to add book by name and author call booklist static method
     * basket.add(BookList.byNameAndAuthor(name, author));
     *
     *
     * @param title, author
     */
    public void add(String title, String author) {
        add(title, author, 1);
    }

    public void add(String title, String author, int amount) {
        Book book = BookList.findByTitleAndAuthor(title, author);
        if (content.containsKey(book)) {
            int currentAmount = content.get(book);
            content.put(book, currentAmount + amount);
        } else {
            content.put(book, amount);
        }
    }

    public void cleanBasket() {
        content.clear();
    }

    public void remove(String title, String author) {
        Book book = BookList.findByTitleAndAuthor(title, author);
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
        for(Entry<Book, Integer> entry : content.entrySet()) {
            totalPrice += entry.getKey().price * entry.getValue();
        }
        return totalPrice;
    }

    public void showContent() {
        for(Entry<Book, Integer> entry : content.entrySet()) {
            System.out.println(String.format("Pozycja: %s \tIlość: %d\tCena: %.2f  ", entry.getKey(), entry.getValue(), entry.getKey().price * entry.getValue()));
        }
    }
}