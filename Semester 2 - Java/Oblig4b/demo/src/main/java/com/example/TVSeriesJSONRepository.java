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

    public TVSeriesJSONRepository(File f) {
        this.thisFile = f; 
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }   

    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) { // Sources and help: https://www.baeldung.com/jackson-object-mapper-tutorial
        try {
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
            return new ArrayList<>(); // Returner tom liste ved feil
        }
    }

    @Override   
    public TVSeries getTVSeriesByTitle(String title) {
        ArrayList<TVSeries> shows = getAllTVSeries();

        for (TVSeries series : shows) {
            if (series.getTitle().equalsIgnoreCase(title)) {
                return series;
            }
        }
        return null;
    }
}
