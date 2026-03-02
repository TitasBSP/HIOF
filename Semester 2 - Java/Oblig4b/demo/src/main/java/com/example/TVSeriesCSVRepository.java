package com.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TVSeriesCSVRepository implements TVSeriesRepository {
    private final File theFile;
    String separator = ";";

    public TVSeriesCSVRepository(File f) {this.theFile = f;}

    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) { // Sources and help: https://www.geeksforgeeks.org/java/file-handling-in-java/

        theFile.delete();

        try { // TRY-Block for creating the actual file
            if (theFile.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error while creating the file.");
            e.printStackTrace();
        }

        /* TRY-Block for writing contents of the TVSeries list. 
            We choose to separate them for the sake of readability and knowing which block catches an exception. */

        try (FileWriter fileManager = new FileWriter(theFile, true);){ 
            for (TVSeries series : listOfTVSeries) {
                String details = series.getTitle() + separator + series.getDescription() + separator + series.getReleaseDate().getYear() + separator + series.getReleaseDate().getMonthValue() + separator + series.getReleaseDate().getDayOfMonth() + separator;
                fileManager.write(details + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error while writing to file.");
            e.printStackTrace(); 
        }
    }

    @Override
    public ArrayList<TVSeries> getAllTVSeries() { // Sources and help: https://www.baeldung.com/java-csv-file-array
        ArrayList<TVSeries> objects = new ArrayList<>();

        try (BufferedReader buffRead = new BufferedReader(new FileReader(theFile))) {
            String line;

            while ((line = buffRead.readLine()) != null) { // Kjører helt til det ikke er rader med tegn
                String[] values = line.split(separator); // Lagrer de forskjellige verdiene basert på hvor de ligger i arrayen.
                
                String title = values[0];
                String description = values[1];
                int relYear = Integer.parseInt(values[2]);
                int relMonth = Integer.parseInt(values[3]);
                int relDay = Integer.parseInt(values[4]);

                // Vi bruker variablene vi nettopp opprettet for å putte sammen objektet.
                TVSeries series = new TVSeries(title, description, LocalDate.of(relYear, relMonth, relDay), null, 0); 
                objects.add(series);
                
            }

        } catch (Exception e) {
            System.err.println("Something went wrong when reading from file.");
            e.printStackTrace(); 
        }
        return objects;
    }

    @Override
    public TVSeries getTVSeriesByTitle(String title) { // Grab the data from previous method, loop and search through it.
        
        ArrayList<TVSeries> objects = getAllTVSeries();
        for (TVSeries series : objects) {
            if (series.getTitle().equalsIgnoreCase(title)) {
                return series;
            }
        }

        return null;
    }

}

