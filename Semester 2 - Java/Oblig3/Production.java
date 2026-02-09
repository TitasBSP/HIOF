abstract public class Production {
    private String title;
    private int runtimeInMinutes;

    public String getTitle() {return title;}
    public int getRuntimeInMinutes() {return runtimeInMinutes;}

    public void setTitle(String title) {this.title = title;}
    public void setRuntimeInMinutes(int runtimeInMinutes) {this.runtimeInMinutes = runtimeInMinutes;}

    public Production(String title, int runtimeInMinutes) {
        this.title = title;
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public Production(String title) {
        this.title = title;
    }
}
