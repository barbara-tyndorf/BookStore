import java.util.*;

public class Basket {

    List<Book> basket = new ArrayList<>();
    Map<Book, Integer> basketContent = new HashMap<>();


    private Book getBookByName(String title, String author) {
        Book book = null;
        List<Book> bookList = new BookList().getBookList();
        for (Book chosenBook : bookList) {
            if (chosenBook.title.equals(title)
                    && chosenBook.author.equals(author)) {
                book = chosenBook;
                break;
            }
        }
        return book;
    }

    public void addToBasket(String title, String author, int amount) {
        Book book = getBookByName(title, author);
        basket.add(book);
        basketContent.put(book,amount);
    }


    public void showBasket() {

        System.out.println(basketContent.hashCode());
        System.out.println(basketContent.keySet());
//        for (int i = 0; i < basket.size(); i++) {
//
//            System.out.println(basket.get(i).title + " " +
//                    basket.get(i).author + " " +
//                    basket.get(i).price + " zł, ilość: "
//                    + "szt.");
        }
//    }

    public void cleanBasket() {
        basket.clear();
    }

    public void removeBookFromBasket(String title, String author) {
        Book book = getBookByName(title, author);
        basket.remove(book);
    }

    public int totalAmountBooksInBasket() {
        return basket.size();
    }

    public double totalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < basket.size(); i++) {
            totalPrice = totalPrice + basket.get(i).price;
        }
        return totalPrice;
    }
}