package com.twu.biblioteca;

/**
 * Created by khusbooj on 19/01/15.
 */
public class RentalRecord {
    private String itemName;
    private String userNumber;

    public RentalRecord(String itemName, String userNumber) {
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
