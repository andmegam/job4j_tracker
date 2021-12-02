package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Clean code", 567);
        books[1] = new Book("Head first java", 768);
        books[2] = new Book("Grokking Algorithms", 290);
        books[3] = new Book("Effective Java", 466);
        print(books);
        Book buf = books[0];
        books[0] = books[3];
        books[3] = buf;
        print(books);
        for (Book element : books) {
            if ("Clean code".equals(element.getBookName())) {
                System.out.println(element.getBookName() + " " + element.getPagesCount());
            }
        }
    }

    private static void print(Book[] books) {
        for (Book element : books) {
            System.out.println("Book: " + element.getBookName() + " Has " + element.getPagesCount() + " pages");
        }
    }

}
