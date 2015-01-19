package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class ListCustomerDetailsOption extends Option {
    private LoginInterface loginInterface;

    public ListCustomerDetailsOption(LoginInterface loginInterface) {
        name = getOptionName();
        this.loginInterface = loginInterface;
    }

    @Override
    public void execute() {
        loginInterface.listDetails();
    }

    @Override
    protected String getOptionName() {
        return "My Details";
    }
}
