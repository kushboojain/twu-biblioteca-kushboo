package com.twu.biblioteca;

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
    ArrayList<Customer> customers = new ArrayList<Customer>();
    LoginInterface loginInterface;
    Customer customer = new Customer("123-4567", "qwerty", "Henry", "hj@gm.com", "21367");

    @Before
    public void initialize() {

        customers.add(customer);
        loginInterface = new LoginInterface(userInterface, customers, new MenuInterface(new LibraryInterface(new Library(items), new Library(items), userInterface),userInterface,new ArrayList<Customer>(),new BibliotecaApp()));
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
