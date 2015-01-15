package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by khusbooj on 13/01/15.
 */

public class LibrarayTest {
    private ArrayList<Item> books = new ArrayList<Item>();
    Library biblioteca;
    private ArrayList<ArrayList<String>> actualDetails = new ArrayList<ArrayList<String>>();
    @Before
    public void initializeBooks() throws IOException {
        books = new ArrayList<Item>();
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
        String bookDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookDetails = brFile.readLine()) != null) {
            String attributes[] = bookDetails.split(",");
            books.add(new Book(attributes[0], attributes[1], attributes[2]));
        }
        biblioteca = new Library(books);
    }


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
