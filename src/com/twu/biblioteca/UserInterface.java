package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
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

    public String readUserInputForProcessing()  {
        return input.nextLine();
    }

    public void displayWelcomeMessage() {
        print("Welcome to Biblioteca");
    }

    public void displayMenu(ArrayList<String> options) {
        print("Choose from a option below:\n");
        for (String option : options) {
            print(option + "\n");
        }

    }

    public void displayBookDetails(ArrayList<ArrayList<String>> detailsOfBooks) {
        for (ArrayList<String> detail : detailsOfBooks) {
            for (String bookParameter : detail) {
                print(bookParameter + "\t\t");
            }
            print("\n");
        }
    }
}
