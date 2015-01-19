package com.twu.biblioteca;

/**
 * Created by khusbooj on 19/01/15.
 */
public class RentalDetailInterface {
    private String itemName;
    private String userNumber;

    public RentalDetailInterface(String itemName, String userNumber) {
        this.itemName = itemName;
        this.userNumber = userNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public String getUserNumber() {
        return userNumber;
    }
}
