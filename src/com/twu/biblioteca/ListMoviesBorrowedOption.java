package com.twu.biblioteca;


/**
 * Created by khusbooj on 16/01/15.
 */
public class ListMoviesBorrowedOption extends Option{
    private LibrarianInterface librarianInterface;

    public ListMoviesBorrowedOption(LibrarianInterface librarianInterface) {
        this.librarianInterface = librarianInterface;
        name = setOptionName();
    }

    @Override
    public void performedAction() {
        librarianInterface.listBorrowedMovies();
    }

    @Override
    protected String setOptionName() {
        return "List Borrowed Movies";
    }
}
