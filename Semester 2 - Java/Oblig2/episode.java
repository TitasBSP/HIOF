public class episode {
    private String title;
    private int episodeNumber;
    private int seasonNumber;
    private int runtime;

    public String getTitle() {return title;}
    public int getEpisodeNumber() {return episodeNumber;}
    public int getSeasonNumber() {return seasonNumber;}   
    public int getRuntime() {return runtime;}

    public String setTile(String title) {return this.title = title;}
    public int setEpisodeNumber(int episodeNumber) {return this.episodeNumber = episodeNumber;}
    public int setSeasonNumber(int seasonNumber) {return this.seasonNumber = seasonNumber;}
    public int setRuntime(int runtime) {return this.runtime = runtime;}

    public episode(String title, int episodeNumber, int seasonNumber, int runtime) {
        this.title = title;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.runtime = runtime;
    }

    public void episodeAlt(String title, int episodeNumber, int seasonNumber) {
        this.title = title;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }
}
