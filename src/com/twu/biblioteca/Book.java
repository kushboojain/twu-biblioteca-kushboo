package com.twu.biblioteca;

import java.util.ArrayList;

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


    public ArrayList<String> details() {
        ArrayList<String> detail = new ArrayList<String>();
        detail.add(bookName);
        detail.add(author);
        detail.add(year);
        return detail;
    }

}
