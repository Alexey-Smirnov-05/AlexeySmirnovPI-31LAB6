public class User {
    private Playlist playlist;

    public User(Playlist playlist) {
        this.playlist = playlist;
    }

    public void addSongToPlaylist(Track song) {
        playlist.addSong(song);
    }

    public void removeSongFromPlaylist(int index) {
        playlist.removeSong(index);
    }

    public void viewPlaylist() {
        playlist.viewSongs();
    }
}
