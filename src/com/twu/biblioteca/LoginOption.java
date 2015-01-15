package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LoginOption extends Option {
    LoginInterface loginInterface;

    public LoginOption(LoginInterface loginInterface) {
        name = setOptionName();
        this.loginInterface = loginInterface;
    }

    @Override
    public void performedAction() {
       loginInterface.signIn();
    }

    @Override
    protected String setOptionName() {
        return "SignIn";
    }


}
