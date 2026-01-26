import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TVSeries breakingBad = new TVSeries("Breaking Bad", "Walter White is cool", LocalDate.of(2008, 1, 20), new ArrayList<>());
        episode E1S1 = new episode("Pilot", 1, 1, 58);
        episode E2S1 = new episode("Cat's in the bag", 2, 1, 48);
        
        breakingBad.addEpisode(E1S1);
        breakingBad.addEpisode(E2S1);
    }
}
