package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CheckoutMovieOption extends Option{
    private LibraryInterface libraryInterface;

    public CheckoutMovieOption(LibraryInterface libraryInterface) {
        this.libraryInterface = libraryInterface;
        name = getOptionName();
    }

    @Override
    public void execute() {
        libraryInterface.performCheckOutOfMovie();
    }

    @Override
    protected String getOptionName() {
        return "Checkout Movie";
    }
}
