package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        displayWelcomeMessage();
    }

    public static void displayWelcomeMessage() {
        System.out.print("Hey...Welcome to Biblioteca");
    }

    public static void listOfBooks() throws IOException {
        FileReader fileReader = new FileReader(new File("twu-biblioteca-kushboo/src/com/twu/biblioteca/Books"));
        String bookName;
        BufferedReader brFile = new BufferedReader(fileReader);
        while((bookName = brFile.readLine()) != null) {
            System.out.println(bookName);

        }
    }
}
