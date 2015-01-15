package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 14/01/15.
 */
public class ListBooksOptionTest {
    @Test
    public void shouldCheckOptionName() {
        assertEquals(new ListBooksOption(new LibrarianInterface(new Library(new ArrayList<Book>()), new UserInterface())).getOptionName(), "ListBooks");
    }
}
