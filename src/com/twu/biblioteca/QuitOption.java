package com.twu.biblioteca;
/**
 * Created by khusbooj on 14/01/15.
 */
public class QuitOption extends Option {
    private MenuInterface menuInterface;

    @Override
    public void performedAction() {
        menuInterface.stopApp();
    }

    public QuitOption(MenuInterface menuInterface) {
        this.menuInterface = menuInterface;
        this.name = setOptionName();
    }

    @Override
    protected String setOptionName() {
        return "Quit";
    }


}
