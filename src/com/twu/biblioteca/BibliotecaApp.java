package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

public class BibliotecaApp {

    private static ArrayList<String> availableOptions= new ArrayList<String>();

    public static void setAvailableOptions() {
        availableOptions.add("ListBooks");
        availableOptions.add("Quit");
    }

    public static void main(String[] args) throws IOException {
        displayWelcomeMessage();
        options();
        String optionFromUser = getOptionFromUser();
        checkInvalidOption(optionFromUser);
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
        setAvailableOptions();
        System.out.println("Choose from below:");
        for (String availableOption : availableOptions) {
            System.out.println(availableOption);
        }

    }

    public static void checkInvalidOption(String option) {
        if(!availableOptions.contains(option)) {
            System.out.print("Select a valid option!");
        }

    }


}
