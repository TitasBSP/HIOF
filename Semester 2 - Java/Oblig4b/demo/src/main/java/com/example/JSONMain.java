package com.example;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class JSONMain {
    public static void main(String[] args) {
        TVSeriesJSONRepository jsonRepo = new TVSeriesJSONRepository(new File("tvseries.json"));

        ArrayList<TVSeries> listTV = new ArrayList<>();

            // Stranger Things
            TVSeries strangerThings = new TVSeries(
                    "Stranger Things", 
                    "A group of kids uncover supernatural mysteries in their small town.",
                    LocalDate.of(2016, 7, 15),
                    new ArrayList<>(),
                    4
            );

            // Game of Thrones
            TVSeries gameOfThrones = new TVSeries(
                    "Game of Thrones",
                    "Nine noble families fight for control over the lands of Westeros.",
                    LocalDate.of(2011, 4, 17),
                    new ArrayList<>(),
                    8
            );

            // The Office (US)
            TVSeries theOffice = new TVSeries(
                    "The Office",
                    "A mockumentary on a group of typical office workers.",
                    LocalDate.of(2005, 3, 24),
                    new ArrayList<>(),
                    9
            );

            // The Mandalorian
            TVSeries theMandalorian = new TVSeries(
                    "The Mandalorian",
                    "A lone bounty hunter travels the outer reaches of the galaxy.",
                    LocalDate.of(2019, 11, 12),
                    new ArrayList<>(),
                    3
            );

            listTV.add(strangerThings);
            listTV.add(gameOfThrones);
            listTV.add(theOffice);
            listTV.add(theMandalorian);

            jsonRepo.addListOfTVSeries(listTV);
            ArrayList<TVSeries> readSeries = jsonRepo.getAllTVSeries();
            for (TVSeries series : readSeries) {
                System.out.println("Title: " + series.getTitle() + "\n" +
                                   "Description: " + series.getDescription() + "\n" +
                                   "Release Date: " + series.getReleaseDate() + "\n");
            }

            TVSeries chosenSeries = jsonRepo.getTVSeriesByTitle("The Mandalorian");
            System.out.println("Title: " + chosenSeries.getTitle() + "\n" +
                               "Description: " + chosenSeries.getDescription() + "\n" +
                               "Release Date: " + chosenSeries.getReleaseDate() + "\n");
        }
    }

