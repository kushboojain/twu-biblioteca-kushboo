package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


/**
 * Created by khusbooj on 14/01/15.
 */
public class UserInterfaceTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));

    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldCheckWelcomeMessgae()  {
        new UserInterface().displayWelcomeMessage();
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldCheckPrint() {
        new UserInterface().print("x");
        assertEquals("x", outContent.toString());
    }

}
