package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LoginInterface {

    private UserInterface userInterface;
    private ArrayList<CustomerDetails> customers;


    public LoginInterface(UserInterface userInterface, ArrayList<CustomerDetails> customers) {
        this.userInterface = userInterface;
        this.customers = customers;
    }

    public CustomerDetails signIn() {
        String number = userInterface.signinNumber();
        String password = userInterface.signinPassword();
        for (CustomerDetails customer : customers) {
            if(customer.getLibraryNumber().equals(number) && customer.getPassword().equals(password))
                return customer;
        }
        return null;

    }
}
