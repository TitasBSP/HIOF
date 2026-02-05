import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class O3Main {
    public static void main(String[] args) {
        // 2.6
        /* Creates a random object, we define the min-max, 
        and use it in the for loop to random offset which lets us see the different averages calculated when we run the code.*/
        Random rand = new Random(); 
        int min = 20, max = 30; 

        TVSeries breakingBad = new TVSeries("Breaking Bad", "Walter White is cool", LocalDate.of(2008, 1, 20), new ArrayList<>(), 5);
        String[][] titles = { // Made a 2D array to store episode titles which are later used to add them to the TVSeries class with each Episode object.
            { "Pilot", "Cat's in the bag", "And the Bag's in the River", "Cancer Man", "Gray Matter", "Crazy Handful of Nothing", "A No-Rough-Stuff-Type Deal" }, // S1
            { "Seven Thirty-Seven", "Grilled", "Bit by a Dead Bee", "Down", "Breakage", "Peekaboo", "Negro y Azul", "Better Call Saul", "4 Days Out", "Over", "Mandala", "Phoenix", "ABQ" }, // S2
            { "No Mas", "Caballo sin Nombre", "I.F.T.", "Green Light", "Mas", "Sunset", "One Minute", "I See You", "Kafkaesque", "Fly", "Abiquiu", "Half Measures", "Full Measure" }, // S3
            { "Box Cutter", "Thirty-Eight Club", "Open House", "Bullet Points", "Shotgun", "Cornered", "Problem Dog", "Hermanos", "Bug", "Salud", "Crawl Space", "End Times", "Face Off" }, // S4
            { "Live Free or Die", "Madrigal", "Hazard Pray", "Fifty-One", "Dead Freight", "Buyout", "Say My Name", "Gliding Over All", "Blood Money", "Buried", "Confessions", "Rabid Dog", "TO'hajiilee", "Ozymandias", "Granite State", "Felina" } // S5
        };

        /* Nested loop which takes the information in the array as well as the locally defined variables and the randomness to define the attributes we've created. */
        for (int season = 0; season < titles.length; season++) {  
            for (int ep = 0; ep < titles[season].length; ep++) {   
                Episode episode = new Episode(titles[season][ep], ep + 1, season + 1, rand.nextInt(max - min + 1)+min);
                breakingBad.addEpisode(episode);
            }
        }

        // 2.3
        System.out.println(breakingBad);
        breakingBad.fetchEpisode(titles[0][1]);

        // 2.4
        ArrayList<Episode> season4 = breakingBad.getEpisodesInSeason(4); 
        for (Episode e : season4) {
            System.out.println(e.getTitle());
        }

        // 2.5
        System.out.println("\nAverage Runtime:");
        System.out.printf("%.2f%n", breakingBad.getAverageRuntime());

        // 2.7 / 2.8
        Episode E34S8 = new Episode("This will definitely break the function...", 34, 8,  rand.nextInt(max - min + 1)+min);
        breakingBad.addEpisode(E34S8);

        Episode E1S6 = new Episode("El Camino now streaming on Netflix!", 1, 6,  122);
        breakingBad.addEpisode(E1S6);
    }
}
