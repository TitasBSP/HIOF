import java.util.Scanner;

public class Oppg2_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Planet mars = new Planet( "Mars", 3889.5, 6.39E23); // 
        Planet jupiter = new Planet( "Jupiter", 71492, 1.93E27);
        Planet mercury = new Planet("Mercury", 2440, 3.3E23 );

        Planet[] planets; // Lager array som lagrer flere planeter
        String[] planetNames;

        int i = 0;
        planets = new Planet[42]; // Meningen av livet er 42, man skal ikke utspørre det.
        planetNames = new String[42]; // Siden vi kan ikke printe planeten i terminalen så tar vi bare navnet.

        System.out.println("Planeten " + mars.name + " har en radius paa " + mars.radius + " og en masse paa " + mars.mass + " kg");
        System.out.println("Planeten " + jupiter.name + " har en radius paa " + jupiter.radius + " og en masse paa " + jupiter.mass + " kg");
        System.out.println("Planeten " + mercury.name + " har en radius paa " + mercury.radius + " og en masse paa " + mercury.mass + " kg");

        while (i != 42) {

            System.out.println("\nVelg en handling:\n[1 - Opprette en ny planet] / [2 - Liste eksisterende planeter] / [3 - Slette en planet] / [4 - Oppdatere en planet]");
            String choice = read.nextLine();

            switch(choice) { // Switch casen går gjennom de forskjellige valgene basert på brukerens input.
                
                case "1" -> {
                    System.out.println("\nNaa kan du lage din egen planet!");
                    System.out.println("Hva skal planeten hete?: ");
                    String name = read.nextLine();
                    name = name.toLowerCase();

                    System.out.println("\nHva er radiusen til planeten i kilometer?: ");
                    String givenRadius = read.nextLine();
                    double radius;

                    System.out.println("\nHvor mye veier planeten i kilogram?: ");
                    String givenMass = read.nextLine();
                    double mass;

                    try {
                        radius = Double.parseDouble(givenRadius);
                        mass = Double.parseDouble(givenMass); 
                        Planet planet0 = new Planet(name, radius, mass); // Oppretter en ny objekt basert på brukerens verdier.
                        
                        System.out.println("\nPlaneten " + planet0.name + " har en radius paa " + planet0.radius + " og en masse paa " + planet0.mass + " kg");
                        System.out.println("Planeten har blitt lagt til i posisjonen: " + i);

                        planets[i] = planet0;
                        planetNames[i] = planet0.name;

                        i++; // Øker plassen der nye planeter legges slik at den ikke skriver over eksisterende planeter.
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Can't convert due to an invalid number!"); // Fanger ugyldige verdier som strenger i radius eller vekt.
                    }

                    break;
                }

                case "2" -> { // Vi sjekker om listen er tom for hver gang vi skal gjøre en operasjon som krever at vi ser listen.
                    System.out.println("\nListen med eksisterende planeter:");
                    if (planetNames[0] == null) {
                        System.out.println("\nDenne listen er tom.");
                    } else { // Ellers skriver vi ut planetene slik det skal gjøres.
                        for (String planetName : planetNames) {
                            if (planetName != null) {
                                System.out.println(planetName);
                            }
                        }
                    }

                    break;
                }

                case "3" -> { 
                    if (planetNames[0] == null) {
                        System.out.println("\nDenne listen er tom.");
                    } else {
                        System.out.println("\nSlette en planet fra listen.");
                        for (String planetName : planetNames) {
                                if (planetName != null) {
                                    System.out.println(planetName);
                                }
                            }

                        String del = read.nextLine();
                        del = del.toLowerCase();

                        for (int j = 0; j < planetNames.length; j++) { // Vi null'ifyer objekten dersom den finnes på listen, samme logikk gjelder for resten av koden.
                            if (planetNames[j] != null && planetNames[j].equals(del)) {
                                planetNames[j] = null;
                                planets[j] = null;
                                System.out.println("\nPlaneten " + del + " har blitt slettet fra listen.");
                                break;
                            } else {
                                System.out.println("\nError: Planeten ikke funnet.");
                            }
                        }
                    }
                    break;
                }

                case "4" -> {
                    if (planetNames[0] == null) {
                        System.out.println("\nDenne listen er tom.");
                    } else {
                        System.out.println("\nVelg en planet aa endre:");
                        for (String planetName : planetNames) {
                                if (planetName != null) {
                                    System.out.println(planetName);
                                }
                            }
                        
                        String change = read.nextLine();
                        change = change.toLowerCase();

                        for (int j = 0; j < planetNames.length; j++) {
                            if (planetNames[j] != null && planetNames[j].equals(change)) {
                                System.out.println("\nHva har du lyst til aa endre?: ");
                                System.out.println("1 - Navn, 2 - Radius, 3 - Masse");

                                String changeWhat = read.nextLine();
                                switch(changeWhat) {
                                    case "1" -> {
                                        System.out.println("Hva skal planeten hete naa?: ");
                                        String changeName = read.nextLine();
                                        System.out.println("Navnet " + planetNames[j] + " har blitt endret til " + changeName);
                                        planetNames[j] = changeName;
                                        break;
                                    }

                                    case "2" -> {
                                        System.out.println("Hva blir den nye radiusen?: ");
                                        String changeRadius = read.nextLine();   
                                        
                                        try {
                                            double newChangeRadius = Double.parseDouble(changeRadius);
                                            System.out.println("Radiusen til " + planetNames[j] + " har blitt endret til " + changeRadius);
                                            planets[j].radius = newChangeRadius;
                                        } catch (NumberFormatException e) {
                                            System.out.println("Error: Can't convert due to an invalid number!");
                                        }
                                        break;
                                    }

                                    case "3" -> {
                                        System.out.println("Hvor mye skal planeten veie?: ");
                                        String changeMass = read.nextLine();
                                        
                                        try {
                                            double newChangeMass = Double.parseDouble(changeMass);
                                            System.out.println("Massen til " + planetNames[j] + " har blitt endret til " + changeMass);
                                            planets[j].mass = newChangeMass;
                                        } catch (NumberFormatException e) {
                                            System.out.println("Error: Can't convert due to an invalid number!");
                                        }
                                        
                                        break;
                                    }
                                }
                            } else if (planetNames[j] != null) {
                                System.out.println("\nError: Planeten ikke funnet.");
                            }
                        }
                    }
                    break;
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

    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }
}
