package usingScannerclasses;

public class Veteran {
    private int id;
    private String name;
    private double monthlyPayment;
    private double bonusPercentage;

    public Veteran(int id, String name, double monthlyPayment, double bonusPercentage) {
        this.id = id;
        this.name = name;
        this.monthlyPayment = monthlyPayment;
        this.bonusPercentage = bonusPercentage;
    }

    public double calculatePayroll() {
        return monthlyPayment + (monthlyPayment * bonusPercentage / 100);
    }

    @Override
    public String toString() {
        return "Veteran[id=" + id + ", name=" + name + ", monthlyPayment=" + monthlyPayment +
                ", bonusPercentage=" + bonusPercentage + "]";
    }

    public int getId() {
        return id;
    }


}
