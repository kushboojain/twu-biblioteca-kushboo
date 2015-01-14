package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class ListBooksOption extends Option {
    private LibrarianInterface librarianInterfaceInterface;
    private UserInterface userInterface;

    @Override
    public void performedAction() {
        userInterface.print(librarianInterfaceInterface.listBooksDetails());
    }

    public ListBooksOption(LibrarianInterface librarianInterfaceInterface, UserInterface userInterface) {
        this.librarianInterfaceInterface = librarianInterfaceInterface;
        this.userInterface = userInterface;
        name = setOptionName();
    }

    @Override
    protected String setOptionName() {
        return "ListBooks";
    }
}
