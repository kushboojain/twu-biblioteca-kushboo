package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibrarianInterface {

    Library books;
    private Library movies;
    UserInterface userInterface;

    public LibrarianInterface(Library books, Library movies, UserInterface userInterface)  {
        this.books = books;
        this.movies = movies;
        this.userInterface = userInterface;
    }

    public void performCheckoutOfBook() {
        printToUserInterface("Enetr a book name:\n");
        String bookName = getInputFromUser();
        String message = checkOutProcessOfBook(bookName);
        printToUserInterface(message);
    }

    String checkOutProcessOfBook(String bookName) {
        Book borrowed;
        if((borrowed = (Book) books.getItemForCheckout(bookName)) != null){
            books.checkoutItem(borrowed);
            return ("Thank you! Enjoy the book\n");

        }
        else
            return ("That book is not available\n");
    }

    private String getInputFromUser() {
        return userInterface.readUserInputForProcessing();
    }


    public void performCheckinOfBook() {
        printToUserInterface("Enter the name of the book to return");
        String bookName = getInputFromUser();
        printToUserInterface(checkInProcessOfBook(bookName));
    }

    String checkInProcessOfBook(String bookName) {
        Book returnedBook;
        if((returnedBook = (Book) books.getItemForCheckin(bookName)) != null) {
            books.checkinItem(returnedBook);
            return ("Thank you for returning the book\n");
        }
        else
            return ("That is not a valid book to return\n");
    }

    private void printToUserInterface(String message) {
        userInterface.print(message);
    }

    public void listBooksDetails() {
        userInterface.displayBookDetails(books.getAvailableItemDetails());
    }

    public void performCheckinOfMovie() {
        printToUserInterface("Enter the name of the movie to borrow:");
        String movieName = getInputFromUser();
        printToUserInterface(checkInProcessMovie(movieName));
    }
    public void performCheckOutOfMovie() {
        printToUserInterface("Enetr a movie name:\n");
        String movieName = getInputFromUser();
        String message = checkOutProcessOfMovie(movieName);
        printToUserInterface(message);
    }

    String checkInProcessMovie(String movieName) {
        Movie returnedMovie;
        if((returnedMovie = (Movie) movies.getItemForCheckin(movieName)) != null) {
            movies.checkinItem(returnedMovie);
            return ("Thank you for returning the movie\n");
        }
        else
            return ("That is not a valid movie to return\n");
    }

    String checkOutProcessOfMovie(String movieName) {
        Movie borrowed;
        if((borrowed = (Movie) movies.getItemForCheckout(movieName)) != null){
            movies.checkoutItem(borrowed);
            return ("Thank you! Enjoy the movie\n");

        }
        else
            return ("That movie is not available\n");

    }

    public void listMoviesDetails() {
        userInterface.displayBookDetails(movies.getAvailableItemDetails());
    }
}
