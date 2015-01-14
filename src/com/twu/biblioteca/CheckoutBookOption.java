package com.twu.biblioteca;

/**
 * Created by khusbooj on 14/01/15.
 */
public class CheckoutBookOption extends Option {
    private final LibrarianInterface interfaceLibrarianInterface;
    private final UserInterface userInterface;

    @Override
    public void performedAction() {
        interfaceLibrarianInterface.performCheckout();
    }

    @Override
    protected String setOptionName() {
        return "Checkout Book";
    }

    public CheckoutBookOption(LibrarianInterface interfaceLibrarianInterface, UserInterface userInterface) {
        this.interfaceLibrarianInterface = interfaceLibrarianInterface;
        this.userInterface = userInterface;
        name = setOptionName();
    }
}
