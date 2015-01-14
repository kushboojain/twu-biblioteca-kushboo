package com.twu.biblioteca;

import java.util.*;

/**
 * Created by khusbooj on 13/01/15.
 */
public class Library {
    ArrayList<Book> availableBooks = new ArrayList<Book>();
    ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public String getAvailableBooksDetails() {
         return iterateOnAvailableBooks();
    }

    private String iterateOnAvailableBooks() {
        String bookDetails = "";
        for (Book book : availableBooks) {
            bookDetails += book.details();
        }

        return bookDetails;
    }

    public Library(ArrayList<Book> books)  {
        availableBooks = books;
    }

    public void checkoutBook(Book borrowedBook) {
            availableBooks.remove(borrowedBook);
            borrowedBooks.add(borrowedBook);
    }

    public void checkinBook(Book returnedBook) {
            borrowedBooks.remove(returnedBook);
            availableBooks.add(returnedBook);
    }

    public Book getBookForCheckout(String bookName) {
        for (Book availableBook : availableBooks) {
            if(availableBook.getBookName().equals(bookName)) {
                return availableBook;
            }
        }
        return null;
    }

    public Book getBookForCheckin(String bookName) {
        for (Book borrowedBook : borrowedBooks) {
            if(borrowedBook.getBookName().equals(bookName)) {
                return borrowedBook;
            }
        }
        return null;
    }
}
