import java.io.File;
import java.io.IOException; 
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.time.LocalDate;

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

        try (FileWriter fileManager = new FileWriter(theFile, true);){ // TRY-Block for writing contents of the TVSeries list. We choose to separate them for the sake of readability and knowing which block catches an exception.
            for (TVSeries series : listOfTVSeries) {
                String details = 
                                   series.getTitle() + separator
                                +  series.getDescription() + separator
                                +  series.getReleaseDate().getYear() + separator + series.getReleaseDate().getMonthValue() + separator + series.getReleaseDate().getDayOfMonth() + separator;
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

            while ((line = buffRead.readLine()) != null) {
                String[] values = line.split(separator);
                
                String title = values[0];
                String description = values[1];
                int relYear = Integer.parseInt(values[2]);
                int relMonth = Integer.parseInt(values[3]);
                int relDay = Integer.parseInt(values[4]);

                TVSeries series = new TVSeries(title, description, LocalDate.of(relYear, relMonth, relDay), null, 0);
                objects.add(series);
                
            }

        } catch (Exception e) {
            System.err.println("Something went wrong when reading from file.");
        }

        return objects;
    }

    /*
    Todo:

    In method:
    - Grabs .csv file and read with bufferedreader
    - Return list of TVSeries objects

    In main:
    - Use the method on the file we made in the last task
    - Print a description of the object to show that the method works
    */

    @Override
    public TVSeries getTVSeriesByTitle(String title) {
        
        ArrayList<TVSeries> objects = getAllTVSeries();
        for (TVSeries series : objects) {
            if (series.getTitle().equalsIgnoreCase(title)) {
                return series;
            }
        }
        return null;
    }

}

/* For next time, create a list of tvseries, see if the methods work or not. Troubleshoot if so! */
