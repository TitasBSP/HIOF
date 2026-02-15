import java.time.LocalDate;
import java.util.ArrayList;

// 2.1

abstract public class Production {
    private String title;
    private String description;
    private int runtimeInMinutes;
    private LocalDate releaseDate; // 2.3
    private Person director;
    private ArrayList<Role> roles;
    private ArrayList<Person> actors;

    public String getTitle() {return title;}
    public int getRuntimeInMinutes() {return runtimeInMinutes;}
    public String getDescription() {return description;}
    public LocalDate getReleaseDate() {return releaseDate;}
    public Person getDirector() {return director;}
    public ArrayList<Role> getRoles() {return roles;}
    public ArrayList<Person> getActors() {return actors;}

    public void setTitle(String title) {this.title = title;}
    public void setRuntimeInMinutes(int runtimeInMinutes) {this.runtimeInMinutes = runtimeInMinutes;}
    public void setDescription(String description) {this.description = description;}
    public void setReleaseDate(LocalDate releaseDate) {this.releaseDate = releaseDate;} 
    public void setDirector(Person director) {this.director = director;}
    public void setRoles(ArrayList<Role> roles) {this.roles = roles;}

    public void addToRoles(Role role) {
        roles.add(role);
    }

    public void addToRoles(ArrayList<Role> listOfRoles) {
        for (Role role : listOfRoles) {
            roles.add(role);
        }
    }

    public void printAllRoles() {
        for (Role role : roles) {
            role.getFullRole();
        }
    }

    @Override
    public String toString() {
        return "\nTitle: " + title
                + "\nDescription: " + description
                + "\nRuntime: " + runtimeInMinutes
                + "\nRelease date: " + releaseDate
                + "\nDirector: " + director.getFullName()
                + "\nRoles: " + roles;
    }

    public Production(String title, String description, int runtimeInMinutes, LocalDate releaseDate, Person director, ArrayList<Role> roles) {
        this.title = title;
        this.description = description;
        this.runtimeInMinutes = runtimeInMinutes;
        this.releaseDate = releaseDate;
        this.director = director;
        this.roles = roles;
    }

    public Production(String title) {
        this.title = title;
    }
}
