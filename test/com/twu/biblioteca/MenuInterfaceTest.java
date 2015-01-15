package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 15/01/15.
 */
public class MenuInterfaceTest {
    MenuInterface menuInterface = new MenuInterface(new LibrarianInterface(new Library(new ArrayList<Item>()),new Library(new ArrayList<Item>()),new UserInterface()), new LoginInterface(new UserInterface(), customers));



    @Test
    public void shouldCheckTrueForInvalidOption()  {
        assertTrue(menuInterface.isInvalidOption("Books"));
    }

    @Test
    public void shouldCheckValidOptionListBooks() {
        assertFalse(menuInterface.isInvalidOption("ListBooks"));
    }
    @Test
    public void shouldCheckValidOptionCheckoutBook() {
        assertEquals(menuInterface.isInvalidOption("Checkout Book"), false);
    }
    @Test
    public void shouldCheckValidOptionCheckinBook() {
        assertEquals(menuInterface.isInvalidOption("Return Book"), false);
    }
    @Test
    public void shouldCheckValidOptionQuit() {
        assertEquals(menuInterface.isInvalidOption("Quit"), false);
    }

    @Test
    public void shouldCheckValidOptionCheckinMovie() {
        assertEquals(menuInterface.isInvalidOption("Return Movie"), false);
    }

    @Test
    public void shouldCheckValidOptionCheckoutMovie() {
        assertEquals(menuInterface.isInvalidOption("Checkout Movie"), false);
    }

}
