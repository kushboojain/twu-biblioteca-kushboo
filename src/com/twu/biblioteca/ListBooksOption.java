package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class ListBooksOption extends Option {
    private LibrarianInterface librarianInterfaceInterface;

    @Override
    public void performedAction() {
        librarianInterfaceInterface.listBooksDetails();
    }

    public ListBooksOption(LibrarianInterface librarianInterfaceInterface) {
        this.librarianInterfaceInterface = librarianInterfaceInterface;
        name = setOptionName();
    }

    @Override
    protected String setOptionName() {
        return "ListBooks";
    }
}
