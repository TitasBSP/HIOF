public class inheritence {
    public static void main(String[] args) {
        Person Ole = new Person("Ole", "Nordmann", 39);
        System.out.println("Person: " + Ole.getFirstName() + " " + Ole.getLastName() + "\nAge: " + Ole.getAge());
 
        Carpenter Rolf = new Carpenter("Rolf", "Andersen", 61, 1497);

        Rolf.getAge();
    }
}
