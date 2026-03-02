package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TVSeriesJSONRepository implements TVSeriesRepository {
    private final File thisFile;
    private final ObjectMapper objectMapper;

    public TVSeriesJSONRepository(File f) { // ObjectMapper is a little heavier on our system, therefore it's better to define it in the constructor.
        this.thisFile = f; 
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty formatting
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Based on Prog 2 AI, added dates separated by dashes instead of commas
    }   

    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) { // Sources and help: https://www.baeldung.com/jackson-object-mapper-tutorial
        try { // Unlike the previous task, we don't need separate try-blocks because objectmapper both creates AND writes to a program :D
            objectMapper.writeValue(thisFile, listOfTVSeries);
            System.out.println("Successfully added " + listOfTVSeries.size() + " series!");
        } catch (IOException e) {;
            System.out.println("ugh.");
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<TVSeries> getAllTVSeries() {
        try {
            ArrayList<TVSeries> series = objectMapper.readValue(thisFile, new TypeReference<ArrayList<TVSeries>>() {});
            return series;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>(); 
        }
    }

    @Override   
    public TVSeries getTVSeriesByTitle(String title) { // We grab the values from the previous method and search for a matching title.
        ArrayList<TVSeries> shows = getAllTVSeries();

        for (TVSeries series : shows) {
            if (series.getTitle().equalsIgnoreCase(title)) {
                return series;
            }
        }
        return null;
    }
}
