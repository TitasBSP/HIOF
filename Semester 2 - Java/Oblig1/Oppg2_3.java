import java.util.Scanner;

public class Oppg2_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Planet mars = new Planet( "Mars", 3889.5, 6.39E23); // 
        Planet jupiter = new Planet( "Jupiter", 71492, 1.93E27);
        Planet mercury = new Planet("Mercury", 2440, 3.3E23 );

        Planet[] planets; // Lager array som lagrer flere planeter
        boolean running = true;

        int i = 0;
        planets = new Planet[42]; // Meningen av livet er 42, man skal ikke utspørre det.

        System.out.println("Planeten " + mars.getName() + " har en radius paa " + mars.getRadius() + " og en masse paa " + mars.getMass() + " kg");
        System.out.println("Planeten " + jupiter.getName() + " har en radius paa " + jupiter.getRadius() + " og en masse paa " + jupiter.getMass() + " kg");
        System.out.println("Planeten " + mercury.getName() + " har en radius paa " + mercury.getRadius() + " og en masse paa " + mercury.getMass() + " kg");

        while (running) {

            System.out.println("\nVelg en handling:\n[1 - Opprette en ny planet] / [2 - Liste eksisterende planeter] / [3 - Slette en planet] / [4 - Oppdatere en planet] / [5 - Avslutte Programmet]" );
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
                        
                        System.out.println("\nPlaneten " + planet0.getName() + " har en radius paa " + planet0.getRadius() + " og en masse paa " + planet0.getMass() + " kg");
                        System.out.println("Planeten har blitt lagt til i posisjonen: " + i);

                        planets[i] = planet0;

                        i++; // Øker plassen der nye planeter legges slik at den ikke skriver over eksisterende planeter.
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Can't convert due to an invalid number!"); // Fanger ugyldige verdier som strenger i radius eller vekt.
                    }

                    break;
                }

                case "2" -> { // Vi sjekker om listen er tom for hver gang vi skal gjøre en operasjon som krever at vi ser listen.
                    boolean planetFound = false;
                    System.out.println("\nListen med eksisterende planeter:");
                    for (Planet p : planets) {
                        if (p != null) {
                            planetFound = true;
                            System.out.println(p.getName());
                        }
                    }
                    if (!planetFound) {
                        System.out.println("\nDenne listen har ingen planeter ennaa...");
                    }

                    break;
                }

                case "3" -> { 
                    boolean planetFound = false;
                    System.out.println("\nVelg en planet aa slette: ");
                    
                    for (Planet p : planets) {
                        if (p != null) {
                            planetFound = true;
                            System.out.println(p.getName());
                        }
                    }
                    if (!planetFound) {
                        System.out.println("\nDenne listen har ingen planeter ennaa...");
                    }

                        String del = read.nextLine();
                        del = del.toLowerCase();
                        planetFound = false;

                        for (int j = 0; j < planets.length; j++) { // Vi null'ifyer objekten dersom den finnes på listen, samme logikk gjelder for resten av koden.
                            if (planets[j] != null && planets[j].getName().equalsIgnoreCase(del)) {
                                planets[j] = null;
                                System.out.println("\nPlaneten " + del + " har blitt slettet fra listen.");
                                planetFound = true;
                                break;

                            } 
                        }

                        if (!planetFound) {
                                System.out.println("\nError: Planeten ikke funnet.");
                        }
                        
                    break;
                }

                case "4" -> {
                    boolean planetFound = false;
                    System.out.println("\nVelg en planet aa endre: ");

                    for (Planet p : planets) {
                        if (p != null) {
                            planetFound = true;
                            System.out.println(p.getName());
                        }
                    }
                    if (!planetFound) {
                        System.out.println("\nDenne listen har ingen planeter ennaa...");
                    }
                        
                        String change = read.nextLine();
                        planetFound = false;
                        
                        for (int j = 0; j < planets.length; j++) {
                            if (planets[j] != null && planets[j].getName().equalsIgnoreCase(change)) {
                                System.out.println("\nHva har du lyst til aa endre?: ");
                                System.out.println("1 - Navn, 2 - Radius, 3 - Masse");

                                String changeWhat = read.nextLine();
                                switch(changeWhat) {
                                    case "1" -> {
                                        System.out.println("Hva skal planeten hete naa?: ");
                                        String changeName = read.nextLine();
                                        System.out.println("Navnet " + planets[j].getName() + " har blitt endret til " + changeName);
                                        planets[j].setName(changeName);
                                        break;
                                    }

                                    case "2" -> {
                                        System.out.println("Hva blir den nye radiusen?: ");
                                        String changeRadius = read.nextLine();   
                                        
                                        try {
                                            double newChangeRadius = Double.parseDouble(changeRadius);
                                            System.out.println("Radiusen til " + planets[j].getName() + " har blitt endret til " + changeRadius);
                                            planets[j].setRadius(newChangeRadius);
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
                                            System.out.println("Massen til " + planets[j].getName() + " har blitt endret til " + changeMass);
                                            planets[j].setMass(newChangeMass);
                                        } catch (NumberFormatException e) {
                                            System.out.println("Error: Can't convert due to an invalid number!");
                                        }
                                        
                                        break;
                                    }
                                }

                                planetFound = true;

                            } else if (planetFound) {
                                break;

                            }
                        }
                        if (!planetFound) {
                            System.out.println("\nError: Planeten ikke funnet.");
                        }
                    break;
                }

                case "5" -> {
                    System.out.println("Avslutter...");
                    System.exit(0);
                }

                default -> {
                }

            }
            
        }
    }
}
class Planet {
    private String name;
    private double radius;
    private double mass;

    public String getName() {return name;}
    public double getRadius() {return radius;}
    public double getMass() {return mass;}

    public void setName(String name) {this.name = name;}
    public void setRadius(double radius) {this.radius = radius;}
    public void setMass(double mass) {this.mass = mass;}

    public Planet(String name, double radius, double mass) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }
}


