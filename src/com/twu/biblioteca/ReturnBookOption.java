package com.twu.biblioteca;

/**
 * Created by khusbooj on 14/01/15.
 */
public class ReturnBookOption extends Option {
    LibrarianInterface librarianInterfaceInterface;


    public ReturnBookOption(LibrarianInterface librarianInterfaceInterface) {
        name = setOptionName();
        this.librarianInterfaceInterface = librarianInterfaceInterface;
    }
    @Override
    public void performedAction() {
        librarianInterfaceInterface.performCheckin();
    }


    @Override
    protected String setOptionName() {
        return "Return Book";

    }
}
