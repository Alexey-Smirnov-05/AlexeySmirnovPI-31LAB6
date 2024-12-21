public class Playback {
    private Playlist playlist;
    private int currentTrack;

    public Playback(Playlist playlist, int currentTrack) {
        this.playlist = playlist;
        this.currentTrack = currentTrack;
    }

    public void playSong() {
        System.out.println("Сейчас играет: " + playlist.getTracks().get(currentTrack).getTitle());
    }
}
