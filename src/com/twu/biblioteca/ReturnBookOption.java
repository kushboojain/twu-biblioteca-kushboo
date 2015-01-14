package com.twu.biblioteca;

/**
 * Created by khusbooj on 14/01/15.
 */
public class ReturnBookOption extends Option {
    Librarian manager;
    private UserInterface userInterface;

    @Override
    public void performedAction() {
        userInterface.print("Enter the name of the book to return:\n");
        userInterface.print(manager.performCheckin(userInterface.readUserInput()));
    }

    public ReturnBookOption(Librarian manager, UserInterface userInterface) {
        this.userInterface = userInterface;
        name = setOptionName();
        this.manager = manager;
    }

    @Override
    protected String setOptionName() {
        return "Return Book";

    }
}
