package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class ReturnMovieOption extends Option {
    LibraryInterface libraryInterfaceInterface;


    public ReturnMovieOption(LibraryInterface libraryInterfaceInterface) {
        name = getOptionName();
        this.libraryInterfaceInterface = libraryInterfaceInterface;
    }
    @Override
    public void execute() {
        libraryInterfaceInterface.performCheckinOfMovie();
    }


    @Override
    protected String getOptionName() {
        return "Return Movie";

    }
}
