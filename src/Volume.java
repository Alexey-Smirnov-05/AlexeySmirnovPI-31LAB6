public class Volume {
    private int volume;

    public Volume() {
        this.volume = 50;
    }

    public void changeVolume(int newVolume) {
        if (newVolume >= 0 && newVolume <= 100) {
            this.volume = newVolume;
            System.out.println("Громкость изменена на " + volume + "%");
        } else {
            System.out.println("Неверная громкость");
        }
    }
}
