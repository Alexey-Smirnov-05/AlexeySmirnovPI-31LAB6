public class View {
    private Playlist playlist;

    public View(Playlist playlist) {
        this.playlist = playlist;
    }

    public void viewSongs() {
        playlist.viewSongs();
    }
}
