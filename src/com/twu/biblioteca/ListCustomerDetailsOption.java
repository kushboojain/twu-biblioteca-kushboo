package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class ListCustomerDetailsOption extends Option {
    private LoginInterface loginInterface;

    public ListCustomerDetailsOption(LoginInterface loginInterface) {
        name = setOptionName();
        this.loginInterface = loginInterface;
    }

    @Override
    public void performedAction() {
        loginInterface.listDetails();
    }

    @Override
    protected String setOptionName() {
        return "My Details";
    }
}
