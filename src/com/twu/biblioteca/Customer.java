package com.twu.biblioteca;


import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public class Customer {

    private String libraryNumber;
    private String password;
    private final String name;
    private final String email;
    private final String phNo;

    public Customer(String libraryNumber, String password, String name, String email, String phNo) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phNo = phNo;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    boolean checkValidPassword(String inputPassword) {
        if(password.equals(inputPassword))
            return true;
        else
            return false;
    }
    public ArrayList<String> getDetails() {
        ArrayList<String> details = new ArrayList<String>();
        details.add(name);
        details.add(email);
        details.add(phNo);
        return details;
    }

    public String getPhno() {
        return phNo;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
