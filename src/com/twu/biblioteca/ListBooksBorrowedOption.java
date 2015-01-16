package com.twu.biblioteca;

/**
 * Created by khusbooj on 16/01/15.
 */
public class ListBooksBorrowedOption extends Option {
    private LibrarianInterface librarianInterface;

    public ListBooksBorrowedOption(LibrarianInterface librarianInterface) {
        name = setOptionName();
        this.librarianInterface = librarianInterface;
    }

    @Override
    public void performedAction() {
        librarianInterface.listBorrowedBooks();

    }

    @Override
    protected String setOptionName() {
        return "List Borrowed Books";
    }
}
