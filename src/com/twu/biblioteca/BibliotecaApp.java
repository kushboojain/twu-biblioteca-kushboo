package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

public class BibliotecaApp {

    private  ArrayList<Item> books;
    UserInterface userInterface = new UserInterface();
    private ArrayList<Item> movies;
    protected LibrarianInterface librarianInterface;
    private  Option[] availableOptions;
    public static void main(String[] args) throws IOException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.setInterfaces();
        bibliotecaApp.launch();

    }

     void setInterfaces() throws IOException {
         initializeBooks();
         initializeMovies();
         availableOptions = new Option[]{new ListBooksOption(librarianInterface), new ListMoviesOption(librarianInterface), new CheckoutBookOption(librarianInterface), new ReturnBookOption(librarianInterface), new CheckoutMovieOption(librarianInterface), new ReturnMovieOption(librarianInterface), new QuitOption()};
         librarianInterface = new LibrarianInterface(new Library(books), new Library(movies),userInterface);

    }

    private void launch() throws IOException {
        userInterface.displayWelcomeMessage();
        String optionFromUser;
        do {
            userInterface.displayMenu(getOptionsList());
            optionFromUser = userInterface.readUserInputForProcessing();
            if(isInvalidOption(optionFromUser)) {
                userInterface.print("Select a valid option!\n");
                continue;
            }
            selectMenuOption(optionFromUser);
        } while (!optionFromUser.equals("Quit"));
    }

    private ArrayList<String> getOptionsList() {
        ArrayList<String> option = new ArrayList<String>();
        for (Option availableOption : availableOptions) {
            option.add(availableOption.getOptionName());
        }

        return option;
    }

    private void selectMenuOption(String optionFromUser) {
        for (Option availableOption : availableOptions) {
            if(availableOption.getOptionName().equals(optionFromUser)){
                availableOption.performedAction();
                break;
            }
        }
    }

    public  void initializeBooks() throws IOException {
        books = new ArrayList<Item>();
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
        String bookDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookDetails = brFile.readLine()) != null) {
            String attributes[] = bookDetails.split(",");
            books.add(new Book(attributes[0], attributes[1], attributes[2]));
        }
    }

    public boolean isInvalidOption(String option) {
        for (Option availableOption : availableOptions) {
            if(availableOption.getOptionName().equals(option)){
                return false;
            }
        }
        return true;
    }

    public void initializeMovies() throws IOException {
        movies = new ArrayList<Item>();
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Movies"));
        String movieDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((movieDetails = brFile.readLine()) != null) {
            String attributes[] = movieDetails.split(",");
            movies.add(new Movie(attributes[0], attributes[1], attributes[2], attributes[3]));
        }
    }
}
