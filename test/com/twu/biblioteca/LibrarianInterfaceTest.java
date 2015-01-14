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
public class LibrarianInterfaceTest {
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
        assertEquals("Thank you! Enjoy the book\n", new LibrarianInterface(new Library(books), new UserInterface()).checkOutProcess("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckoutMessage()  {
        assertEquals("That book is not available\n", new LibrarianInterface(new Library(books), new UserInterface()).checkOutProcess("Harry Potter"));
    }

    @Test
    public void shouldCheckForIncorrectMessageForSucceesfulCheckout()  {
        assertThat(new LibrarianInterface(new Library(books), new UserInterface()).checkOutProcess("Sherlock Holmes"), not("That book is not available\n"));
    }
    @Test
    public void shouldCheckIncorrectMessageForUnsucessfulCheckout()  {
        assertThat(new LibrarianInterface(new Library(books), new UserInterface()).checkOutProcess("Harry"), not("Thank you! Enjoy the book\n"));
    }

    @Test
    public void shouldCheckSuccessfulCheckinMessage()  {
        String bookName = "Terms & Conditions";
        LibrarianInterface librarianInterface = new LibrarianInterface(new Library(books), new UserInterface());
        librarianInterface.checkOutProcess(bookName);
        assertThat(librarianInterface.checkInProcess(bookName), is("Thank you for returning the book\n"));
    }
    @Test
    public void shouldCheckUnsuccessfulCheckinMessage() throws IOException {
        assertThat(new LibrarianInterface(new Library(books), new UserInterface()).checkInProcess("Harry Potter"), is("That is not a valid book to return\n"));
    }

    @Test
    public void shouldCheckForIncorrectMessageForSucceesfulCheckin() throws IOException {

        LibrarianInterface librarianInterface = new LibrarianInterface(new Library(books), new UserInterface());
        librarianInterface.checkOutProcess("Sherlock Holmes");
        assertThat(librarianInterface.checkInProcess("Sherlock Holmes"), not("That is not a valid book to return\n"));
    }
    @Test
    public void shouldCheckIncorrectMessageForUnsucessfulCheckin() throws IOException {
        assertThat(new LibrarianInterface(new Library(books), new UserInterface()).checkInProcess("Harry"), not("Thank you! Enjoy the book\n"));
    }
}
