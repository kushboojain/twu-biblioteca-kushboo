package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    private  String[] availableOptions = {"ListBooks","Checkout Book", "Quit"};
    private  ArrayList<BibliotecaBook> books = new ArrayList<BibliotecaBook>();

    public BibliotecaApp() throws IOException {
        booksAtBiblioteca();
    }

    public  void main(String[] args) throws IOException {

        displayWelcomeMessage();
        booksAtBiblioteca();
        options();
        String optionFromUser = getOptionFromUser();
        for (BibliotecaBook book : books) {
            System.out.println(book.bookName);
        }

    }



    private  String getOptionFromUser() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        return input.readLine();
    }


    public  void displayWelcomeMessage() {
        System.out.println("Hey...Welcome to Biblioteca");
    }

    public  void booksDetails()  {
        for (BibliotecaBook book : books) {
            if(book.getStatus() == false)
                System.out.print(book.details());
        }


    }

    public  void booksAtBiblioteca() throws IOException {
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
        String bookDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookDetails = brFile.readLine()) != null) {
            String attributes[] = bookDetails.split(",");
            books.add(new BibliotecaBook(attributes[0], attributes[1], attributes[2]));
        }
    }


    public  void options() {
        System.out.println("Choose from below:");
        for (String availableOption : availableOptions) {
            System.out.println(availableOption);
        }

    }

    public  boolean checkInvalidOption(String option) {
        if (!(Arrays.asList(availableOptions).contains(option))) {
            System.out.print("Select a valid option!");
            return true;
        }
        else
            return false;
    }

    public  String checkOutBook(String selectedBook) {
        for(BibliotecaBook book: books){
            if(book.bookName.equals(selectedBook)) {
                book.borrowed = true;
                return "Thank you! Enjoy the book";
            }
        }
        return null;
    }
}
