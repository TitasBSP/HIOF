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

        ArrayList<Role> rolesInTDK = new ArrayList<>();
        rolesInTDK.add(batman);
        rolesInTDK.add(joker);

        TVSeries simpsons = new TVSeries("The Simpsons", "TBA", LocalDate.of(1989, 12, 17), new ArrayList<>(), 37);

        Movie theDarkKnight = new Movie("The Dark Knight", "TBA", 152, LocalDate.of(2008,07, 25), christopherNolan, new ArrayList<>());
        Movie garfield = new Movie("Garfield: The Movie", "TBA", 80, LocalDate.of(2004, 06, 11), peterHewitt, new ArrayList<>());
        Episode simpsonsE1S1 = new Episode("Simpsons roasting on an open fire", 1, 1, 23, "TBA", LocalDate.of(1989, 12, 17), davidSilverman, new ArrayList<>());

        System.out.println(theDarkKnight.getTitle());
        System.out.println(garfield.getTitle());

        System.out.println(theDarkKnight.getDirector().getFullName());
        System.out.println(garfield.getDirector().getFullName());
        System.out.println(simpsonsE1S1.getDirector().getFullName());

        theDarkKnight.addToRoles(joker);
        theDarkKnight.addToRoles(rolesInTDK);

        theDarkKnight.printAllRoles();



    }
}
