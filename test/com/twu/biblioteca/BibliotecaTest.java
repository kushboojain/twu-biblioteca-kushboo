package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 10/01/15.
 */
public class BibliotecaTest {
    private String[] options = {"ListBooks", "Checkout Book", "Return Book", "Quit"};

    @Test
    public void shouldCheckTrueForInvalidOption()  {
       assertTrue(new BibliotecaApp().isInvalidOption("Books"));
    }

    @Test
    public void shouldCheckValidOptionListBooks() {
        assertFalse(new BibliotecaApp().isInvalidOption("ListBooks"));
    }
    @Test
    public void shouldCheckValidOptionCheckoutBook() {
        assertEquals(new BibliotecaApp().isInvalidOption("Checkout Book"), false);
    }
    @Test
    public void shouldCheckValidOptionCheckinBook() {
        assertEquals(new BibliotecaApp().isInvalidOption("Return Book"), false);
    }
    @Test
    public void shouldCheckValidOptionQuit() {
        assertEquals(new BibliotecaApp().isInvalidOption("Quit"), false);
    }

}
