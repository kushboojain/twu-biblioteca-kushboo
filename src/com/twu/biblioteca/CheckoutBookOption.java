package com.twu.biblioteca;

/**
 * Created by khusbooj on 14/01/15.
 */
public class CheckoutBookOption extends Option {
    private final Librarian manager;
    private final UserInterface userInterface;

    @Override
    public void performedAction() {
        manager.performCheckout(userInterface);
    }

    @Override
    protected String setOptionName() {
        return "Checkout Book";
    }

    public CheckoutBookOption(Librarian manager, UserInterface userInterface) {
        this.manager = manager;
        this.userInterface = userInterface;
        name = setOptionName();
    }
}
