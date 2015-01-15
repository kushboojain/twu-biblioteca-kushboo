package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CheckoutMovieOption extends Option{
    private LibrarianInterface librarianInterface;

    public CheckoutMovieOption(LibrarianInterface librarianInterface) {
        this.librarianInterface = librarianInterface;
        name = setOptionName();
    }

    @Override
    public void performedAction() {
        librarianInterface.performCheckOutOfMovie();
    }

    @Override
    protected String setOptionName() {
        return "Checkout Movie";
    }
}
