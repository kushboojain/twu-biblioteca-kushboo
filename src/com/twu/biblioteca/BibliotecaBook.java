package com.twu.biblioteca;

/**
 * Created by khusbooj on 11/01/15.
 */
public class bibliotecaBook {
    private String bookName;
    private boolean borrowed;
    private String author;
    private String year;

    public bibliotecaBook(String bookName, String author, String year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String details() {
        return bookName +"\t\t"+ author+ "\t\t"+ year +"\n";
    }

    public boolean getStatus() {
        return this.borrowed;
    }
}
