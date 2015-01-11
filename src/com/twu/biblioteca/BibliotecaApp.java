package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    private static String[] availableOptions = {"ListBooks","Quit"};


    public static void main(String[] args) throws IOException {

        displayWelcomeMessage();
        options();
        String optionFromUser = getOptionFromUser();
        System.out.print(checkInvalidOption(optionFromUser));
    }



    private static String getOptionFromUser() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        return input.readLine();
    }


    public static void displayWelcomeMessage() {
        System.out.println("Hey...Welcome to Biblioteca");
    }

    public static void booksDetails() throws IOException {
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
        String bookName;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookName = brFile.readLine()) != null) {
            System.out.println(bookName);
        }
    }

    public static void options() {
        System.out.println("Choose from below:");
        for (String availableOption : availableOptions) {
            System.out.println(availableOption);
        }

    }

    public static boolean checkInvalidOption(String option) {
        if (!(Arrays.asList(availableOptions).contains(option))) {
            System.out.print("Select a valid option!");
            return true;
        }
        else
            return false;
    }

}
