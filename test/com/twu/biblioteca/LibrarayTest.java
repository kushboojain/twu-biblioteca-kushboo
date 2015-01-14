package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
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
    public void shouldCheckListOfBooks()  {
        assertEquals(new Library(books).getAvailableBooksDetails(), "Terms & Conditions\t\tRobert Glancy\t\t2014\n" +
                "Sherlock Holmes\t\tSir Author Connon Doyle\t\t1887\n" +
                "Diary of Wimpy Kid\t\tJeff Kinney\t\t2007\n");
    }
    @Test
    public void shouldCheckValidBookNameForCheckout()  {
        assertNotNull(new Library(books).getBookForCheckout("Sherlock Holmes"));
    }
    @Test
    public void shouldCheckInvalidBookNameForCheckout()  {
        assertNull(new Library(books).getBookForCheckout("Harry Potter"));
    }
    @Test
    public void shouldCheckValidCheckinOfBook()  {
        Library biblioteca = new Library(books);
        Book borrowedBook = books.get(0);
        biblioteca.checkoutBook(borrowedBook);
        biblioteca.checkinBook(borrowedBook);
        assertEquals(biblioteca.getAvailableBooksDetails(), "Sherlock Holmes\t\tSir Author Connon Doyle\t\t1887\n" +
                "Diary of Wimpy Kid\t\tJeff Kinney\t\t2007\n" +
                "Terms & Conditions\t\tRobert Glancy\t\t2014\n");
    }

    @Test
    public void shouldCheckValidCheckoutOfBook()  {
        Library biblioteca = new Library(books);
        biblioteca.checkoutBook(books.get(0));
        assertEquals(biblioteca.getAvailableBooksDetails(), "Sherlock Holmes\t\tSir Author Connon Doyle\t\t1887\n" +
                "Diary of Wimpy Kid\t\tJeff Kinney\t\t2007\n");
    }


}
