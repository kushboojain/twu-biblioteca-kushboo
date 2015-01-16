package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by khusbooj on 15/01/15.
 */
public class MenuInterface {
    UserInterface userInterface;
    private final ArrayList<CustomerDetails> customers;
    private final BibliotecaApp bibliotecaApp;
    LoginInterface loginInterface;
    LibrarianInterface librarianInterface;
    CustomerDetails customerLoggedIn = null;
    ArrayList<Option> availableOptions;
    LoginOption loginOption;
    ListBooksOption listBooksOption;
    ListMoviesOption listMoviesOption;
    CheckoutBookOption checkoutBookOption;
    ReturnBookOption returnBookOption;
    CheckoutMovieOption checkoutMovieOption;
    QuitOption quitOption;
    ReturnMovieOption returnMovieOption;
    LogOutOption logOutOption;
    ListCustomerDetailsOption listCustomerDetailsOption;
    ListBooksBorrowedOption listBooksBorrowedOption;
    ListMoviesBorrowedOption listMoviesBorrowedOption;

    public MenuInterface(LibrarianInterface libInterface, UserInterface userInterface, ArrayList<CustomerDetails> customers, BibliotecaApp bibliotecaApp) {
        this.librarianInterface = libInterface;
        this.userInterface = userInterface;
        this.customers = customers;
        this.bibliotecaApp = bibliotecaApp;
        this.loginInterface = new LoginInterface(userInterface, this.customers, this);
        loginOption = new LoginOption(this.loginInterface);
        listBooksOption = new ListBooksOption(librarianInterface);
        listMoviesOption = new ListMoviesOption(librarianInterface);
        checkoutBookOption = new CheckoutBookOption(librarianInterface);
        returnBookOption = new ReturnBookOption(librarianInterface);
        checkoutMovieOption = new CheckoutMovieOption(librarianInterface);
        listBooksBorrowedOption = new ListBooksBorrowedOption(librarianInterface);
        listMoviesBorrowedOption = new ListMoviesBorrowedOption(librarianInterface);
        quitOption = new QuitOption(this);
        returnMovieOption = new ReturnMovieOption(librarianInterface);
        logOutOption = new LogOutOption(loginInterface);
        listCustomerDetailsOption = new ListCustomerDetailsOption(this.loginInterface);
        availableOptions = new ArrayList<Option>(Arrays.asList(listBooksOption, listMoviesOption, quitOption, loginOption));
    }

    public boolean isInvalidOption(String option) {
        for (Option availableOption : availableOptions) {
            if(availableOption.getOptionName().equals(option)){
                return false;
            }
        }
        return true;
    }

    void selectMenuOption(String optionFromUser) {
        for (Option availableOption : availableOptions) {
            if(availableOption.getOptionName().equals(optionFromUser)){
                availableOption.performedAction();
                break;
            }
        }
    }

    void updateListAfterLogin() {
        if(customerLoggedIn != null) {
            availableOptions.remove(loginOption);
            availableOptions.add(checkoutBookOption);
            availableOptions.add(returnBookOption);
            availableOptions.add(checkoutMovieOption);
            availableOptions.add(returnMovieOption);
            availableOptions.add(listCustomerDetailsOption);
            availableOptions.add(listBooksBorrowedOption);
            availableOptions.add(listMoviesBorrowedOption);
            availableOptions.add(logOutOption);

        }

    }
    void updateListAfterLogout() {
        if(customerLoggedIn == null) {
            availableOptions.remove(logOutOption);
            availableOptions.remove(checkoutBookOption);
            availableOptions.remove(returnBookOption);
            availableOptions.remove(checkoutMovieOption);
            availableOptions.remove(returnMovieOption);
            availableOptions.remove(listBooksBorrowedOption);
            availableOptions.remove(listMoviesBorrowedOption);
            availableOptions.remove(listCustomerDetailsOption);
            availableOptions.add(loginOption);

        }

    }

    ArrayList<String> getOptionsList() {
        ArrayList<String> option = new ArrayList<String>();
        for (Option availableOption : availableOptions) {
            option.add(availableOption.getOptionName());
        }

        return option;
    }

    public void setLoggedInCustomer(CustomerDetails loggedInCustomer) {
        customerLoggedIn = loggedInCustomer;
        librarianInterface.setLoggedInCustomer(customerLoggedIn);
    }

    public void stopApp() {
        bibliotecaApp.setStopStatus(true);
    }
}
