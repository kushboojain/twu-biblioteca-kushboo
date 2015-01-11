package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    private  String[] availableOptions = {"ListBooks","Checkout Book", "Return Book", "Quit"};
    private  ArrayList<bibliotecaBook> books = new ArrayList<bibliotecaBook>();

    public BibliotecaApp() throws IOException {
        booksAtBiblioteca();
    }

    public  void main(String[] args) throws IOException {

        displayWelcomeMessage();
        while(true) {
            options();
            String optionFromUser = getOptionFromUser();
            if(checkInvalidOption(optionFromUser)) {
                continue;
            }
            if (optionFromUser.equals("ListBooks")) {
                booksDetails();
            } else if (optionFromUser.equals("Checkout Book")) {
                System.out.println("Enter the book name you would like to borrow:");
                checkOutBook(readUserInput());
            } else if (optionFromUser.equals("Return Book")) {
                System.out.println("Enter the name of the book you are returning:");
                checkInBook(readUserInput());
            } else if (optionFromUser.equals("Quit")) {
                System.exit(1);
            }
        }
    }

    private String readUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    private  String getOptionFromUser() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        return input.readLine();
    }


    public  void displayWelcomeMessage() {
        System.out.println("Hey...Welcome to Biblioteca");
    }

    public  void booksDetails()  {
        for (bibliotecaBook book : books) {
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
            books.add(new bibliotecaBook(attributes[0], attributes[1], attributes[2]));
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
        for(bibliotecaBook book: books){
            if(book.getBookName().equals(selectedBook)) {
                book.setBorrowed(true);
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available";
    }

    public String checkInBook(String bookName) {
        for (bibliotecaBook book : books) {
            if(book.getBookName().equals(bookName)) {
                book.setBorrowed(false);
                return "Thank you for returning the book";
            }
        }
        return "That is not a valid book to return";
    }
}
