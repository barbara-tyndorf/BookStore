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
        basket.addToBasket("Jaś", "Małgosia", 2);
        basket.addToBasket("Jaś", "Małgosia", 2);
        basket.addToBasket("Jaś", "Małgosia", 2);
        basket.addToBasket("Janek", "Gosia", 2);
        basket.addToBasket("Janek", "Gosia", 2);
//        basket.removeBookFromBasket("Janek", "Gosia");

//        System.out.println(basket.totalPrice());
        System.out.println(basket.totalAmountBooksInBasket());
        basket.showBasket();
        System.out.println(basket.basket.get(1).title);
    }
}
