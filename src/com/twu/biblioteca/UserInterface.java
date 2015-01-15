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

    public String getBookNameFromUser() {
        print("Enter the name of the book: ");
        return readUserInputForProcessing();
    }
    public String getMovieNameFromUser() {
        print("Enter the name of the movie: ");
        return readUserInputForProcessing();
    }

    public void displayMessageOnCheckoutOfMovie(boolean status) {
        if(status)
            print("Thank You! Enjoy the movie\n");
        else
            print("That movie is not available\n");
    }

    public void displayMessageOnCheckinOfMovie(boolean status) {
        if(status)
            print("Thank you for returning the movie\n");
        else
            print("That movie is not valid\n");

    }

    public void displayMessageOnCheckoutOfBook(boolean status) {
        if(status)
            print("Thank You! Enjoy the book\n");
        else
            print("That book is not available\n");
    }

    public void displayMessageOnCheckinOfBook(boolean status) {
        if(status)
            print("Thank you for returning the book\n");
        else
            print("That movie is not book\n");

    }

    public void printInvalidOption() {
        print("Select a valid Option!\n");
    }

    public String signinNumber() {
        print("Enter your library number");
        return readUserInputForProcessing();
    }
    public String signinPassword() {
        print("Enter your password");
        return readUserInputForProcessing();
    }
    public void signOut() {
        print("Bye");
    }

    public void displaySignInStatus(boolean status) {
        if(status)
            print("Sucesfully Logged in");
        else
            print("Wrong credentials");
    }
}
