package com.twu.biblioteca;

/**
 * Created by khusbooj on 14/01/15.
 */
public class ReturnBookOption extends Option {
    LibraryInterface libraryInterfaceInterface;


    public ReturnBookOption(LibraryInterface libraryInterfaceInterface) {
        name = getOptionName();
        this.libraryInterfaceInterface = libraryInterfaceInterface;
    }
    @Override
    public void execute() {
        libraryInterfaceInterface.performCheckinOfBook();
    }


    @Override
    protected String getOptionName() {
        return "Return Book";

    }
}
