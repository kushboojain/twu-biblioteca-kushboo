package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class ListMoviesOption extends Option {
    private LibraryInterface libraryInterface;

    public ListMoviesOption(LibraryInterface libraryInterface) {
        this.libraryInterface = libraryInterface;
        name = getOptionName();
    }

    @Override
    public void execute() {
            libraryInterface.listMoviesDetails();
    }

    @Override
    protected String getOptionName() {
        return "ListMovies";
    }
}
