package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibraryInterface {

    Library books;
    Library movies;
    UserInterface userInterface;
    private Customer loggedInCustomer;

    public LibraryInterface(Library books, Library movies, UserInterface userInterface)  {
        this.books = books;
        this.movies = movies;
        this.userInterface = userInterface;
    }

    public void performCheckoutOfBook() {
        String bookName = userInterface.getBookNameFromUser();
        boolean status = checkOutProcessOfBook(bookName);
        userInterface.displayMessageOnCheckoutOfBook(status);
        if(status) {
            books.putEntry(bookName, loggedInCustomer.getLibraryNumber());
        }
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
        boolean status = checkInProcessOfBook(bookName);
        userInterface.displayMessageOnCheckinOfBook(status);
        if(status) {
            books.removeEntry(bookName);
        }
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

    public void performCheckinOfMovie() {
        String movieName = userInterface.getMovieNameFromUser();
        boolean status = checkInProcessMovie(movieName);
        userInterface.displayMessageOnCheckinOfMovie(status);
        if(status)
            movies.removeEntry(movieName);
    }
    public void performCheckOutOfMovie() {
        String movieName = userInterface.getMovieNameFromUser();
        boolean status = checkOutProcessOfMovie(movieName);
        userInterface.displayMessageOnCheckoutOfMovie(status);
        if(status)
            movies.putEntry(movieName,loggedInCustomer.getLibraryNumber());
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
    public void listBooksDetails() {
        ArrayList<Item> availableItemDetails = books.getAvailableItemDetails();
        for (Item availableItemDetail : availableItemDetails) {
            userInterface.displayBookDetails((Book) availableItemDetail);
        }
    }

    public void listMoviesDetails() {
        ArrayList<Item> availableMovieDetails = movies.getAvailableItemDetails();
        for (Item availableMovieDetail : availableMovieDetails) {
            userInterface.displayMovieDetails((Movie)availableMovieDetail);
        }
    }

    public void listBorrowedBooks() {
        userInterface.displayBorrowedBooks(books.getBorrowedItems());
    }

    public void listBorrowedMovies() {
        userInterface.displayBorrowedMovies(movies.getBorrowedItems());
    }

    public void setLoggedInCustomer(Customer loggedInCustomer) {
        this.loggedInCustomer = loggedInCustomer;
    }
}
