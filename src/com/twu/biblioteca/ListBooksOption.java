package com.twu.biblioteca;

/**
 * Created by khusbooj on 13/01/15.
 */
public class ListBooksOption extends Option {
    private Librarian manager;
    private UserInterface userInterface;

    @Override
    public void performedAction() {
        userInterface.print(manager.listBooksDetails());
    }

    public ListBooksOption(Librarian manager, UserInterface userInterface) {
        this.manager = manager;
        this.userInterface = userInterface;
        name = setOptionName();
    }

    @Override
    protected String setOptionName() {
        return "ListBooks";
    }
}
