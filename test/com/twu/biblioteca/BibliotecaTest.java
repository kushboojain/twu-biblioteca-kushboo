package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 10/01/15.
 */
public class BibliotecaTest {
    BibliotecaApp app = new BibliotecaApp();

    @Before
    public void initialize() throws IOException {
        app.setInterfaces();
    }

    @Test
    public void shouldCheckTrueForInvalidOption()  {
       assertTrue(app.isInvalidOption("Books"));
    }

    @Test
    public void shouldCheckValidOptionListBooks() {
        assertFalse(app.isInvalidOption("ListBooks"));
    }
    @Test
    public void shouldCheckValidOptionCheckoutBook() {
        assertEquals(app.isInvalidOption("Checkout Book"), false);
    }
    @Test
    public void shouldCheckValidOptionCheckinBook() {
        assertEquals(app.isInvalidOption("Return Book"), false);
    }
    @Test
    public void shouldCheckValidOptionQuit() {
        assertEquals(app.isInvalidOption("Quit"), false);
    }

    @Test
    public void shouldCheckValidOptionCheckinMovie() {
        assertEquals(app.isInvalidOption("Return Movie"), false);
    }

    @Test
    public void shouldCheckValidOptionCheckoutMovie() {
        assertEquals(app.isInvalidOption("Checkout Movie"), false);
    }

}
