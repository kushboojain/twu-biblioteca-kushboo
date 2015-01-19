package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CheckoutMovieOptionTest {
    @Test
    public void shouldCheckOptionName() {
        assertEquals(new CheckoutMovieOption(new LibraryInterface(new Library(new ArrayList<Item>()), new Library(new ArrayList<Item>()), new UserInterface())).getOptionName(), "Checkout Movie");
    }
}
