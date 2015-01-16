package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibrarianInterface {

    Library books;
    Library movies;
    UserInterface userInterface;

    public LibrarianInterface(Library books, Library movies, UserInterface userInterface)  {
        this.books = books;
        this.movies = movies;
        this.userInterface = userInterface;
    }

    public void performCheckoutOfBook() {
        String bookName = userInterface.getBookNameFromUser();
        boolean status = checkOutProcessOfBook(bookName);
        userInterface.displayMessageOnCheckoutOfBook(status);
    }

    boolean checkOutProcessOfBook(String bookName) {
        Book borrowed;
        if((borrowed = (Book) books.getItemForCheckout(bookName)) != null){
            books.checkoutItem(borrowed);
            return true;

        }
        else
            return false;
    }

    public void performCheckinOfBook() {
        String bookName = userInterface.getBookNameFromUser();
        userInterface.displayMessageOnCheckinOfBook(checkInProcessOfBook(bookName));
    }

    boolean checkInProcessOfBook(String bookName) {
        Book returnedBook;
        if((returnedBook = (Book) books.getItemForCheckin(bookName)) != null) {
            books.checkinItem(returnedBook);
            return true;
        }
        else
            return false;
    }


    public void listBooksDetails() {
        userInterface.displayBookDetails(books.getAvailableItemDetails());
    }

    public void performCheckinOfMovie() {
        String movieName = userInterface.getMovieNameFromUser();
        userInterface.displayMessageOnCheckinOfMovie(checkInProcessMovie(movieName));

    }
    public void performCheckOutOfMovie() {
        String movieName = userInterface.getMovieNameFromUser();
        boolean status = checkOutProcessOfMovie(movieName);
        userInterface.displayMessageOnCheckoutOfMovie(status);
    }


    boolean checkInProcessMovie(String movieName) {
        Movie returnedMovie;
        if((returnedMovie = (Movie) movies.getItemForCheckin(movieName)) != null) {
            movies.checkinItem(returnedMovie);
            return true;
        }
        else
            return false;
    }

    boolean checkOutProcessOfMovie(String movieName) {
        Movie borrowed;
        if((borrowed = (Movie) movies.getItemForCheckout(movieName)) != null){
            movies.checkoutItem(borrowed);
            return true;

        }
        else
            return false;

    }
    void makeEntryOfBorrowingBook() {

    }
    void removeEntryOfBorrowedBook() {

    }
    void makeEntryOfBorrowingMovie() {

    }
    void removeEntryOfBorrowedMovie() {

    }

    public void listMoviesDetails() {
        userInterface.displayBookDetails(movies.getAvailableItemDetails());
    }
}
