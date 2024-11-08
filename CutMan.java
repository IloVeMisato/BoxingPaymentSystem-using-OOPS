package usingScannerclasses;

public class CutMan {
    private int id;
    private String name;
    private int monthlySalary;

    public CutMan(int id, String name, int monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    // Additional methods
    public double calculatePayroll() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "CutMan[id=" + id + ", name=" + name + ", monthlySalary=" + monthlySalary + "]";
    }

    public int getId() {
        return id;
    }

}

