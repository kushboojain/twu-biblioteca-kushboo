package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 15/01/15.
 */
public class MenuInterfaceTest {
    private UserInterface userInterface = new UserInterface();
    private ArrayList<Item> items = new ArrayList<Item>();
    MenuInterface menuInterface = new MenuInterface(new LibrarianInterface(new Library(items), new Library(items), userInterface),userInterface,new ArrayList<CustomerDetails>(),new BibliotecaApp());
    ArrayList<String> optionsBeforeLogin;
    ArrayList<String> optionsAfterLogin;
    @Before
    public void setOptions() {
        optionsBeforeLogin = new ArrayList<String>(Arrays.asList(new String[]{"ListBooks", "ListMovies", "Quit", "SignIn"}));
        optionsAfterLogin = new ArrayList<String>(Arrays.asList(new String[] {"ListBooks", "ListMovies", "Quit","Checkout Book","Return Book", "Checkout Movie", "Return Movie", "My Details", "List Borrowed Books", "List Borrowed Movies", "Sign out"}));
    }
    @Test
    public void shouldCheckValidOptionsBeforeLogin() {
        ArrayList<String> expectedOptions = menuInterface.getOptionsList();
        for (String option : optionsBeforeLogin) {
            assertTrue(expectedOptions.contains(option));
        }
    }

    @Test
    public void shouldCheclValidOptionsAfterLogin() {
        menuInterface.setLoggedInCustomer(new CustomerDetails("123-6789", "dwfr", "hen", "234@jr.com", "34264"));
        menuInterface.updateListAfterLogin();
        ArrayList<String> optionsList = menuInterface.getOptionsList();
        for (int i = 0, optionsAfterLoginSize = optionsAfterLogin.size(); i < optionsAfterLoginSize; i++) {
            String option = optionsAfterLogin.get(i);
            assertEquals(option, optionsList.get(i));
        }

    }
    @Test
    public void shouldCheckValidOptionsAfterLogout() {
        menuInterface.updateListAfterLogout();
        ArrayList<String> expectedOptions = menuInterface.getOptionsList();
        for (String option : optionsBeforeLogin) {
            assertTrue(expectedOptions.contains(option));
        }

    }
    @Test
    public void shouldCheckValidOptionBeforeLogin() {
        assertFalse(menuInterface.isInvalidOption("SignIn"));
    }
    @Test
    public void shouldCheckInvalidOptionBeforeLogin() {
        assertTrue(menuInterface.isInvalidOption("Sign In"));
    }
    @Test
    public void shouldCheckValidOptionAfterLogout() {
        assertFalse(menuInterface.isInvalidOption("SignIn"));
    }
    @Test
    public void shouldCheckInalidOptionAfterLogout() {
        assertTrue(menuInterface.isInvalidOption("Sign In"));
    }
}
