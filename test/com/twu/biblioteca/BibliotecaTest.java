package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
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
    private String[] options = {"ListBooks", "Checkout Book", "Return Book", "Quit"};
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
        assertEquals("Welcome to Biblioteca", outContent.toString());
    }

    @Test
    public void shouldListValidOptions() throws IOException {
        String optionsList = "Choose from below:\n";
        for (String option : options) {
            optionsList += option + "\n";
        }
        assertEquals(optionsList, new BibliotecaApp().optionsList());
    }
    @Test
    public void shouldCheckTrueForInvalidOption() throws IOException {
       assertTrue(new BibliotecaApp().isInvalidOption("Books"));
    }

    @Test
    public void shouldCheckFalseForValidOption() throws IOException {
        assertFalse(new BibliotecaApp().isInvalidOption("ListBooks"));
    }

}
