public class Carpenter extends Person{

    private int numHousesBuilt;

    public Carpenter(String firstName, String lastName, int age, int numHousesBuilt) {
        super(firstName, lastName, age);

        this.numHousesBuilt = numHousesBuilt;
    }

    public int getNumHousesBuilt() {return numHousesBuilt;}
    public void setHousesNumBuilt(int numHousesBuilt) {this.numHousesBuilt = numHousesBuilt;}
}
