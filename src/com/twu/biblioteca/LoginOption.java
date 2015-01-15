package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LoginOption extends Option {
    UserInterface userInterface;
    LoginInterface loginInterface;

    public LoginOption(UserInterface userInterface, LoginInterface loginInterface) {
        name = setOptionName();
        this.userInterface = userInterface;
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
