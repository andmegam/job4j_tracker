package ru.job4j.pojo;

public class Book {

    private String bookName;
    private int pagesCount;

    public Book(String bookName, int pagesCount) {
        this.bookName = bookName;
        this.pagesCount = pagesCount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }
}
