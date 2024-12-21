import java.io.*;
import java.util.ArrayList;

public class Playlist {
    private ArrayList<Track> tracks; // Работа с массивом объектов (ArrayList)
    private int currentTrack;
    private static int instanceCount = 0; // Статическое поле для отслеживания количества экземпляров

    public Playlist() {
        tracks = new ArrayList<>();
        currentTrack = 0;
        instanceCount++; // Увеличиваем счетчик при создании нового экземпляра
    }

    public static int getInstanceCount() { // Статический метод для получения количества экземпляров
        return instanceCount;
    }

    public void viewSongs() {
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println((i + 1) + ". " + tracks.get(i).getTitle());
        }
    }

    public void addSong(Track song) {
        tracks.add(song);
    }

    public void removeSong(int index) {
        if (index >= 0 && index < tracks.size()) {
            tracks.remove(index);
        }
    }

    public int getTotalNumberOfTracks() {
        return tracks.size();
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public int getCurrentTrack() {
        return currentTrack;
    }

    public void setCurrentTrack(int currentTrack) {
        this.currentTrack = currentTrack; // Разумное использование оператора this
    }

    public void loadTracksFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Создаем новый файл, если он не существует
                System.out.println("Файл " + filename + " был создан."); // Сообщение о создании файла
            } catch (IOException e) {
                System.err.println("Ошибка при создании файла: " + e.getMessage());
            }
            return; // Выходим из метода, так как файл пуст
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                addSong(new Track(line));
            }
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке треков: " + e.getMessage());
        }
    }

    public void saveTracksToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Track track : tracks) {
                bw.write(track.getTitle());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении треков: " + e.getMessage()); // Перехват исключений
        }
    }
}