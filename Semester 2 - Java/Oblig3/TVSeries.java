import java.time.LocalDate;
import java.util.ArrayList;

public class TVSeries extends Production {
    private ArrayList<Episode> episodes = new ArrayList<>();

    private double averageRuntime;
    private int numSeasons;

    public ArrayList<Episode> getEpisodes() {return episodes;}

    public double getAverageRuntime() {return averageRuntime;}
    public int getNumSeasons() {return numSeasons;}

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
        return "\nTV Series Title: " + getTitle() 
        + "\nDescription: " + getDescription() 
        + "\nRelease date: " + getReleaseDate() 
        + "\nNumber of episodes: " + episodes.size();
    }

    public void fetchEpisode(String title) {
        for (Episode ep : episodes) {
            if (ep.getTitle().equalsIgnoreCase(title)) {
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
                totalRuntime += ep.getRuntimeInMinutes();
                episodeAmount++;
            } 

            averageRuntime = totalRuntime / episodeAmount;
            return averageRuntime;
        }
    }

    public ArrayList<Role> getCast() {
        ArrayList<Role> cast = new ArrayList<>();

        for (Episode ep : episodes) {
            cast.addAll(ep.getRoles());
        }

        ArrayList<Role> filteredCast = new ArrayList<>();
        for (Role role : cast) {
            if (!filteredCast.contains(role)) {
                filteredCast.add(role);
            }
        }

        return filteredCast;
    }

    public void calculateEpisodeNum() {
        for (Episode ep : episodes) {
            for (Role role : getCast())
                if (ep.getRoles().contains(role)) {
                    Person actor = role.getActor();
                    actor.addAppearance();              
            }
        }
        
        for (Person actor : getActors()) {
            if (episodes.contains(actor)) {
                System.out.println(actor.getFullName() + " has starred: " + actor.getStarredCount() + " times.");
            }
        }
    }



    public TVSeries(String title, String description, LocalDate releaseDate, ArrayList<Episode> episodes, int numSeasons) {
        super(title);
        setDescription(description);
        setReleaseDate(releaseDate);
        setRoles(new ArrayList<>());
        this.episodes = episodes;
        this.numSeasons = numSeasons;
    }
}
