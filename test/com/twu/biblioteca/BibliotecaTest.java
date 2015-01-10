package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 10/01/15.
 */
public class BibliotecaTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //private String[] options = {"ListBooks"};
    @Test
    public void shouldCheckWelcomeMessgae() {
        BibliotecaApp.displayWelcomeMessage();
        assertEquals("Hey...Welcome to Biblioteca\n", outContent.toString());
    }
    @Test
    public void shouldCheckListOfDetails() throws IOException {
        BibliotecaApp.booksDetails();
        assertEquals("1. Terms & Conditions Robert Glancy 2014\n" +
                "2. Sherlock Holmes  Sir Author Connon Doyle 1887\n" +
                "3. Diary of Wimpy Kid   Jeff Kinney 2007\n", outContent.toString());
    }

    @Test
    public void shouldListOptions() {
        BibliotecaApp.options();
        assertEquals("Choose from below:\nListBooks\nQuit\n", outContent.toString());
    }
    @Test
    public void shouldCheckInValidOption(){
        BibliotecaApp.checkInvalidOption("Books");
        assertEquals("Select a valid option!", outContent.toString());
    }


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);

    }


}
