package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class LogOutOption extends Option {
    private final UserInterface userInterface;
    private final MenuInterface menuInterface;
    private LoginInterface loginInterface;

    public LogOutOption(UserInterface userInterface, MenuInterface menuInterface) {

        this.userInterface = userInterface;
        this.menuInterface = menuInterface;
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
