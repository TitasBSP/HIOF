import java.util.Scanner;

public class Oppg2_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Planet mars = new Planet( "Mars", 3889.5, 6.39E23);
        Planet jupiter = new Planet( "Jupiter", 71492, 1.93E27);
        Planet mercury = new Planet("Mercury", 2440, 3.3E23 );

        Planet[] planets;
        String[] planetNames;

        int i = 0;
        planets = new Planet[42]; // The meaning of life is 42, one must not question it.
        planetNames = new String[42];

        System.out.println("Planeten " + mars.name + " har en radius på " + mars.radius + " og en masse på " + mars.mass + " kg");
        System.out.println("Planeten " + jupiter.name + " har en radius på " + jupiter.radius + " og en masse på " + jupiter.mass + " kg");
        System.out.println("Planeten " + mercury.name + " har en radius på " + mercury.radius + " og en masse på " + mercury.mass + " kg");

        while (i != 42) {
            System.out.println("\nVelg en handling:\n[1 - Opprette en ny planet] / [2 - Liste eksisterende planeter] / [3 - Slette en planet] / [4 - Oppdatere en planet]");
            String choice = read.nextLine();

            switch(choice) {
                case "1" -> {
                    System.out.println("\nNå kan du lage din egen planet!");
                    System.out.println("Hva skal planeten hete?: ");
                    String name = read.nextLine();
                    name = name.toLowerCase();

                    System.out.println("Hva er radiusen til planeten i kilometer?: ");
                    String givenRadius = read.nextLine();
                    double radius;

                    System.out.println("Hvor mye veier planeten i kilogram?: ");
                    String givenMass = read.nextLine();
                    double mass;

                    try {
                        radius = Double.parseDouble(givenRadius);
                        mass = Double.parseDouble(givenMass); 
                        Planet planet0 = new Planet(name, radius, mass);
                        
                        System.out.println("Planeten " + planet0.name + " har en radius på " + planet0.radius + " og en masse på " + planet0.mass + " kg");
                        System.out.println("Planeten har blitt lagt til i posisjonen: " + i);

                        planets[i] = planet0;
                        planetNames[i] = planet0.name;

                        i++;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Can't convert due to an invalid number!");
                    }
                }

                case "2" -> {
                    System.out.println("\nListen med eksisterende planeter:");
                    if (planetNames[0] == null) {
                        System.out.println("Denne listen er tom.");
                    } else {
                        for (String planetName : planetNames) {
                            if (planetNames[i] != null) {
                                System.out.println(planetName);
                            }
                        }
                    }
                }

                case "3" -> {
                    System.out.println("\nSlette en planet fra listen.");
                    for (String planetName : planetNames) {
                            if (planetNames[i] != null) {
                                System.out.println(planetName);
                            }
                        }

                    String del = read.nextLine();
                    del = del.toLowerCase();

                    for (int j = 0; j < planetNames.length; j++) {
                        if (planetNames[j] != null && planetNames[j].equals(del)) {
                            planetNames[j] = null;
                            planets[j] = null;
                            System.out.println("Planeten " + del + " har blitt slettet fra listen.");
                            break;
                        }
                    }
                }
                case "4" -> {
                    System.out.println("\nVelg en planet å endre:");
                    for (String planetName : planetNames) {
                            if (planetNames[i] != null) {
                                System.out.println(planetName);
                            }
                        }

                    String change = read.nextLine();
                    change = change.toLowerCase();

                    for (int j = 0; j < planetNames.length; j++) {
                        if (planetNames[j] != null && planetNames[j].equals(change)) {
                            System.out.println("Hva har du lyst til å endre?: ");
                            System.out.println("\n1 - Navn, 2 - Radius, 3 - Masse");

                            String changeWhat = read.nextLine();
                            switch(changeWhat) {
                                case "1" -> {
                                    break;
                                }
                            }
                            
                            System.out.println("Planeten " + change + " har blitt slettet fra listen.");
                            break;
                        }
                    }
                }

                default -> {
                }

            }
            
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
