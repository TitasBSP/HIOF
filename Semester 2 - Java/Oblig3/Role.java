public class Role {
    private String roleFirstName;
    private String roleLastName;
    private Person actor;
    
    public String getRoleFirstName() {return roleFirstName;}
    public String getRoleLastName() {return roleLastName;}
    public Person getActor() {return actor;}

    public void setRoleFirstName(String roleFirstName) {this.roleFirstName = roleFirstName;}
    public void setRoleLastName(String roleLastName) {this.roleLastName = roleLastName;}
    public void setActor(Person actor) {this.actor = actor;}

    public void getFullRole() {
        System.out.println(roleFirstName + " " + roleLastName + " Starred by: " + actor.getFullName());
    }

    @Override
    public String toString() {
        return "\nFirst Name of Role: " + roleFirstName
                + "\nLast Name of Role: " + roleLastName
                + "\nActor: " + actor;
    }
 
    public Role(String roleFirstName, String roleLastName, Person actor) {
        this.roleFirstName = roleFirstName;
        this.roleLastName = roleLastName;
        this.actor = actor;
    }

}
