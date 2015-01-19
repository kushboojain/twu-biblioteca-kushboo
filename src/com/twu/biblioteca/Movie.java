package com.twu.biblioteca;

/**
 * Created by khusbooj on 15/01/15.
 */
public class Movie extends Item {
    String year;
    String rating;
    String directorName;

    public Movie(String movieName, String directorName, String year, String rating) {

        this.name = movieName;
        this.directorName = directorName;
        this.year = year;
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public String getDirectorName() {
        return directorName;
    }
}
