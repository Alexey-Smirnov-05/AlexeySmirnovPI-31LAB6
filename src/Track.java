public class Track implements Playable {
    private String title;

    public Track() {}

    public Track(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Играет трек: " + title);
    }
}