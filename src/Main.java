import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        User user = new User(playlist);
        Volume volume = new Volume();

        playlist.loadTracksFromFile("playlist.txt");

        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Меню плеера:");
            System.out.println("0. Добавить трек");
            System.out.println("1. Изменить громкость");
            System.out.println("2. Воспроизвести");
            System.out.println("3. Пауза");
            System.out.println("4. Следующий трек");
            System.out.println("5. Предыдущий трек");
            System.out.println("6. Удалить трек");
            System.out.println("7. Просмотреть треки в плейлисте");
            System.out.println("8. Выход");
            System.out.print("Действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очищаем буфер ввода

            switch (choice) {
                case 0: {
                    Track song = new Track();
                    System.out.print("Введите название трека: ");
                    String title = scanner.nextLine(); // Используем nextLine для считывания строки
                    song.setTitle(title);
                    user.addSongToPlaylist(song);
                    playlist.saveTracksToFile("playlist.txt");
                    break;
                }
                case 1: {
                    int newVolume;
                    System.out.print("Введите громкость (0-100): ");
                    newVolume = scanner.nextInt();
                    volume.changeVolume(newVolume);
                    break;
                }
                case 2:
                    if (playlist.getTotalNumberOfTracks() > 0) {
                        Playback playback = new Playback(playlist, playlist.getCurrentTrack());
                        playback.playSong();
                    } else {
                        System.out.println("Нет треков в плейлисте");
                    }
                    break;
                case 3:
                    if (playlist.getTotalNumberOfTracks() > 0) {
                        Pause pause = new Pause(playlist);
                        pause.pauseSong();
                    } else {
                        System.out.println("Нет треков в плейлисте");
                    }
                    break;
                case 4:
                    if (playlist.getTotalNumberOfTracks() > 0) {
                        Skip skip = new Skip(playlist);
                        skip.skipSong();
                    } else {
                        System.out.println("Нет треков в плейлисте");
                    }
                    break;
                case 5:
                    if (playlist.getTotalNumberOfTracks() > 0) {
                        Previous previous = new Previous(playlist);
                        previous.previousSong();
                    } else {
                        System.out.println("Нет треков в плейлисте");
                    }
                    break;
                case 6: {
                    if (playlist.getTotalNumberOfTracks() > 0) {
                        int index;
                        System.out.print("Введите индекс трека для удаления: ");
                        index = scanner.nextInt();
                        if (index >= 1 && index <= playlist.getTotalNumberOfTracks()) {
                            playlist.removeSong(index - 1);
                            playlist.saveTracksToFile("playlist.txt"); // Сохраняем изменения в файле
                        } else {
                            System.out.println("Неверный индекс");
                        }
                    } else {
                        System.out.println("Нет треков в плейлисте");
                    }
                    break;
                }
                case 7:
                    if (playlist.getTotalNumberOfTracks() > 0) {
                        View view = new View(playlist);
                        view.viewSongs();
                    } else {
                        System.out.println("Нет треков в плейлисте");
                    }
                    break;
                case 8:
                    scanner.close(); // Закрываем сканер перед выходом
                    return;
                default:
                    System.out.println("Ошибка выбора действия");
            }
            System.out.println("\n\n");
        }
    }
}