public class Main {
    public static void main(String[] args) {

        Book book = new Book("Jaś", "Małgosia", 20);
        Book book1 = new Book("Janek", "Gosia", 40);

        BookList bookList = new BookList();
        BookList bookList1 = new BookList();

        Book book3 = new Book("Co", "Tam", 15);
        Book book4 = new Book("Jak", "Tam", 30);

        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book);

        bookList1.addNewBook(book3);
        bookList1.addNewBook(book4);
        bookList1.addNewBook(book4);


        Basket basket = new Basket();
        basket.addToBasket("Jaś");
        basket.addToBasket("Jaś");
        basket.addToBasket("Jaś");
        basket.addToBasket("Co");
        basket.addToBasket("Jak");
//        basket.basket.add(book1);
//        basket.basket.add(book4);
//        basket.basket.add(book4);
//        basket.basket.add(book3);
//        basket.basket.add(book3);
//        basket.basket.add(book3);

        System.out.println(basket.basket.get(3).tytul + " " +
                basket.basket.get(3).autor + " " +
                basket.basket.get(3).cena + " " +
                basket.basket.get(3).ilosc);
//        basket.showBasket();
    }
}