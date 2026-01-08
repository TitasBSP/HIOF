import java.util.Scanner; 

public class Oppg2_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Planet mars = new Planet( "Mars", 3889.5, 6.39E23);
        Planet jupiter = new Planet( "Jupiter", 71492, 1.93E27);
        Planet mercury = new Planet("Mercury", 2440, 3.3E23 );

        System.out.println("Planeten " + mars.name + " har en radius på " + mars.radius + " og en masse på " + mars.mass + " kg");
        System.out.println("Planeten " + jupiter.name + " har en radius på " + jupiter.radius + " og en masse på " + jupiter.mass + " kg");
        System.out.println("Planeten " + mercury.name + " har en radius på " + mercury.radius + " og en masse på " + mercury.mass + " kg");

        System.out.println("\nNå kan du lage din egen planet!");
        System.out.println("Hva skal planeten hete?: ");
        String name = read.nextLine();

        System.out.println("Hva er radiusen til planeten i kilometer?: ");
        String givenRadius = read.nextLine();
        double radius;

        System.out.println("Hvor mye veier planeten i kilogram?: ");
        String givenMass = read.nextLine();
        double mass;

        try {
            radius = Double.parseDouble(givenRadius); 
            mass = Double.parseDouble(givenMass); 
            Planet planet = new Planet(name, radius, mass);
            System.out.println("Planeten " + planet.name + " har en radius på " + planet.radius + " og en masse på " + planet.mass + " kg");
        } catch (NumberFormatException e) {
            System.out.println("Error: Can't convert due to an invalid number!");
        }
        
    }
}

class Planet {
    String name;
    double radius;
    double mass;

    public Planet(String name, double radius, double mass) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }
}
