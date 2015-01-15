package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class ListBooksOption extends Option {
    private LibrarianInterface librarianInterface;

    @Override
    public void performedAction() {
        librarianInterface.listBooksDetails();
    }

    public ListBooksOption(LibrarianInterface librarianInterfaceInterface) {
        this.librarianInterface = librarianInterfaceInterface;
        name = setOptionName();
    }

    @Override
    protected String setOptionName() {
        return "ListBooks";
    }
}
