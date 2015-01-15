package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LoginInterface {

    private UserInterface userInterface;
    private ArrayList<CustomerDetails> customers;
    private MenuInterface menuInterface;

    public LoginInterface(UserInterface userInterface, ArrayList<CustomerDetails> customers, MenuInterface menuInterface) {
        this.userInterface = userInterface;
        this.customers = customers;
        this.menuInterface = menuInterface;
    }

    public void signIn() {
        CustomerDetails loggedInCustomer = performSignIn();
        menuInterface.setLoggedInCustomer(loggedInCustomer);
        userInterface.displaySignInStatus(getStatusOfLogin(loggedInCustomer));
        menuInterface.updateListAfterLogin();
    }

    private CustomerDetails performSignIn() {
        String number = userInterface.signinNumber();
        String password = userInterface.signinPassword();
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
        menuInterface.setLoggedInCustomer(null);
        userInterface.displaySignOutMessage();
        menuInterface.updateListAfterLogout();
    }
}
