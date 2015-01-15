package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 15/01/15.
 */
public class ListMoviesOptionTest {
    @Test
    public void shouldCheckOptionName() {
        assertEquals(new ListMoviesOption(new LibrarianInterface(new Library(new ArrayList<Item>()), new Library(new ArrayList<Item>()),new UserInterface())).getOptionName(), "ListMovies");
    }
}
