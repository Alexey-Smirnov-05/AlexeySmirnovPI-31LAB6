import java.util.List;

class AdvancedPlaylist extends Playlist {
    private String name;

    public AdvancedPlaylist() {
        super();
        this.name = "My Playlist";
    }

    public AdvancedPlaylist(String name) {
        super();
        this.name = name;
    }
    public AdvancedPlaylist(AdvancedPlaylist other) {
        super(other);
        this.name = other.name;
    }

    @Override
    public AdvancedPlaylist clone() {
        AdvancedPlaylist cloned = (AdvancedPlaylist) super.clone();
        cloned.name = this.name;
        return cloned;
    }


    @Override
    public void playSong() {
        if (!tracks.isEmpty()) {
            System.out.println("Играет из AdvancedPlaylist '" + name + "': " + tracks.get(currentTrack).getTitle());
        } else {
            System.out.println("Плейлист '" + name + "' пуст.");
        }
    }

    public void playSpecificSong(int index) {
        if (index >= 0 && index < tracks.size()) {
            System.out.println("Играет конкретный трек: " + tracks.get(index).getTitle());
        } else {
            System.out.println("Неверный индекс трека.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}