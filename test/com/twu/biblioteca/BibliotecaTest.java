package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 10/01/15.
 */
public class BibliotecaTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String[] options = {"ListBooks", "Checkout Book", "Quit"};
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));

    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldCheckWelcomeMessgae() throws IOException {
        new BibliotecaApp().displayWelcomeMessage();
        assertEquals("Hey...Welcome to Biblioteca\n", outContent.toString());
    }
    @Test
    public void shouldCheckListOfDetails() throws IOException {
        new BibliotecaApp().booksDetails();
        assertEquals("Terms & Conditions\t\tRobert Glancy\t\t2014\n" +
                "Sherlock Holmes\t\tSir Author Connon Doyle\t\t1887\n" +
                "Diary of Wimpy Kid\t\tJeff Kinney\t\t2007\n", outContent.toString());
    }

    @Test
    public void shouldListValidOptions() throws IOException {
        new BibliotecaApp().options();
        String optionsList = "Choose from below:\n";
        for (String option : options) {
            optionsList += option + "\n";
        }

        assertEquals(optionsList, outContent.toString());
    }
    @Test
    public void shouldCheckInValidOptionMessage() throws IOException {
        new BibliotecaApp().checkInvalidOption("Books");
        assertEquals("Select a valid option!", outContent.toString());
    }

    @Test
    public void shouldCheckValidOption() throws IOException {
        assertFalse(new BibliotecaApp().checkInvalidOption("ListBooks"));
    }
    @Test
    public void shouldCheckInValidOption() throws IOException {
        assertTrue(new BibliotecaApp().checkInvalidOption("Books"));
    }
    @Test
    public void shouldCheckCheckingOutBooks() throws IOException {
        BibliotecaApp Biblioteca = new BibliotecaApp();
        Biblioteca.checkOutBook("Terms & Conditions");
        Biblioteca.booksDetails();
        assertEquals("Sherlock Holmes\t\tSir Author Connon Doyle\t\t1887\n" +
                "Diary of Wimpy Kid\t\tJeff Kinney\t\t2007\n", outContent.toString());
    }

    @Test
    public void shouldCheckSuccessfulCheckout() throws IOException {
        assertEquals("Thank you! Enjoy the book", new BibliotecaApp().checkOutBook("Sherlock Holmes"));
    }
    
}
