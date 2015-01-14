package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibrarianTest {
    private ArrayList<Book> books = new ArrayList<Book>();

    @Before
    public void initializeBooks() throws IOException {
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
        String bookDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookDetails = brFile.readLine()) != null) {
            String attributes[] = bookDetails.split(",");
            books.add(new Book(attributes[0], attributes[1], attributes[2]));
        }
    }

    @Test
    public void shouldCheckSuccessfulCheckoutMessage()  {
        assertEquals("Thank you! Enjoy the book", new Librarian(new Library(books)).performCheckout("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckoutMessage()  {
        assertEquals("That book is not available", new Librarian(new Library(books)).performCheckout("Harry Potter"));
    }

    @Test
    public void shouldCheckForIncorrectMessageForSucceesfulCheckout()  {
        assertThat(new Librarian(new Library(books)).performCheckout("Sherlock Holmes"), not("That book is not available"));
    }
    @Test
    public void shouldCheckIncorrectMessageForUnsucessfulCheckout()  {
        assertThat(new Librarian(new Library(books)).performCheckout("Harry"), not("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldCheckSuccessfulCheckinMessage()  {
        String bookName = "Terms & Conditions";
        Librarian librarian = new Librarian(new Library(books));
        librarian.performCheckout(bookName);
        assertThat(librarian.performCheckin(bookName), is("Thank you for returning the book"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckinMessage() throws IOException {
        assertThat(new Librarian(new Library(books)).performCheckin("Harry Potter"), is("That is not a valid book to return"));
    }

    @Test
    public void shouldCheckForIncorrectMessageForSucceesfulCheckin() throws IOException {

        Librarian librarian = new Librarian(new Library(books));
        librarian.performCheckout("Sherlock Holmes");
        assertThat(librarian.performCheckin("Sherlock Holmes"), not("That is not a valid book to return"));
    }
    @Test
    public void shouldCheckIncorrectMessageForUnsucessfulCheckin() throws IOException {
        assertThat(new Librarian(new Library(books)).performCheckin("Harry"), not("Thank you! Enjoy the book"));
    }
}
