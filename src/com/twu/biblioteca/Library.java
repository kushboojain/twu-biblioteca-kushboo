package com.twu.biblioteca;

import java.io.*;
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

    public boolean checkoutBook(String bookName) {
        if(isValidBookNameForCheckout(bookName)) {
            int index = -1;
            for (Book availableBook : availableBooks) {
                index++;
                if (availableBook.getBookName().equals(bookName)) {
                    break;
                }
            }
            Book borrowed = availableBooks.get(index);
            availableBooks.remove(borrowed);
            borrowedBooks.add(borrowed);
            return true;
        }
        else
            return false;

    }

    public boolean checkinBook(String bookName) {
        if(isValidBookNameForCheckin(bookName)) {
            int index = -1;
            for (Book borrowedBooks : this.borrowedBooks) {
                index++;
                if (borrowedBooks.getBookName().equals(bookName)) {
                    break;
                }
            }
            Book returned = borrowedBooks.get(index);
            borrowedBooks.remove(returned);
            availableBooks.add(returned);
            return true;
        }

        return false;
    }

    public boolean isValidBookNameForCheckout(String bookName) {
        for (Book availableBook : availableBooks) {
            if(availableBook.getBookName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidBookNameForCheckin(String bookName) {
        for (Book borrowedBook : borrowedBooks) {
            if(borrowedBook.getBookName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }
}
