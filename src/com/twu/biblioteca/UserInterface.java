package com.twu.biblioteca;

import java.io.*;
import java.util.*;

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
        print("Welcome to Biblioteca\n");
    }

    public void displayMenu(ArrayList<Option> options) {
        print("\nChoose from a option below:\n");
        for (Option option : options) {
            print(option.getOptionName() + "\n");
        }

    }

    public void displayBookDetails(Book book) {
        print("Name: "+ book.getName() + "\t\t\t");
        print("Author: "+ book.getAuthor() + "\t\t\t");
        print("Year: " + book.getYear() + "\n");
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
    public void displaySignOutMessage() {
        print("Bye\n");
    }

    public void displaySignInStatus(boolean status) {
        if(status)
            print("Sucesfully Logged in\n");
        else
            print("Wrong credentials!\n");
    }

    public void displayCustomerDetails(Customer customerLoggedInDetails) {
        print("Your Details:\n");
        print("Name: " + customerLoggedInDetails.getName() + "\n");
        print("Email: " + customerLoggedInDetails.getEmail() + "\n");
        print("PhNo: " + customerLoggedInDetails.getPhno() + "\n");
    }

    public void displayBorrowedBooks(HashMap<String, String> borrowedBooks) {
        if(borrowedBooks.isEmpty()) {
            print("No books are borrowed");
        }else {
            print("The borrowed books are (with customer number):\n");
            Iterator it = borrowedBooks.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                print(pairs.getKey() + " : " + pairs.getValue());
                it.remove();
            }
        }
    }

    public void displayBorrowedMovies(HashMap<String, String> borrowedMovies) {
        if(borrowedMovies.isEmpty()) {
            print("No movies are borrowed");
        }else {
            print("The borrowed movies are (with customer number):\n");
            Iterator it = borrowedMovies.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                print(pairs.getKey() + " : " + pairs.getValue());
                it.remove();
            }
        }
    }

    public void displayMovieDetails(Movie availableMovieDetail) {
        print("Name: " + availableMovieDetail.getName() + "\t\t\t");
        print("Director: " + availableMovieDetail.getDirectorName() + "\t\t\t");
        print("Year: " + availableMovieDetail.getYear() + "\t\t\t");
        print("Rating: " + availableMovieDetail.getRating() + "\n");
    }
}
