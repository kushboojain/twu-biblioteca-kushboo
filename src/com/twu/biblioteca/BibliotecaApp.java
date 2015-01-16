package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

public class BibliotecaApp {

    private  ArrayList<Item> books;
    UserInterface userInterface = new UserInterface();
    private ArrayList<Item> movies;
    protected LibrarianInterface librarianInterface;
    MenuInterface menuInterface;
    boolean stop = false;
    ArrayList<CustomerDetails> customers = new ArrayList<CustomerDetails>();
    public static void main(String[] args) throws IOException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.setInterfaces();
        bibliotecaApp.setCustomerDetails();
        bibliotecaApp.launch();
    }

    private void setCustomerDetails() {
        customers.add(new CustomerDetails("123-4567", "qwerty", "Henry", "hj@gm.com", "21367"));
        customers.add(new CustomerDetails("234-8679", "xyz", "Rohit", "rf@yh.com", "346789"));
    }

    void setInterfaces() throws IOException {
         initializeBooks();
         initializeMovies();
         librarianInterface = new LibrarianInterface(new Library(books), new Library(movies), userInterface);
         menuInterface = new MenuInterface(librarianInterface, userInterface, customers, this);
    }

    private void launch() throws IOException {
        userInterface.displayWelcomeMessage();
        String optionFromUser;
        do {
            userInterface.displayMenu(menuInterface.getOptionsList());
            optionFromUser = userInterface.readUserInputForProcessing();
            if(menuInterface.isInvalidOption(optionFromUser)) {
                userInterface.printInvalidOption();
                continue;
            }
            menuInterface.selectMenuOption(optionFromUser);
        } while (!stop);
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

    public void setStopStatus(boolean stopStatus) {
        this.stop = stopStatus;
    }
}
