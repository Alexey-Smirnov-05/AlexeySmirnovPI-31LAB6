public class Skip {
    private Playlist playlist;

    public Skip(Playlist playlist) {
        this.playlist = playlist;
    }

    public void skipSong() {
        playlist.setCurrentTrack((playlist.getCurrentTrack() + 1) % playlist.getTotalNumberOfTracks());
        Playback playback = new Playback(playlist, playlist.getCurrentTrack());
        playback.playSong();
    }
}
