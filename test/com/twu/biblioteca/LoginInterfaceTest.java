package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LoginInterfaceTest {
    private UserInterface userInterface = new UserInterface();
    private ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<CustomerDetails> customers = new ArrayList<CustomerDetails>();
    LoginInterface loginInterface;
    CustomerDetails customer = new CustomerDetails("123-4567", "qwerty", "Henry", "hj@gm.com", "21367");

    @Before
    public void initialize() {

        customers.add(customer);
        loginInterface = new LoginInterface(userInterface, customers, new MenuInterface(new LibrarianInterface(new Library(items), new Library(items), userInterface),userInterface,new ArrayList<CustomerDetails>(),new BibliotecaApp()));
    }
    @Test
    public void shouldCheckStatusOfLoginForSuccessfulLogin() {
        assertTrue(loginInterface.getStatusOfLogin(customer));
    }
    @Test
    public void shouldCheckStatusOfLoginFOrUnSucccessfulLogin() {
        assertFalse(loginInterface.getStatusOfLogin(null));
    }
    @Test
    public void shouldCheckPerformSignInOfValidCustomer() {
        assertTrue(loginInterface.getStatusOfLogin(customer));
    }
    @Test
    public void shouldCheckPerformSignInOfInalidCustomer() {
        assertFalse(loginInterface.getStatusOfLogin(null));
    }
}
