package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

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
        assertEquals("Thank you! Enjoy the book\n", librarianInterface.checkOutProcessOfBook("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckoutMessage()  {
        assertEquals("That book is not available\n", librarianInterface.checkOutProcessOfBook("Harry Potter"));
    }

    @Test
    public void shouldCheckForIncorrectMessageForSucceesfulCheckout()  {
        assertThat(librarianInterface.checkOutProcessOfBook("Sherlock Holmes"), not("That book is not available\n"));
    }
    @Test
    public void shouldCheckIncorrectMessageForUnsucessfulCheckout()  {
        assertThat(librarianInterface.checkOutProcessOfBook("Harry"), not("Thank you! Enjoy the book\n"));
    }

    @Test
    public void shouldCheckSuccessfulCheckinMessage()  {
        String bookName = "Terms & Conditions";
        librarianInterface.checkOutProcessOfBook(bookName);
        assertThat(librarianInterface.checkInProcessOfBook(bookName), is("Thank you for returning the book\n"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckinMessage()  {
        assertThat(librarianInterface.checkInProcessOfBook("Harry Potter"), is("That is not a valid book to return\n"));
    }

    @Test
    public void shouldCheckForIncorrectMessageForSucceesfulCheckin()  {
        librarianInterface.checkOutProcessOfBook("Sherlock Holmes");
        assertThat(librarianInterface.checkInProcessOfBook("Sherlock Holmes"), not("That is not a valid book to return\n"));
    }
    @Test
    public void shouldCheckIncorrectMessageForUnsucessfulCheckin()  {
        assertThat(librarianInterface.checkInProcessOfBook("Harry"), not("Thank you! Enjoy the book\n"));
    }
    @Test
    public void shouldCheckSuccessfulMessageOfCheckoutOfMovie() {
        assertThat(librarianInterface.checkOutProcessOfMovie("Inception"), not("Thank You!, Enjoy the movie"));
    }
    @Test
    public void shouldCheckSuccessfulMessageOfCheckinOfMovie() {
        String movieName = "Inception";
        librarianInterface.checkOutProcessOfMovie(movieName);
        assertThat(librarianInterface.checkInProcessMovie(movieName), is("Thank you for returning the movie\n"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckoutMessageOfMovie()  {
        assertEquals("That movie is not available\n", librarianInterface.checkOutProcessOfMovie("Harry"));
    }
    @Test
    public void shouldCheckUnsucessfulCheckinMessageOfMovie() {
        assertEquals("That is not a valid movie to return\n", librarianInterface.checkInProcessMovie("Home Alone"));
    }
}
