package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LogOutOption extends Option {
    private LoginInterface loginInterface;

    public LogOutOption(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
        name = getOptionName();

    }

    @Override
    public void execute() {
        loginInterface.signOut();
    }

    @Override
    protected String getOptionName() {
        return "Sign out";
    }
}
