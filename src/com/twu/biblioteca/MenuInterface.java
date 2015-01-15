package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by khusbooj on 15/01/15.
 */
public class MenuInterface {
    UserInterface userInterface;
    LoginInterface loginInterface;
    LibrarianInterface librarianInterface;
    CustomerDetails customerLoggedIn = null;
    Option[] availableOptions;
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

    public MenuInterface(LibrarianInterface librarianInterface, UserInterface userInterface, ArrayList<CustomerDetails> customers) {
        this.librarianInterface = librarianInterface;
        this.userInterface = userInterface;
        this.loginInterface = new LoginInterface(userInterface,customers,this);
        loginOption = new LoginOption(this.loginInterface);
        listBooksOption = new ListBooksOption(librarianInterface);
        listMoviesOption = new ListMoviesOption(librarianInterface);
        checkoutBookOption = new CheckoutBookOption(librarianInterface);
        returnBookOption = new ReturnBookOption(librarianInterface);
        checkoutMovieOption = new CheckoutMovieOption(librarianInterface);
        quitOption = new QuitOption();
        returnMovieOption = new ReturnMovieOption(librarianInterface);
        logOutOption = new LogOutOption(userInterface,this);
        listCustomerDetailsOption = new ListCustomerDetailsOption(userInterface, customerLoggedIn);
        availableOptions = new Option[]{loginOption, listBooksOption, listMoviesOption, quitOption};
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
            Arrays.asList(availableOptions).remove(loginOption);
            Arrays.asList(availableOptions).add(logOutOption);
            Arrays.asList(availableOptions).add(checkoutBookOption);
            Arrays.asList(availableOptions).add(returnBookOption);
            Arrays.asList(availableOptions).add(checkoutMovieOption);
            Arrays.asList(availableOptions).add(returnMovieOption);
        }

    }
    void updateListAfterLogout() {
        if(customerLoggedIn == null) {
            Arrays.asList(availableOptions).add(loginOption);
            Arrays.asList(availableOptions).remove(logOutOption);
            Arrays.asList(availableOptions).remove(checkoutBookOption);
            Arrays.asList(availableOptions).remove(returnBookOption);
            Arrays.asList(availableOptions).remove(checkoutMovieOption);
            Arrays.asList(availableOptions).remove(returnMovieOption);
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
    }
}
