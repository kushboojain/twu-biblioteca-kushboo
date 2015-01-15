package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CheckinMovieOptionTest {
    @Test
    public void shouldCheckReturnOptionName() {
        assertEquals("Return Movie", new ReturnMovieOption(new LibrarianInterface(new Library(new ArrayList<Item>()), new Library(new ArrayList<Item>()),new UserInterface())).setOptionName());
    }
}
