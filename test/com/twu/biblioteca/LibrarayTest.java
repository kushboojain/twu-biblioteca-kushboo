package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by khusbooj on 13/01/15.
 */
public class LibrarayTest {
    private ArrayList<Book> books = new ArrayList<Book>();

    @Before
    public void initializeBooks() throws IOException {
            FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
            String bookDetails;
            BufferedReader brFile = new BufferedReader(fileReader);
            while((bookDetails = brFile.readLine()) != null) {
                String attributes[] = bookDetails.split(",");
                books.add(new Book(attributes[0], attributes[1], attributes[2]));
            }
    }

    @Test
    public void shouldCheckListOfBooks() throws IOException {
        assertEquals(new Library(books).getAvailableBooksDetails(), "Terms & Conditions\t\tRobert Glancy\t\t2014\n" +
                "Sherlock Holmes\t\tSir Author Connon Doyle\t\t1887\n" +
                "Diary of Wimpy Kid\t\tJeff Kinney\t\t2007\n");
    }
    @Test
    public void shouldCheckValidBookNameForCheckout() throws IOException {
        assertTrue(new Library(books).isValidBookNameForCheckout("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckInvalidBookNameForCheckout() throws IOException {
        assertFalse(new Library(books).isValidBookNameForCheckout("Harry Potter"));
    }
    @Test
    public void shouldCheckValidCheckin() throws IOException {
        Library biblioteca = new Library(books);
        String bookName = "Sherlock Holmes";
        biblioteca.checkoutBook(bookName);
        assertTrue(biblioteca.isValidBookNameForCheckin(bookName));
    }

    @Test
    public void shouldCheckInvalidCheckin() throws IOException {
        assertFalse(new Library(books).isValidBookNameForCheckin("Sherlock"));
    }

    @Test
    public void shouldCheckForValidCheckoutOfBook() throws IOException {
        assertTrue(new Library(books).checkoutBook("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckForValidCheckinOfBook() throws IOException {
        String bookName = "Terms & Conditions";
        Library biblioteca = new Library(books);
        biblioteca.checkoutBook(bookName);
        assertTrue(biblioteca.checkinBook(bookName));

    } @Test
    public void shouldCheckForInvalidCheckoutOfBook() throws IOException {
        assertFalse(new Library(books).checkoutBook("Sherlock"));
    }
    @Test
    public void shouldCheckForInvalidCheckinOfBook() throws IOException {
        assertFalse(new Library(books).checkinBook("Wall Street"));

    }

}
