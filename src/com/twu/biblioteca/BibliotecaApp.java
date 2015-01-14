package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

public class BibliotecaApp {

    private  ArrayList<Book> books = new ArrayList<Book>();
    UserInterface userInterface = new UserInterface();
    protected LibrarianInterface librarianInterface = new LibrarianInterface(new Library(books), userInterface);
    private  Option[] availableOptions = {new ListBooksOption(librarianInterface, userInterface),new CheckoutBookOption(librarianInterface, userInterface), new ReturnBookOption(librarianInterface, userInterface), new QuitOption()};
    public static void main(String[] args) throws IOException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initializeBooksAtBiblioteca();
        bibliotecaApp.launch();

    }

    private void launch() throws IOException {
        displayWelcomeMessage();
        String optionFromUser;
        do {
            userInterface.print(optionsList());
            optionFromUser = userInterface.readUserInput();
            if(isInvalidOption(optionFromUser)) {
                userInterface.print("Select a valid option!\n");
                continue;
            }
            selectMenuOption(optionFromUser);

            userInterface.print("\n");
        } while (!optionFromUser.equals("Quit"));
    }

    private void selectMenuOption(String optionFromUser) {
        for (Option availableOption : availableOptions) {
            if(availableOption.getOptionName().equals(optionFromUser)){
                availableOption.performedAction();
                break;
            }
        }
    }


    public  void initializeBooksAtBiblioteca() throws IOException {
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
        String bookDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookDetails = brFile.readLine()) != null) {
            String attributes[] = bookDetails.split(",");
            books.add(new Book(attributes[0], attributes[1], attributes[2]));
        }
    }

    public  String optionsList() {
        String optionsContent = "Choose from below:\n";
        for (Option availableOption : availableOptions) {
            optionsContent+= availableOption.getOptionName() + "\n";
        }
        return optionsContent;
    }


    public boolean isInvalidOption(String option) {
        for (Option availableOption : availableOptions) {
            if(availableOption.getOptionName().equals(option)){
                return false;
            }
        }
        return true;
    }

    public void displayWelcomeMessage() {
        userInterface.print("Welcome to Biblioteca");
    }
}
