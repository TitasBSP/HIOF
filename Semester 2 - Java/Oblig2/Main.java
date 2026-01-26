import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TVSeries breakingBad = new TVSeries("Breaking Bad", "Walter White is cool", LocalDate.of(2008, 1, 20), new ArrayList<>());
        String[][] titles = {
            { "Pilot", "Cat's in the bag", "And the Bag's in the River", "Cancer Man", "Gray Matter", "Crazy Handful of Nothing", "A No-Rough-Stuff-Type Deal" }, // S1
            { "Seven Thirty-Seven", "Grilled", "Bit by a Dead Bee", "Down", "Breakage", "Peekaboo", "Negro y Azul", "Better Call Saul", "4 Days Out", "Over", "Mandala", "Phoenix", "ABQ" }, // S2
            { "No Mas", "Caballo sin Nombre", "I.F.T.", "Green Light", "Mas", "Sunset", "One Minute", "I See You", "Kafkaesque", "Fly", "Abiquiu", "Half Measures", "Full Measure" }, // S3
            { "Box Cutter", "Thirty-Eight Club", "Open House", "Bullet Points", "Shotgun", "Cornered", "Problem Dog", "Hermanos", "Bug", "Salud", "Crawl Space", "End Times", "Face Off" }, // S4
            { "Live Free or Die", "Madrigal", "Hazard Pray", "Fifty-One", "Dead Freight", "Buyout", "Say My Name", "Gliding Over All", "Blood Money", "Buried", "Confessions", "Rabid Dog", "TO'hajiilee", "Ozymandias", "Granite State", "Felina" } // S5
        };

        for (int season = 0; season < titles.length; season++) {  // season index 0-4
            for (int ep = 0; ep < titles[season].length; ep++) {   // episode index
                Episode episode = new Episode(titles[season][ep], ep + 1, season + 1, 48);
                breakingBad.addEpisode(episode);
            }
        }
        
        System.out.println(breakingBad);
        breakingBad.fetchEpisode(titles[0][1]);

        System.out.println(breakingBad.getEpisodesInSeason(4));

    }
}
