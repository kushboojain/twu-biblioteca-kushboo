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
        assertEquals(new ReturnBookOption(new LibraryInterface(new Library(new ArrayList<Item>()),new Library(new ArrayList<Item>()), new UserInterface())).getOptionName(), "Return Book");
    }
}
