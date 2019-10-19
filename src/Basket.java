import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Book> basket = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();
//    BookList bookList = new BookList();

    public void addToBasket(String tytul) {

        for (int i = 0; i < bookList.size(); i++) {

            if (bookList.get(i).tytul == tytul) {
                basket.add(bookList.get(i));
                basket.get(i).ilosc++;

//               for (int j = 0; j < basket.size(); j++) {
//
//                    if (basket.get(i) == basket.get(j)) {
//                        basket.get(i).ilosc++;
//                    }
//                }
            }
//            String dodanyTytul = basket.get(i).tytul;
//
//            for (int j = 0; j < basket.size(); j++) {
//                if (basket.get(j).tytul == dodanyTytul) {
//                    ilosc++;
//                }
//            }
        }
    }


    public List<Book> showBasket() {

        for (int i = 0; i < basket.size(); i++) {
            basket.get(i);

            System.out.println(basket.get(i).tytul + " "
                    + basket.get(i).autor + " " + basket.get(i).cena + " zł, ilość: "
                    + basket.get(i).ilosc + " szt.");
        }
        return basket;
    }

    public void cleanBasket() {
        basket.removeAll(basket);
    }

    public void removeBookFromBasket(String tytul) {

        for (int i = 0; i < basket.size(); i++) {
            int ilosc = bookList.get(i).ilosc;
            if (basket.get(i).tytul == tytul) {
                basket.remove(i);

                for (int j = 0; j < basket.size(); j++) {
                    if (basket.get(i) == basket.get(j)) {
                        basket.get(i).ilosc--;
                    }
                }
            }
        }
    }

    public int totalAmountBooksInBasket() {
        int total = basket.size();
        return total;
    }

    public double totalPrice() {
        double suma = 0;
        for (int i = 0; i < basket.size(); i++) {
            suma = suma + basket.get(i).cena;
        }
        return suma;
    }


}
