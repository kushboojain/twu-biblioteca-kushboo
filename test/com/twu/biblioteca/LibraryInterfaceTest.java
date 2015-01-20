package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibraryInterfaceTest {
    private ArrayList<Item> books;
    private ArrayList<Item> movies;
    LibraryInterface libraryInterface;

    @Before
    public void initializeBooks() throws IOException {
        books = new ArrayList<Item>();
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
        String bookDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookDetails = brFile.readLine()) != null) {
            String attributes[] = bookDetails.split(",");
            books.add(new Book(attributes[0], attributes[1], attributes[2]));
        }
    }
    @Before
    public void initializeMovies() throws IOException {
        movies = new ArrayList<Item>();
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Movies"));
        String movieDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((movieDetails = brFile.readLine()) != null) {
            String attributes[] = movieDetails.split(",");
            movies.add(new Movie(attributes[0], attributes[1], attributes[2], attributes[3]));
        }
    }
    @Before
    public void initializeLibrarianInterface() {
        libraryInterface = new LibraryInterface(new Library(books),new Library(movies), new UserInterface());
    }
    @Test
    public void shouldCheckSuccessfulCheckoutMessage()  {
        assertTrue(libraryInterface.checkout("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckoutMessage()  {
        assertFalse(libraryInterface.checkout("Harry Potter"));
    }


    @Test
    public void shouldCheckSuccessfulCheckinMessage()  {
        String bookName = "Terms & Conditions";
        libraryInterface.checkout(bookName);
        assertTrue(libraryInterface.checkInProcessOfBook(bookName));
    }

    @Test
    public void shouldCheckUnsucessfulCheckinStatus() {
        assertFalse(libraryInterface.checkInProcessOfBook("Harry"));
    }
    @Test
    public void shouldCheckSuccessfulMessageOfCheckoutOfMovie() {
        assertTrue(libraryInterface.checkOutProcessOfMovie("Inception"));
    }
    @Test
    public void shouldCheckUnuccessfulMessageOfCheckoutOfMovie() {
        assertFalse(libraryInterface.checkOutProcessOfMovie("Harry"));
    }
    @Test
    public void shouldCheckSuccessfulMessageOfCheckinOfMovie() {
        String movieName = "Inception";
        libraryInterface.checkOutProcessOfMovie(movieName);
        assertTrue(libraryInterface.checkInProcessMovie(movieName));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckinMessageOfMovie()  {
        assertFalse(libraryInterface.checkInProcessMovie("Harry"));
    }
}
