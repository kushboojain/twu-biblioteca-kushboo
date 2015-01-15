package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CustomerDetailsTest {
    @Test
    public void shouldCheckLibraryNumberLength() {
        assertEquals(new CustomerDetails("123-4567").getLibraryNumber().length(), 8);
    }
    
    @Test
    public void shouldCheckLibraryNumberFormat() {

    }
}
