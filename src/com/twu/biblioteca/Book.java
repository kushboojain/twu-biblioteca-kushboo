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

    public ArrayList<String> details() {
        ArrayList<String> detail = new ArrayList<String>();
        detail.add(name);
        detail.add(author);
        detail.add(year);
        return detail;
    }

}
