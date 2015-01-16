package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 16/01/15.
 */
public class ListMoviesBorrowedOptionTest {
    @Test
    public void shouldCheckOptionName() {
        assertEquals(new ListMoviesBorrowedOption(new LibrarianInterface(new Library(new ArrayList<Item>()), new Library(new ArrayList<Item>()),new UserInterface())).getOptionName(), "List Borrowed Movies");
    }
}
