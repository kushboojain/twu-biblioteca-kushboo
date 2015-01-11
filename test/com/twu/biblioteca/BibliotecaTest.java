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
    private String[] options = {"ListBooks","Quit"};
    @Test
    public void shouldCheckWelcomeMessgae() {
        BibliotecaApp.displayWelcomeMessage();
        assertEquals("Hey...Welcome to Biblioteca\n", outContent.toString());
    }
    @Test
    public void shouldCheckListOfDetails() throws IOException {
        BibliotecaApp.booksDetails();
        assertEquals("1. Terms & Conditions           Robert Glancy                   2014\n" +
                "2. Sherlock Holmes              Sir Author Connon Doyle         1887\n" +
                "3. Diary of Wimpy Kid           Jeff Kinney                     2007\n", outContent.toString());
    }

    @Test
    public void shouldListValidOptions() {
        BibliotecaApp.options();
        String optionsList = "Choose from below:\n";
        for (String option : options) {
            optionsList += option + "\n";
        }

        assertEquals(optionsList, outContent.toString());
    }
    @Test
    public void shouldCheckInValidOptionMessage(){
        BibliotecaApp.checkInvalidOption("Books");
        assertEquals("Select a valid option!", outContent.toString());
    }

    @Test
    public void shouldCheckValidOption() {
        assertFalse(BibliotecaApp.checkInvalidOption("ListBooks"));
    }
    @Test
    public void shouldCheckInValidOption() {
        assertTrue(BibliotecaApp.checkInvalidOption("Books"));
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
