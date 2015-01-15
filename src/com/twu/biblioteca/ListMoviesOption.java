package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class ListMoviesOption extends Option {
    private LibrarianInterface librarianInterface;

    public ListMoviesOption(LibrarianInterface librarianInterface) {
        this.librarianInterface = librarianInterface;
        name = setOptionName();
    }

    @Override
    public void performedAction() {
            librarianInterface.listMoviesDetails();
    }

    @Override
    protected String setOptionName() {
        return "ListMovies";
    }
}
