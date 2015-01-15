package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by khusbooj on 15/01/15.
 */
public class Movie extends Item {
    String year;
    String rating;
    String director;

    public Movie(String movieName, String director, String year, String rating) {

        this.name = movieName;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }


    @Override
    public ArrayList<String> details() {
        ArrayList<String> detail = new ArrayList<String>();
        detail.add(name);
        detail.add(director);
        detail.add(year);
        detail.add(rating);
        return detail;
    }
}
