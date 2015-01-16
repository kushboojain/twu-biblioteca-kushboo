package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 14/01/15.
 */
public class QuitOptionTest {
    @Test
    public void shouldCheckQuitOptionName() {
        UserInterface userInterface = new UserInterface();
        ArrayList<Item> items = new ArrayList<Item>();
        assertEquals("Quit", new QuitOption(new MenuInterface(new LibrarianInterface(new Library(items), new Library(items), userInterface),userInterface,new ArrayList<CustomerDetails>(),new BibliotecaApp() )).getOptionName());
    }
}
