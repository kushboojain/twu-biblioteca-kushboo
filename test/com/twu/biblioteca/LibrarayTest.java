package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by khusbooj on 13/01/15.
 */

public class LibrarayTest {
    private ArrayList<Item> books = new ArrayList<Item>();
    private ArrayList<Item> movies = new ArrayList<Item>();
    Library biblioteca = new Library(books);
    private ArrayList<ArrayList<String>> actualDetails = new ArrayList<ArrayList<String>>();

    @Test
    public void shouldCheckAvailableBooksDetails()  {
        ArrayList<ArrayList<String>> expectedDetails = biblioteca.getAvailableItemDetails();
        for (int i = 0, detailsSize = actualDetails.size(); i < detailsSize; i++) {
            ArrayList<String> actualDetail = actualDetails.get(i);
            ArrayList<String> expectedDetail = expectedDetails.get(i);
            for (int j = 0, detailSize = actualDetail.size(); j < detailSize; j++) {
                Assert.assertEquals(actualDetail.get(j), expectedDetail.get(j));
            }
        }
    }
    @Test
    public void shouldCheckValidBookNameForCheckout()  {
        assertNotNull(biblioteca.getItemForCheckout("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckInvalidBookNameForCheckout()  {
        assertNull(biblioteca.getItemForCheckout("Harry Potter"));
    }
    @Test
    public void shouldCheckValidCheckinOfBook()  {
        Book borrowedBook = (Book) books.get(0);
        biblioteca.checkoutItem(borrowedBook);
        biblioteca.checkinItem(borrowedBook);
        assertNotNull(biblioteca.getItemForCheckout(borrowedBook.getName()));
    }

    @Test
    public void shouldCheckValidCheckoutOfBook()  {
        Book borrowedBook = (Book) books.get(0);
        biblioteca.checkoutItem(borrowedBook);
        assertNull(biblioteca.getItemForCheckout(borrowedBook.getName()));
    }


}
