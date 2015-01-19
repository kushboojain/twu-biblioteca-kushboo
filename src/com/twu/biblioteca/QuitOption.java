package com.twu.biblioteca;
/**
 * Created by khusbooj on 14/01/15.
 */
public class QuitOption extends Option {
    private MenuInterface menuInterface;

    @Override
    public void execute() {
        menuInterface.stopApp();
    }

    public QuitOption(MenuInterface menuInterface) {
        this.menuInterface = menuInterface;
        this.name = getOptionName();
    }

    @Override
    protected String getOptionName() {
        return "Quit";
    }


}
