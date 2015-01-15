package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class ReturnMovieOption extends Option {
    LibrarianInterface librarianInterfaceInterface;


    public ReturnMovieOption(LibrarianInterface librarianInterfaceInterface) {
        name = setOptionName();
        this.librarianInterfaceInterface = librarianInterfaceInterface;
    }
    @Override
    public void performedAction() {
        librarianInterfaceInterface.performCheckinOfMovie();
    }


    @Override
    protected String setOptionName() {
        return "Return Movie";

    }
}
