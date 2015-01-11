package com.twu.biblioteca;

/**
 * Created by khusbooj on 11/01/15.
 */
public class BibliotecaBook {
    public String bookName;
    public boolean borrowed;
    public String author;
    public String year;

    public BibliotecaBook(String bookName, String author, String year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }

    public String details() {
        return bookName +"\t\t"+ author+ "\t\t"+ year +"\n";
    }

    public boolean getStatus() {
        return this.borrowed;
    }
}
