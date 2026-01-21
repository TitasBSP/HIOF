
import java.time.LocalDate;
import java.util.*;

public class TVSeries {
    private String title;
    private String description;
    private LocalDate releaseDate;
    private ArrayList<episode> episodes;

    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public LocalDate getReleaseDate() {return releaseDate;}
    public ArrayList<episode> getepisodes() {return episodes;}

    public String setTitle(String title) {return this.title = title;}
    public String setDescription(String description) {return this.description = description;}
    public LocalDate setReleaseDate(LocalDate releaseDate) {return this.releaseDate = releaseDate;}

    public void addEpisode(episode episodeName) {
        episodes.add(episodeName);
    }

    // public void formatting(String title, String description, LocalDate releaseDate, ArrayList<episode> episodes) {
       // System.out.println("TV Series Title: " + title + "\nDescription: " + description + "\nRelease date: " + releaseDate + "\nNumber of episodes: " + episodes.size());
    // }

    public TVSeries(String title, String description, LocalDate releaseDate, ArrayList<episode> episodes) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.episodes = episodes;
    }
}