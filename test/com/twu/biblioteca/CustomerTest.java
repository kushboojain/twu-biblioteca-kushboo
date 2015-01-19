package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CustomerTest {
    Customer customer = new Customer("123-4567", "xyz", "Kushboo","kush@gm.com", "23463");

    @Test
    public void shouldCheckCustomerName() {
        assertEquals(customer.getName(),"Kushboo");
    }
    @Test
    public void shouldCheckCustomerEmailId() {
        assertEquals(customer.getEmail(),"kush@gm.com");
    }
    @Test
     public void shouldCheckCustomerPhNo() {
        assertEquals(customer.getPhno(),"23463");
    }
    @Test
    public void shouldCheckValidPassword() {
        assertTrue(customer.checkValidPassword("xyz"));
    }
    @Test
    public void shouldCheckInvalidPassword() {
        assertFalse(customer.checkValidPassword("frve"));
    }

}
