package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LogOutOption extends Option {
    private LoginInterface loginInterface;

    public LogOutOption(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
        name = setOptionName();

    }

    @Override
    public void performedAction() {
        loginInterface.signOut();
    }

    @Override
    protected String setOptionName() {
        return "Sign out";
    }
}
