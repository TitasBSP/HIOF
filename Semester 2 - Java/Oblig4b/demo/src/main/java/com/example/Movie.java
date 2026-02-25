package com.example;
import java.time.LocalDate;
import java.util.ArrayList;
public class Movie extends Production {

    @Override
    public String toString() {
        return "Movie info: " + super.toString();
    }
    
    public Movie(String title, String description, int runtimeInMinutes, LocalDate releaseDate, Person director, ArrayList<Role> roles) {
        super(title, description, runtimeInMinutes, releaseDate, director, roles);
    }
}
