package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by khusbooj on 14/01/15.
 */
public class QuitOptionTest {
    @Test
    public void shouldCheckQuitOptionName() {
        assertEquals(new QuitOption().getOptionName(), "Quit");
    }
}
