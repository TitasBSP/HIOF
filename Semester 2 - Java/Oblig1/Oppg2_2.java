import java.util.Scanner; 

public class Oppg2_2 {
    public static void main(String[] args) { 
        Scanner read = new Scanner(System.in);
        System.out.println("Please enter your weight (Kilograms): ");
        String text = read.nextLine();

        int weight;

        try {
            weight = Integer.parseInt(text);
            System.out.println("Your weight on the moon is around: " + (weight * 0.165) + " Kilograms.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Can't convert weight due to an invalid number!");
        }
    }
}
