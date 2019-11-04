import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Book> basket = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();

    public void addToBasket(String title) {

        if (title == null && title.equals("")) {
            throw new IllegalArgumentException("Book parameters can not be empty");
        }
        for (int i = 0; i < bookList.size(); i++) {

            if (bookList.get(i).title.equals(title)) {
                basket.add(bookList.get(i));

            } else {
                throw new IllegalArgumentException("We do not have this book");
            }
        }
    }

    public List<Book> showBasket() {

        for (int i = 0; i < basket.size(); i++) {

            for (int j = 0; j < basket.size(); j++) {

                if (basket.get(i) == basket.get(j)) {
                    basket.get(i).amount++;
                    basket.remove(j);
                }
            }

            System.out.println(basket.get(i).title + " "
                    + basket.get(i).author + " " + basket.get(i).price + " zł, ilość: "
                    + basket.get(i).amount + " szt.");
        }
        return basket;
    }

    public void cleanBasket() {
        basket.removeAll(basket);
    }

    public void removeBookFromBasket(String tytul) {

        for (int i = 0; i < basket.size(); i++) {

            if (basket.get(i).title.equals(tytul)) {
                basket.remove(i);
                basket.get(i).amount--;
            }
        }
    }

    public int totalAmountBooksInBasket() {
        int totalAmount = basket.size();
        return totalAmount;
    }

    public double totalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < basket.size(); i++) {
            totalPrice = totalPrice + basket.get(i).price;
        }
        return totalPrice;
    }
}