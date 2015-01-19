package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

public class BibliotecaApp {

    private  ArrayList<Item> books;
    UserInterface userInterface = new UserInterface();
    private ArrayList<Item> movies;
    protected LibraryInterface libraryInterface;
    MenuInterface menuInterface;
    boolean stop = false;
    ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Option> availableOptions;

    public static void main(String[] args) throws IOException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initialize();
        bibliotecaApp.launch();
    }

    private void initializeCustomers() {
        customers.add(new Customer("123-4567", "qwerty", "Henry", "hj@gm.com", "21367"));
        customers.add(new Customer("234-8679", "xyz", "Rohit", "rf@yh.com", "346789"));
    }

    private void initialize() throws IOException {
         initializeBooks();
         initializeMovies();
         initializeCustomers();
         libraryInterface = new LibraryInterface(new Library(books), new Library(movies), userInterface);
         menuInterface = new MenuInterface(libraryInterface, userInterface, customers, this);
    }

    private void launch() throws IOException {
        userInterface.displayWelcomeMessage();
        String optionFromUser;
        do {
            optionFromUser = getOptionName();
            if(!selectMenuOption(optionFromUser)) {
                userInterface.printInvalidOption();
            }
        } while (!stop);
    }

    private String getOptionName() {
        String optionFromUser;
        availableOptions = menuInterface.getOptionsList();
        userInterface.displayMenu(availableOptions);
        optionFromUser = userInterface.readUserInputForProcessing();
        return optionFromUser;
    }

    boolean selectMenuOption(String optionFromUser) {
        for (Option availableOption : availableOptions) {
            if(availableOption.getOptionName().equals(optionFromUser)){
                availableOption.execute();
                return true;
            }
        }
        return false;
    }

    private  void initializeBooks() throws IOException {
        books = new ArrayList<Item>();
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Books"));
        String bookDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookDetails = brFile.readLine()) != null) {
            String attributes[] = bookDetails.split(",");
            books.add(new Book(attributes[0], attributes[1], attributes[2]));
        }
    }

    private void initializeMovies() throws IOException {
        movies = new ArrayList<Item>();
        FileReader fileReader = new FileReader(new File("src/com/twu/biblioteca/Movies"));
        String movieDetails;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((movieDetails = brFile.readLine()) != null) {
            String attributes[] = movieDetails.split(",");
            movies.add(new Movie(attributes[0], attributes[1], attributes[2], attributes[3]));
        }
    }

    public void setStopStatus(boolean stopStatus) {
        this.stop = stopStatus;
    }
}
