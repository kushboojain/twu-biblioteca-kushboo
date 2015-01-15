package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibrarianInterfaceTest {
    private ArrayList<Item> books;
    private ArrayList<Item> movies;
    LibrarianInterface librarianInterface;

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
        librarianInterface = new LibrarianInterface(new Library(books),new Library(movies), new UserInterface());
    }
    @Test
    public void shouldCheckSuccessfulCheckoutMessage()  {
        assertTrue(librarianInterface.checkOutProcessOfBook("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckoutMessage()  {
        assertFalse(librarianInterface.checkOutProcessOfBook("Harry Potter"));
    }


    @Test
    public void shouldCheckSuccessfulCheckinMessage()  {
        String bookName = "Terms & Conditions";
        librarianInterface.checkOutProcessOfBook(bookName);
        assertTrue(librarianInterface.checkInProcessOfBook(bookName));
    }

    @Test
    public void shouldCheckUnsucessfulCheckinStatus() {
        assertFalse(librarianInterface.checkInProcessOfBook("Harry"));
    }
    @Test
    public void shouldCheckSuccessfulMessageOfCheckoutOfMovie() {
        assertTrue(librarianInterface.checkOutProcessOfMovie("Inception"));
    }
    @Test
    public void shouldCheckUnuccessfulMessageOfCheckoutOfMovie() {
        assertFalse(librarianInterface.checkOutProcessOfMovie("Harry"));
    }
    @Test
    public void shouldCheckSuccessfulMessageOfCheckinOfMovie() {
        String movieName = "Inception";
        librarianInterface.checkOutProcessOfMovie(movieName);
        assertTrue(librarianInterface.checkInProcessMovie(movieName));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckinMessageOfMovie()  {
        assertFalse(librarianInterface.checkInProcessMovie("Harry"));
    }
}
