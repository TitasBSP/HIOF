import java.time.LocalDate;
import java.util.ArrayList;

public class O3Main {
    public static void main(String[] args) {

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
        Episode simpsonsE1S1 = new Episode("Simpsons roasting on an open fire", 1, 1, 23, "TBA", LocalDate.of(1989, 12, 17), davidSilverman, new ArrayList<>());
        Episode simpsonsE2S1 = new Episode("Bart The Genius", 2, 1, 23, "TBA", LocalDate.of(1990, 01, 14), davidSilverman, new ArrayList<>());

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





    }
}
