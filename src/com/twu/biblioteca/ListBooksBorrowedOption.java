package com.twu.biblioteca;

/**
 * Created by khusbooj on 16/01/15.
 */
public class ListBooksBorrowedOption extends Option {
    private LibraryInterface libraryInterface;

    public ListBooksBorrowedOption(LibraryInterface libraryInterface) {
        name = getOptionName();
        this.libraryInterface = libraryInterface;
    }

    @Override
    public void execute() {
        libraryInterface.listBorrowedBooks();

    }

    @Override
    protected String getOptionName() {
        return "List Borrowed Books";
    }
}
