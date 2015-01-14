package com.twu.biblioteca;
/**
 * Created by khusbooj on 14/01/15.
 */
public class QuitOption extends Option {
    @Override
    public void performedAction() {
        return;
    }

    public QuitOption() {
        this.name = setOptionName();
    }

    @Override
    protected String setOptionName() {
        return "Quit";
    }


}
