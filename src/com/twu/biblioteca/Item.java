package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public abstract class Item {
    String name;

    public abstract ArrayList<String> details();


    public String getName() {
        return name;
    }
}
