package com.twu.biblioteca;

/**
 * Created by khusbooj on 14/01/15.
 */
public class CheckoutBookOption extends Option {
    private final LibraryInterface libraryInterface;

    @Override
    public void execute() {
        libraryInterface.performCheckoutOfBook();
    }

    @Override
    protected String getOptionName() {
        return "Checkout Book";
    }

    public CheckoutBookOption(LibraryInterface libraryInterface) {
        this.libraryInterface = libraryInterface;
        name = getOptionName();
    }
}
