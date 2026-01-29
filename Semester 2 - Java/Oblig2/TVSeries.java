
import java.time.LocalDate;
import java.util.ArrayList;

public class TVSeries {
    private String title;
    private String description;
    private LocalDate releaseDate;
    private ArrayList<Episode> episodes = new ArrayList<>();

    private double averageRuntime;
    private int numSeasons;

    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public LocalDate getReleaseDate() {return releaseDate;}
    public ArrayList<Episode> getepisodes() {return episodes;}

    public double getAverageRuntime() {return averageRuntime;}
    public int getNumSeasons() {return numSeasons;}

    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setReleaseDate(LocalDate releaseDate) {this.releaseDate = releaseDate;}


    public void addEpisode(Episode episodeName) {
        if (episodeName.getSeasonNumber() > (numSeasons + 1) || episodeName.getSeasonNumber() < 1) {
            System.out.println("\nError: Season number invalid! Could be exceeding the number of season + 1, or an invalid integer!");
            return;
        }
        
        if (episodeName.getSeasonNumber() == (numSeasons + 1)){
            System.out.println("\nNote: Season provided is one higher than numbers of seasons, new season added!");
            numSeasons++;
        }
            
        episodes.add(episodeName);
        updateAverageRuntime();
        
    }
    
    public void listEpisodes() {
        if (episodes.isEmpty()) {
            System.out.println("This list is currently empty.");
        } 
        for (Episode eps : episodes) {
            System.out.println(eps.getTitle());
        }
    }

    @Override
    public String toString() {
        return "\nTV Series Title: " + title 
        + "\nDescription: " + description 
        + "\nRelease date: " + releaseDate 
        + "\nNumber of episodes: " + episodes.size();
    }

    public void fetchEpisode(String title) {
        for (Episode ep : episodes) {
            if (ep.getTitle().equalsIgnoreCase(title.toLowerCase())) {
                System.out.println(ep);
                return;
            }
        }
        System.out.println("Episode not found!");
    }

    public ArrayList<Episode> getEpisodesInSeason(int season) {
        ArrayList<Episode> epsInSeason = new ArrayList<>();
        for (Episode eps : episodes) {
            if (eps.getSeasonNumber() == season) {
                epsInSeason.add(eps);
            }
        }
        return epsInSeason;
    }
 
    private double updateAverageRuntime() {
        int episodeAmount = 0;
        double totalRuntime = 0;

        if (episodes.isEmpty()) {
            averageRuntime = 0;
            return averageRuntime;

        } else {
            for (Episode ep : episodes) {
                totalRuntime += ep.getRuntime();
                episodeAmount++;
            } 

            averageRuntime = totalRuntime / episodeAmount;
            return averageRuntime;
        }
    }

    public TVSeries(String title, String description, LocalDate releaseDate, ArrayList<Episode> episodes, int numSeasons) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.episodes = episodes;
        this.numSeasons = numSeasons;
    }
}