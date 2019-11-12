

public class Main {
    public static void main(String[] args) {

        Book book = new Book("Jaś", "Małgosia", 20);
        Book book1 = new Book("Janek", "Gosia", 40);

        BookList bookList = new BookList();

        Book book3 = new Book("Co", "Tam", 15);
        Book book4 = new Book("Jak", "Tam", 30);

        bookList.addNewBook(book);
        bookList.addNewBook(book1);
        bookList.addNewBook(book4);

        bookList.addNewBook(book3);
        bookList.addNewBook(book3);
        bookList.addNewBook(book3);
        bookList.addNewBook(book4);
        bookList.addNewBook(book4);
        bookList.addNewBook(book4);
        bookList.addNewBook(book4);

        Basket basket = new Basket();
        basket.add("Co", "Tam",1);
        basket.add("Co", "Tam",2);

        System.out.println(bookList.amountOfBooksAtStore(book4));
//        basket.add("Jak", "Tam",3);
//        basket.add("Jak", "Tam",1);
//        basket.add("Janek", "Gosia",1);
//        basket.add("Janek", "Gosia",1);
//        basket.add("Jaś", "Małgosia",1);
//        basket.add("Jaś", "Małgosia",1);

        System.out.println(basket.checkIfAmountOfBooksIsAvailable("Jak", "Tam", 8));

//        System.out.println(bookList.getBookList().get(1).toString());
//
//
//        System.out.println(basket.totalAmountBooksInBasket());
//        System.out.println(basket.totalPrice());
//        basket.showContent();
//        basket.cleanBasket();
    }
}
