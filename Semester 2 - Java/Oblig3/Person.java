public class Person { // For future reference: Right-click on the selected variable -> Source Action -> Generate getters / setters / constructor
    private String firstName;
    private String lastName;
    private int starredCount;
    private int activeSinceYear;

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getStarredCount() {return starredCount;}
    public int getActiveSinceYear() {return activeSinceYear;}
    
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setStarredCount(int starredCount) {this.starredCount = starredCount;}
    public void setActiveSinceYear(int activeSinceYear) {this.activeSinceYear = activeSinceYear;}

    public String getFullName() {return firstName + ' ' + lastName;}

    public void addAppearance() {
        this.starredCount++;
    }
    
    @Override
    public String toString() {
        return "\nFirst Name: " + firstName
                + "\nLast Name: " + lastName
                + "\nStarred Count: " + starredCount
                + "\nActive Since (Year): " + activeSinceYear;
    }
    
    public Person(String firstName, String lastName, int starredCount, int activeSinceYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.starredCount = starredCount;
        this.activeSinceYear = activeSinceYear;
    }
}
