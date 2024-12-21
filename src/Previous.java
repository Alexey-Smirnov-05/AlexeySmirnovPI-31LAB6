public class Previous {
    private Playlist playlist;

    public Previous(Playlist playlist) {
        this.playlist = playlist;
    }

    public void previousSong() {
        playlist.setCurrentTrack((playlist.getCurrentTrack() - 1 + playlist.getTotalNumberOfTracks()) % playlist.getTotalNumberOfTracks());
        Playback playback = new Playback(playlist, playlist.getCurrentTrack());
        playback.playSong();
    }
}
