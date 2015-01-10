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

    @Test
    public void shouldCheckWelcomeMessgae() {
        BibliotecaApp.displayWelcomeMessage();
        assertEquals("Hey...Welcome to Biblioteca", outContent.toString());
    }
    @Test
    public void shouldCheckListOfOptions() throws IOException {
        BibliotecaApp.listOfBooks();
        assertEquals("1. Terms and Conditions\n2. Sherlock Holmes\n3. Diary of Wimpy Kid", outContent.toString());
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
