package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibrarianInterface {

    Library biblioteca;

    public LibrarianInterface(Library library)  {
        biblioteca = library;
    }

    public void performCheckout(UserInterface userInterface) {
        userInterface.print("Enetr a book name:\n");
        String bookName = userInterface.readUserInput();
            Book borrowed;
        if((borrowed = biblioteca.getBookForCheckout(bookName)) != null){
            biblioteca.checkoutBook(borrowed);
            userInterface.print("Thank you! Enjoy the book\n");

        }
        else
            userInterface.print("That book is not available");
    }


    public void performCheckin(UserInterface userInterface) {
        userInterface.print("Enter the name of the book to return");
        String bookName = userInterface.readUserInput();
        Book returnedBook;
        if((returnedBook = biblioteca.getBookForCheckin(bookName)) != null) {
            biblioteca.checkinBook(returnedBook);
            userInterface.print("Thank you for returning the book\n");
        }
        else
            userInterface.print("That is not a valid book to return");
    }

    public String listBooksDetails() {
        return biblioteca.getAvailableBooksDetails();
    }
}
