package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LoginOption extends Option {
    LoginInterface loginInterface;

    public LoginOption(LoginInterface loginInterface) {
        name = getOptionName();
        this.loginInterface = loginInterface;
    }

    @Override
    public void execute() {
       loginInterface.signIn();
    }

    @Override
    protected String getOptionName() {
        return "SignIn";
    }


}
