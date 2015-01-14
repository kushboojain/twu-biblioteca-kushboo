package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

/**
 * Created by khusbooj on 14/01/15.
 */
public class UserInterface {
    Scanner input;
    PrintStream output = new PrintStream(System.out);
    public UserInterface() {
        input = new Scanner(System.in);
    }

    public void print(String content) {
        output.print(content);
    }

    public String readUserInput()  {
        return input.nextLine();
    }
}
