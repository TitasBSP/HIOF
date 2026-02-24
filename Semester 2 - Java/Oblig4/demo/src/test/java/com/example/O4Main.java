import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Random;

abstract public class O4Main {
    public static void main(String[] args) {
        Random rand = new Random(); 
        int min = 34, max = 45; 

        // Starting date, pilot time -> Ending date, current time
        // We want to make it so that season is Delta of Years (Current year - 1965)

        LocalDate pilotDate = LocalDate.of(1965, 11, 8);
        LocalDate currentDate = LocalDate.now();
        LocalDate startingDate = pilotDate;

        Person josephBehar = new Person("Joseph", "Behar", 0, 1951);

        TVSeries doul = new TVSeries("Days of our Lives", "It's old...", LocalDate.of(1965,11,8), new ArrayList<>(), 0);

        for (int season = 0; season < (currentDate.getYear() - pilotDate.getYear()); season++) {  
            int epCounter = 0;
            int daysInYear;

            if (season == 0) {
                startingDate = pilotDate;  // first season starts at pilot date
                daysInYear = (int) (LocalDate.of(pilotDate.getYear(), 12, 31).toEpochDay() - startingDate.toEpochDay() + 1);
            } else {
                startingDate = LocalDate.of(pilotDate.getYear() + season, 1, 1); // others start Jan 1
                daysInYear = Year.of(startingDate.getYear()).length();
            }

            for (int ep = 0; ep < daysInYear; ep++) { 
                DayOfWeek weekendChecker = startingDate.getDayOfWeek();

                if ((weekendChecker != DayOfWeek.SATURDAY) && (weekendChecker != DayOfWeek.SUNDAY))  {  
                    Episode episode = new Episode("Episode " + (epCounter), epCounter, season + 1, rand.nextInt(max - min + 1)+min, "It lasts a while...", pilotDate, startingDate, josephBehar, new ArrayList<>());
                    doul.addEpisode(episode);
                    epCounter++;
                } else {
   
                }

                startingDate = startingDate.plusDays(1);
            }
        }

        Person christopherNolan = new Person("Christopher", "Nolan", 0, 1993);
        Person peterHewitt = new Person("Peter", "Hewitt", 0, 1989);
        Person davidSilverman = new Person("David", "Silverman", 0, 1979);

        Person christianBale = new Person("Christian", "Bale", 0, 1986);
        Role batman = new Role("Bruce", "Wayne", christianBale);

        Person joaquinPhoenix = new Person("Joaquin", "Phoenix", 0, 1982);
        Role joker = new Role("The", "Joker", joaquinPhoenix);

        Person nancyCartwright = new Person("Nancy", "Cartwright", 0, 1980);
        Role bart = new Role("Bart", "Simpson", nancyCartwright);

        Person danielCastellaneta = new Person("Daniel", "Castellaneta", 0, 1979);
        Role homer = new Role("Homer", "Simpson", danielCastellaneta);

        Person julieKavner = new Person("Julie", "Kavner", 0, 1971);
        Role marge = new Role("Marge", "Simpson", julieKavner);

        ArrayList<Role> rolesInTDK = new ArrayList<>();
        rolesInTDK.add(batman);
        rolesInTDK.add(joker);

        ArrayList<Role> rolesInSimpsons = new ArrayList<>();
        rolesInSimpsons.add(bart);
        rolesInSimpsons.add(homer);
        rolesInSimpsons.add(marge);
        rolesInSimpsons.add(marge); // Checking duplicate handling

        TVSeries simpsons = new TVSeries("The Simpsons", "TBA", LocalDate.of(1989, 12, 17), new ArrayList<>(), 37);

        Movie theDarkKnight = new Movie("The Dark Knight", "TBA", 152, LocalDate.of(2008,07, 25), christopherNolan, new ArrayList<>());
        Movie garfield = new Movie("Garfield: The Movie", "TBA", 80, LocalDate.of(2004, 06, 11), peterHewitt, new ArrayList<>());
        Episode simpsonsE1S1 = new Episode("Simpsons roasting on an open fire", 1, 1, 23, "TBA", LocalDate.of(1989, 12, 17), LocalDate.of(1989, 12, 17), davidSilverman, new ArrayList<>());
        Episode simpsonsE2S1 = new Episode("Bart The Genius", 2, 1, 23, "TBA", LocalDate.of(1989, 12, 17), LocalDate.of(1990, 01, 14), davidSilverman, new ArrayList<>());

        System.out.println(theDarkKnight.getTitle());
        System.out.println(garfield.getTitle());

        System.out.println(theDarkKnight.getDirector().getFullName());
        System.out.println(garfield.getDirector().getFullName());
        System.out.println(simpsonsE1S1.getDirector().getFullName());

        theDarkKnight.addToRoles(joker);
        theDarkKnight.addToRoles(rolesInTDK);

        theDarkKnight.printAllRoles();

        simpsonsE1S1.addToRoles(rolesInSimpsons);
        simpsons.addEpisode(simpsonsE1S1);

        simpsonsE2S1.addToRoles(marge);
        simpsonsE2S1.addToRoles(homer);
        simpsons.addEpisode(simpsonsE2S1);

        for (Role role : simpsons.getCast()) {
            role.getFullRole();
        }

        simpsons.calculateEpisodeNum();

        ArrayList<Episode> season42 = doul.getEpisodesInSeason(42); 
        for (Episode ep : season42) {
            System.out.println(ep);
        }

        ///////////// Lage TVSeries objekter


    }
}
