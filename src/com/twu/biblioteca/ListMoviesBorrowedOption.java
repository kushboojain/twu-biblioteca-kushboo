package com.twu.biblioteca;


/**
 * Created by khusbooj on 16/01/15.
 */
public class ListMoviesBorrowedOption extends Option{
    private LibraryInterface libraryInterface;

    public ListMoviesBorrowedOption(LibraryInterface libraryInterface) {
        this.libraryInterface = libraryInterface;
        name = getOptionName();
    }

    @Override
    public void execute() {
        libraryInterface.listBorrowedMovies();
    }

    @Override
    protected String getOptionName() {
        return "List Borrowed Movies";
    }
}
