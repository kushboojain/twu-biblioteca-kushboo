package com.twu.biblioteca;

/**
 * Created by khusbooj on 11/01/15.
 */
public class Book {
    private String bookName;
    private String author;
    private String year;

    public Book(String bookName, String author, String year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
    }

    public String getBookName() {
        return bookName;
    }


    public String details() {
        return bookName +"\t\t"+ author+ "\t\t"+ year +"\n";
    }

}
