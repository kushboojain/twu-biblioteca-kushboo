package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CustomerDetailsTest {
    CustomerDetails customer = new CustomerDetails("123-4567", "xyz", "Kushboo","kush@gm.com", "23463");
    String[] details = {"Kushboo","kush@gm.com", "23463"};

    @Test
    public void shouldCheckLibraryNumberLength() {
        assertEquals(customer.getLibraryNumber().length(), 8);
    }
    @Test
    public void shouldCheckNotNullPassword() {
        assertNotNull(customer.getPassword());
    }
    @Test
    public void shouldCheckCustomerDetails() {
        ArrayList<String> customerDetails = customer.getDetails();
        for (int i = 0; i < customerDetails.size(); i++) {
            String customerDetail = customerDetails.get(i);
            assertEquals(customerDetail, details[i]);
        }}
}
