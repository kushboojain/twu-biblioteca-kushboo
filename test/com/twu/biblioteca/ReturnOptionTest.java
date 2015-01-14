package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 14/01/15.
 */
public class ReturnOptionTest {
    @Test
    public void shouldCheckReturnOptionName() {
        assertEquals(new ReturnBookOption(new Librarian(new Library(new ArrayList<Book>())), new UserInterface()).getOptionName(), "Return Book");
    }
}
