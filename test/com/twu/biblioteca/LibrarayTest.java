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
import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 13/01/15.
 */

public class LibrarayTest {
    private ArrayList<Book> books = new ArrayList<Book>();
    Library biblioteca = new Library(books);
    private ArrayList<ArrayList<String>> actualDetails = new ArrayList<ArrayList<String>>();

    @Before
    public void initializeBooks() throws IOException {
            FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
            String bookDetails;
            BufferedReader brFile = new BufferedReader(fileReader);
            while((bookDetails = brFile.readLine()) != null) {
                String attributes[] = bookDetails.split(",");
                books.add(new Book(attributes[0], attributes[1], attributes[2]));
                ArrayList<String> detail = new ArrayList<String>();
                detail.add(attributes[0]);
                detail.add(attributes[1]);
                detail.add(attributes[2]);
                actualDetails.add(detail);
            }
    }


    @Test
    public void shouldCheckAvailableBooksDetails()  {
        ArrayList<ArrayList<String>> expectedDetails = biblioteca.getAvailableBooksDetails();
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
        assertNotNull(biblioteca.getBookForCheckout("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckInvalidBookNameForCheckout()  {
        assertNull(biblioteca.getBookForCheckout("Harry Potter"));
    }
    @Test
    public void shouldCheckValidCheckinOfBook()  {
        Book borrowedBook = books.get(0);
        biblioteca.checkoutBook(borrowedBook);
        biblioteca.checkinBook(borrowedBook);
        assertNotNull(biblioteca.getBookForCheckout(borrowedBook.getBookName()));
    }

    @Test
    public void shouldCheckValidCheckoutOfBook()  {
        Book borrowedBook = books.get(0);
        biblioteca.checkoutBook(borrowedBook);
        assertNull(biblioteca.getBookForCheckout(borrowedBook.getBookName()));
    }


}
