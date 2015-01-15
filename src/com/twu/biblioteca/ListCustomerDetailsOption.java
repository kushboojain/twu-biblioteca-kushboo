package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class ListCustomerDetailsOption extends Option {
    private final UserInterface userInterface;
    private final CustomerDetails customerLoggedIn;

    public ListCustomerDetailsOption(UserInterface userInterface, CustomerDetails customerLoggedIn) {

        this.userInterface = userInterface;
        this.customerLoggedIn = customerLoggedIn;
    }

    @Override
    public void performedAction() {
        userInterface.displayCustomerDetails(customerLoggedIn.getDetails());
    }

    @Override
    protected String setOptionName() {
        return "My Details";
    }
}
