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
    MenuInterface menuInterface = new MenuInterface(new LibraryInterface(new Library(items), new Library(items), userInterface),userInterface,new ArrayList<Customer>(),new BibliotecaApp());
    ArrayList<String> optionsBeforeLogin;
    ArrayList<String> optionsAfterLogin;
    @Before
    public void setOptions() {
        optionsBeforeLogin = new ArrayList<String>(Arrays.asList(new String[]{"ListBooks", "ListMovies", "Quit", "SignIn"}));
        optionsAfterLogin = new ArrayList<String>(Arrays.asList(new String[] {"ListBooks", "ListMovies", "Quit","Checkout Book","Return Book", "Checkout Movie", "Return Movie", "My Details", "List Borrowed Books", "List Borrowed Movies", "Sign out"}));
    }
    @Test
    public void shouldCheckValidOptionsBeforeLogin() {
        ArrayList<Option> expectedOptions = menuInterface.getOptionsList();
        for (int i = 0, optionsAfterLoginSize = optionsBeforeLogin.size(); i < optionsAfterLoginSize; i++) {
            String option = optionsBeforeLogin.get(i);
            assertEquals(option, expectedOptions.get(i).getOptionName());
        }

    }

    @Test
    public void shouldCheclValidOptionsAfterLogin() {
        menuInterface.updateListAfterLogin(new Customer("123-6789", "dwfr", "hen", "234@jr.com", "34264"));
        ArrayList<Option> optionsList = menuInterface.getOptionsList();
        for (int i = 0, optionsAfterLoginSize = optionsAfterLogin.size(); i < optionsAfterLoginSize; i++) {
            String option = optionsAfterLogin.get(i);
            assertEquals(option, optionsList.get(i).getOptionName());
        }

    }
    @Test
    public void shouldCheckValidOptionsAfterLogout() {
        menuInterface.updateListAfterLogout(null);
        ArrayList<Option> expectedOptions = menuInterface.getOptionsList();
        for (int i = 0, optionsAfterLoginSize = optionsBeforeLogin.size(); i < optionsAfterLoginSize; i++) {
            String option = optionsBeforeLogin.get(i);
            assertEquals(option, expectedOptions.get(i).getOptionName());
        }

    }

}
