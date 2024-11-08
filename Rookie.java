package usingScannerclasses;

public class Rookie {
    private int id;
    private String name;
    private int matches;
    private int minutes;
    private int bonusPerMinute;

    public Rookie(int id, String name, int matches, int minutes, int bonusPerMinute) {
        this.id = id;
        this.name = name;
        this.matches = matches;
        this.minutes = minutes;
        this.bonusPerMinute = bonusPerMinute;
    }

    public double calculatePayroll() {
        return minutes * bonusPerMinute;
    }

    @Override
    public String toString() {
        return "Rookie[id=" + id + ", name=" + name + ", matchesPlayed=" + matches +
                ", minutesLasted=" + minutes + ", bonusPerMinute=" + bonusPerMinute + "]";
    }

    public int getId() {
        return id;
    }

}
