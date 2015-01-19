package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by khusbooj on 15/01/15.
 */
public class CustomerTest {
    Customer customer = new Customer("123-4567", "xyz", "Kushboo","kush@gm.com", "23463");
    String[] details = {"Kushboo","kush@gm.com", "23463"};

    @Test
    public void shouldCheckCustomerDetails() {
        ArrayList<String> customerDetails = customer.getDetails();
        for (int i = 0; i < customerDetails.size(); i++) {
            String customerDetail = customerDetails.get(i);
            assertEquals(customerDetail, details[i]);
        }
    }

}
