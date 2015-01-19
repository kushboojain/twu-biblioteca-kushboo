package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class ListBooksOption extends Option {
    private LibraryInterface libraryInterface;

    @Override
    public void execute() {
        libraryInterface.listBooksDetails();
    }

    public ListBooksOption(LibraryInterface libraryInterfaceInterface) {
        this.libraryInterface = libraryInterfaceInterface;
        name = getOptionName();
    }

    @Override
    protected String getOptionName() {
        return "ListBooks";
    }
}
