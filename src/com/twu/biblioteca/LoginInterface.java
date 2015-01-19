package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LoginInterface {

    private UserInterface userInterface;
    private ArrayList<Customer> customers;
    private Customer loggedInCustomer;
    private MenuInterface menuInterface;

    public LoginInterface(UserInterface userInterface, ArrayList<Customer> customers,MenuInterface menuInterface) {
        this.userInterface = userInterface;
        this.customers = customers;
        this.menuInterface = menuInterface;
    }

    public void signIn() {
        loggedInCustomer = performSignIn();
        menuInterface.setLoggedInCustomer(loggedInCustomer);
        userInterface.displaySignInStatus(getStatusOfLogin(loggedInCustomer));
        menuInterface.updateListAfterLogin(loggedInCustomer);
    }

    private Customer performSignIn() {
        String number = userInterface.signinNumber();
        String password = userInterface.signinPassword();
        Customer customer = getCustomerDetails(number);
        if(customer != null) {
            if(customer.checkValidPassword(password))
                return customer;
            else
                return null;
        }
        return null;
    }

    private Customer getCustomerDetails(String number) {
        for (Customer customer : customers) {
            if(customer.getLibraryNumber().equals(number))
                return customer;
        }
        return null;
    }

    boolean getStatusOfLogin(Customer loggedInCustomer) {
        if(loggedInCustomer != null)
            return true;
        else
            return false;
    }

    public void signOut() {
        loggedInCustomer = null;
        menuInterface.setLoggedInCustomer(null);
        userInterface.displaySignOutMessage();
        menuInterface.updateListAfterLogout(null);
    }

    public void listDetails() {
        userInterface.displayCustomerDetails(loggedInCustomer);
    }
}
