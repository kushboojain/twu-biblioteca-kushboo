package com.twu.biblioteca;

/**
 * Created by khusbooj on 14/01/15.
 */
public class ReturnBookOption extends Option {
    LibrarianInterface librarianInterfaceInterface;
    private UserInterface userInterface;

    @Override
    public void performedAction() {
        librarianInterfaceInterface.performCheckin();
    }

    public ReturnBookOption(LibrarianInterface librarianInterfaceInterface, UserInterface userInterface) {
        this.userInterface = userInterface;
        name = setOptionName();
        this.librarianInterfaceInterface = librarianInterfaceInterface;
    }

    @Override
    protected String setOptionName() {
        return "Return Book";

    }
}
