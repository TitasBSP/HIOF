package com.example;
import java.time.LocalDate;
import java.util.ArrayList;

public class Episode extends Production {
    private int episodeNumber;
    private int seasonNumber;
    private LocalDate releaseDateOfEpisode;

    public int getEpisodeNumber() {return episodeNumber;}
    public int getSeasonNumber() {return seasonNumber;}   

    public void setEpisodeNumber(int episodeNumber) {this.episodeNumber = episodeNumber;}
    public void setSeasonNumber(int seasonNumber) {this.seasonNumber = seasonNumber;}

    @Override
    public String toString() {
        return "////////////////////////////////////////////////////////////////" +
                "\nEpisode Title: " + super.getTitle()
                + "\nEpisode Number: " + episodeNumber
                + "\nSeason Number: " + seasonNumber
                + "\nRuntime: " + super.getRuntimeInMinutes()
                + "\nDescription: " + super.getDescription()
                + "\nRelease Date: " + releaseDateOfEpisode
                + "\n\nDirector: " + super.getDirector()
                + "\n////////////////////////////////////////////////////////////////\n" ;
    }
    
    public Episode(String title, int episodeNumber, int seasonNumber, int runtime, String description, LocalDate releaseDateOfSeries, LocalDate releaseDateOfEpisode, Person director, ArrayList<Role> roles) {
        super(title, description, runtime, releaseDateOfSeries, director, roles); // Note: Call super first in the constructor, in one line with all variables together
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.releaseDateOfEpisode = releaseDateOfEpisode;
    }

    public Episode(String title, int episodeNumber, int seasonNumber) {
        super(title);
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }
}

