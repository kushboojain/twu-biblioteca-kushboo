package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 11/01/15.
 */
public class Book extends Item {
    private String author;
    private String year;

    public Book(String bookName, String author, String year) {
        name = bookName;
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }
}
