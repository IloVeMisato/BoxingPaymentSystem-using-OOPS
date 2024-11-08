package usingScannerclasses;

public class Trainer {
    private int id;
    private String name;
    private int hoursWorked;
    private double hourlyRate;

    public Trainer(int id, String name, int hoursWorked, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculatePayroll() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String toString() {
        return "Trainer[id=" + id + ", name=" + name + ", hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate + "]";  // return karega aise values.
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getHoursWorked() {
//        return hoursWorked;
//    }
//
//    public void setHoursWorked(int hoursWorked) {
//        this.hoursWorked = hoursWorked;
//    }
//
//    public double getHourlyRate() {
//        return hourlyRate;
//    }
//
//    public void setHourlyRate(double hourlyRate) {
//        this.hourlyRate = hourlyRate;
//    }
}
