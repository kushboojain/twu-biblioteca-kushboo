package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibrarianInterface {

    Library biblioteca;
    UserInterface userInterface;

    public LibrarianInterface(Library library, UserInterface userInterface)  {
        biblioteca = library;
        this.userInterface = userInterface;
    }

    public void performCheckout() {
        printToUserInterface("Enetr a book name:\n");
        String bookName = getInputFromUser();
        String message = checkOutProcess(bookName);
        printToUserInterface(message);
    }

    String checkOutProcess(String bookName) {
        Book borrowed;
        if((borrowed = biblioteca.getBookForCheckout(bookName)) != null){
            biblioteca.checkoutBook(borrowed);
            return ("Thank you! Enjoy the book\n");

        }
        else
            return ("That book is not available\n");
    }

    private String getInputFromUser() {
        return userInterface.readUserInputForProcessing();
    }


    public void performCheckin() {
        printToUserInterface("Enter the name of the book to return");
        String bookName = getInputFromUser();
        printToUserInterface(checkInProcess(bookName));
    }

    String checkInProcess(String bookName) {
        Book returnedBook;
        if((returnedBook = biblioteca.getBookForCheckin(bookName)) != null) {
            biblioteca.checkinBook(returnedBook);
            return ("Thank you for returning the book\n");
        }
        else
            return ("That is not a valid book to return\n");
    }

    private void printToUserInterface(String message) {
        userInterface.print(message);
    }

    public void listBooksDetails() {
        userInterface.displayBookDetails(biblioteca.getAvailableBooksDetails());
    }
}
