package com.twu.biblioteca;


import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CustomerDetails {

    private String libraryNumber;
    private String password;
    private final String name;
    private final String email;
    private final String phNo;

    public CustomerDetails(String libraryNumber, String password, String name, String email, String phNo) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phNo = phNo;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getDetails() {
        ArrayList<String> details = new ArrayList<String>();
        details.add(name);
        details.add(email);
        details.add(phNo);
        return details;
    }
}
