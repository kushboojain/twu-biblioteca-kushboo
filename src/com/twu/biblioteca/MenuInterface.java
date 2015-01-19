package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by khusbooj on 15/01/15.
 */
public class MenuInterface {
    final LibraryInterface libraryInterface;
    private final LoginInterface loginInterface;
    UserInterface userInterface;
    private final ArrayList<Customer> customers;
    ArrayList<Option> menu;
    private final BibliotecaApp bibliotecaApp;

    public MenuInterface(LibraryInterface libInterface, UserInterface userInterface, ArrayList<Customer> customers, BibliotecaApp bibliotecaApp) {
        this.libraryInterface = libInterface;
        this.userInterface = userInterface;
        this.customers = customers;
        this.bibliotecaApp = bibliotecaApp;
        this.loginInterface = new LoginInterface(userInterface, this.customers, this);
        menu = new ArrayList<Option>(Arrays.asList(new ListBooksOption(libraryInterface), new ListMoviesOption(libraryInterface), new QuitOption(this), new LoginOption(this.loginInterface)));
    }


    void updateListAfterLogin(Customer customerLoggedIn) {
        if(customerLoggedIn != null) {
            menu.clear();
            menu.add(new ListBooksOption(libraryInterface));
            menu.add(new ListMoviesOption(libraryInterface));
            menu.add(new QuitOption(this));
            menu.add(new CheckoutBookOption(libraryInterface));
            menu.add(new ReturnBookOption(libraryInterface));
            menu.add(new CheckoutMovieOption(libraryInterface));
            menu.add(new ReturnMovieOption(libraryInterface));
            menu.add(new ListCustomerDetailsOption(this.loginInterface));
            menu.add(new ListBooksBorrowedOption(libraryInterface));
            menu.add(new ListMoviesBorrowedOption(libraryInterface));
            menu.add(new LogOutOption(loginInterface));

        }

    }
    void updateListAfterLogout(Customer customerLoggedIn) {
        if(customerLoggedIn == null) {
            menu.clear();
            menu.add(new ListBooksOption(libraryInterface));
            menu.add(new ListMoviesOption(libraryInterface));
            menu.add(new QuitOption(this));
            menu.add(new LoginOption(this.loginInterface));

        }

    }

    ArrayList<Option> getOptionsList() {
       return menu;
    }

    public void stopApp() {
        bibliotecaApp.setStopStatus(true);
    }
}
