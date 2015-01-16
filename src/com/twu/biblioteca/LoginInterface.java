package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LoginInterface {

    private UserInterface userInterface;
    private ArrayList<CustomerDetails> customers;
    private MenuInterface menuInterface;
    private CustomerDetails loggedInCustomer;

    public LoginInterface(UserInterface userInterface, ArrayList<CustomerDetails> customers, MenuInterface menuInterface) {
        this.userInterface = userInterface;
        this.customers = customers;
        this.menuInterface = menuInterface;
    }

    public void signIn() {
        loggedInCustomer = performSignIn();
        menuInterface.setLoggedInCustomer(loggedInCustomer);
        userInterface.displaySignInStatus(getStatusOfLogin(loggedInCustomer));
        menuInterface.updateListAfterLogin();
    }

    private CustomerDetails performSignIn() {
        String number = userInterface.signinNumber();
        String password = userInterface.signinPassword();
        return getCustomerDetails(number, password);
    }

    private CustomerDetails getCustomerDetails(String number, String password) {
        for (CustomerDetails customer : customers) {
            if(customer.getLibraryNumber().equals(number) && customer.getPassword().equals(password))
                return customer;
        }
        return null;
    }

    boolean getStatusOfLogin(CustomerDetails loggedInCustomer) {
        if(loggedInCustomer != null)
            return true;
        else
            return false;
    }

    public void signOut() {
        loggedInCustomer = null;
        menuInterface.setLoggedInCustomer(null);
        userInterface.displaySignOutMessage();
        menuInterface.updateListAfterLogout();
    }

    public void listDetails() {
        userInterface.displayCustomerDetails(loggedInCustomer.getDetails());
    }
}
