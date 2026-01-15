import java.util.Scanner; // Et verktøy for å lese input

public class Oppg2_2 {
    public static void main(String[] args) { 
        Scanner read = new Scanner(System.in);
        System.out.println("Please enter your weight (Kilograms): ");
        String text = read.nextLine();

        int weight;

        try {
            weight = Integer.parseInt(text); // Konverterer input av streng til integer
            System.out.println("Your weight on the moon is around: " + (weight * 0.165) + " Kilograms."); // Kalkulerer vekten ved å ta omtrent 1/6 av input.

        } catch (NumberFormatException e) {
            System.out.println("Error: Can't convert weight due to an invalid number!"); // Fanger eventuelle feil der input inkluderer strenger.
        }
    }
}
