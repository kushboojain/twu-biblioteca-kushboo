package com.twu.biblioteca;

/**
 * Created by khusbooj on 14/01/15.
 */
public class CheckoutBookOption extends Option {
    private final LibrarianInterface interfaceLibrarianInterface;

    @Override
    public void performedAction() {
        interfaceLibrarianInterface.performCheckout();
    }

    @Override
    protected String setOptionName() {
        return "Checkout Book";
    }

    public CheckoutBookOption(LibrarianInterface interfaceLibrarianInterface) {
        this.interfaceLibrarianInterface = interfaceLibrarianInterface;
        name = setOptionName();
    }
}
