package com.twu.biblioteca;

import java.util.*;

/**
 * Created by khusbooj on 13/01/15.
 */
public class Library {
    ArrayList<Item> availableItems = new ArrayList<Item>();
    ArrayList<Item> borrowedItems = new ArrayList<Item>();



    public ArrayList<ArrayList<String>> getAvailableItemDetails() {
        ArrayList<ArrayList<String>> detailsOfItems = new ArrayList<ArrayList<String>>();
        for (Item item : availableItems) {
            detailsOfItems.add(item.details());
        }

        return detailsOfItems;
    }

    public Library(ArrayList<Item> items)  {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            availableItems.add(item);
        }

    }

    public void checkoutItem(Item borrowedItem) {
            availableItems.remove(borrowedItem);
            borrowedItems.add(borrowedItem);
    }

    public void checkinItem(Item returnedItem) {
            borrowedItems.remove(returnedItem);
            availableItems.add(returnedItem);
    }

    public Item getItemForCheckout(String itemName) {
        for (Item availableItem : availableItems) {
            if(availableItem.getName().equals(itemName)) {
                return availableItem;
            }
        }
        return null;
    }

    public Item getItemForCheckin(String itemName) {
        for (Item borrowedItem : borrowedItems) {
            if(borrowedItem.getName().equals(itemName)) {
                return borrowedItem;
            }
        }
        return null;
    }
}
