package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 13/01/15.
 */
public class Librarian {

    Library biblioteca;

    public Librarian(Library library)  {
        biblioteca = library;
    }

    public void performCheckout(UserInterface userInterface) {
        if(biblioteca.checkoutBook(bookName))
            return "Thank you! Enjoy the book";
        else
            return "That book is not available";
    }


    public String performCheckin(String bookName) {
        if(biblioteca.checkinBook(bookName))
            return "Thank you for returning the book";
        else
            return "That is not a valid book to return";
    }

    public String listBooksDetails() {
        return biblioteca.getAvailableBooksDetails();
    }
}
