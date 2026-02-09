public class Episode extends Production {
    private int episodeNumber;
    private int seasonNumber;

    public int getEpisodeNumber() {return episodeNumber;}
    public int getSeasonNumber() {return seasonNumber;}   

    public void setEpisodeNumber(int episodeNumber) {this.episodeNumber = episodeNumber;}
    public void setSeasonNumber(int seasonNumber) {this.seasonNumber = seasonNumber;}

    @Override
    public String toString() {
        return "\nEpisode Title: " + super.getTitle()
                + "\nEpisode Number: " + episodeNumber
                + "\nSeason Number: " + seasonNumber
                + "\nRuntime: " + super.getRuntimeInMinutes();
    }

    public Episode(String title, int episodeNumber, int seasonNumber, int runtime) {
        super(title, runtime); // Note: Call super first in the constructor, in one line with all variables together
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }

    public Episode(String title, int episodeNumber, int seasonNumber) {
        super(title);
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }
}

