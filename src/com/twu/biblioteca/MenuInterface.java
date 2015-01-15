package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public class MenuInterface {
    UserInterface userInterface;
    LoginInterface loginInterface;
    LibrarianInterface librarianInterface;
    CustomerDetails customerLoggedIn = null;
    Option[] availableOptions;

    public MenuInterface(LibrarianInterface librarianInterface, LoginInterface loginInterface) {
        this.librarianInterface = librarianInterface;
        this.loginInterface = loginInterface;
        availableOptions = new Option[]{new LoginOption(userInterface, loginInterface),new ListBooksOption(librarianInterface), new ListMoviesOption(librarianInterface), new CheckoutBookOption(librarianInterface), new ReturnBookOption(librarianInterface), new CheckoutMovieOption(librarianInterface), new ReturnMovieOption(librarianInterface), new QuitOption()};
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

    ArrayList<String> getOptionsList() {
        ArrayList<String> option = new ArrayList<String>();
        for (Option availableOption : availableOptions) {
            option.add(availableOption.getOptionName());
        }

        return option;
    }
}
