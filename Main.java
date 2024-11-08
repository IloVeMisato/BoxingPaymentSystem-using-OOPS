package BoxerPayrollSystem;

import java.util.ArrayList;
import java.util.List;

abstract class Staff {
    private int id;
    private String name;
    private boolean active;

    public Staff(int id, String name) {
        this.id = id;
        this.name = name;
        this.active = true; // All staff members are active by default
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract double calculatePayment();

    @Override
    public String toString() {
        return "Staff [name=" + name + ", id=" + id + ", active=" + active + ", salary=" + calculatePayment() + "]";
    }
}

// Boxer class inherits from Staff
abstract class Boxer extends Staff {
    private int timePlayed; // Cumulative time in minutes for all matches

    public Boxer(int id, String name) {
        super(id, name);
        this.timePlayed = 0;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void addTimePlayed(int minutes) {
        this.timePlayed += minutes;
    }

    public abstract double calculateBonus();

    @Override
    public String toString() {
        return super.toString() + ", timePlayed=" + timePlayed;
    }
}

// Veteran class with fixed salary and bonus percentage based on time played
class Veteran extends Boxer {
    private double monthlyPayment;
    private double bonusPercentage;

    public Veteran(int id, String name, double monthlyPayment, double bonusPercentage) {
        super(id, name);
        this.monthlyPayment = monthlyPayment;
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculatePayment() {
        return monthlyPayment;
    }

    @Override
    public double calculateBonus() {
        return monthlyPayment * bonusPercentage / 100;
    }
}

// Rookie class with match-based payment and a bonus based on time played
class Rookie extends Boxer {
    private int matchesPlayed;
    private int minutesLasted;
    private int performanceBonusPerMinute;

    public Rookie(int id, String name, int matchesPlayed, int minutesLasted, int performanceBonusPerMinute) {
        super(id, name);
        this.matchesPlayed = matchesPlayed;
        this.minutesLasted = minutesLasted;
        this.performanceBonusPerMinute = performanceBonusPerMinute;
        addTimePlayed(minutesLasted); // Adding initial time played
    }

    @Override
    public double calculatePayment() {
        return matchesPlayed * minutesLasted;
    }

    @Override
    public double calculateBonus() {
        return getTimePlayed() * performanceBonusPerMinute;
    }
}

// Trainer class with hourly wage
class Trainer extends Staff {
    private int hoursWorked;
    private double hourlyRate;

    public Trainer(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePayment() {
        return hoursWorked * hourlyRate;
    }
}

// Cutman class with a flat monthly payment
class Cutman extends Staff {
    private double monthlySalary;

    public Cutman(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePayment() {
        return monthlySalary;
    }
}

// Payroll System handling all types of staff
class PayrollSystem {
    private List<Staff> staffList;

    public PayrollSystem() {
        staffList = new ArrayList<>();
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public void releaseStaff(int id) {
        Staff staffToRelease = null;
        for (Staff staff : staffList) {
            if (staff.getId() == id) {
                staffToRelease = staff;
                break;
            }
        }
        if (staffToRelease != null) {
            staffToRelease.setActive(false);
        }
    }

    public void displayAllStaff() {
        for (Staff staff : staffList) {
            if (staff.isActive()) {
                System.out.println(staff);
            }
        }
    }

    public void displayStaffByType(Class<?> type) {
        for (Staff staff : staffList) {
            if (type.isInstance(staff) && staff.isActive()) {
                System.out.println(staff);
            }
        }
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Staff staff : staffList) {
            if (staff.isActive()) {
                total += staff.calculatePayment();
                if (staff instanceof Boxer) {
                    total += ((Boxer) staff).calculateBonus();
                }
            }
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Adding boxers
        Veteran veteran1 = new Veteran(1, "Mike Tyson", 30000, 10); // 10% bonus
        Rookie rookie1 = new Rookie(2, "Ryan Barker", 10, 200, 5); // $5 bonus per minute
        Rookie rookie2 = new Rookie(3, "Henry Cejudo", 15, 300, 8);

        // Adding trainers
        Trainer trainer1 = new Trainer(4, "Freddie Roach", 40, 100); // 40 hours at $100/hr
        Trainer trainer2 = new Trainer(5, "Eddie Futch", 30, 120);

        // Adding cutmen
        Cutman cutman1 = new Cutman(6, "Mick", 4000);
        Cutman cutman2 = new Cutman(7, "Charlie", 3500);

        // Adding staff to payroll
        payrollSystem.addStaff(veteran1);
        payrollSystem.addStaff(rookie1);
        payrollSystem.addStaff(rookie2);
        payrollSystem.addStaff(trainer1);
        payrollSystem.addStaff(trainer2);
        payrollSystem.addStaff(cutman1);
        payrollSystem.addStaff(cutman2);

        // Display all active staff
        System.out.println("All Active Staff:");
        payrollSystem.displayAllStaff();

        // Display only boxers
        System.out.println("\nDisplaying Only Boxers:");
        payrollSystem.displayStaffByType(Boxer.class);

        // Display only trainers
        System.out.println("\nDisplaying Only Trainers:");
        payrollSystem.displayStaffByType(Trainer.class);

        // Display only cutmen
        System.out.println("\nDisplaying Only Cutmen:");
        payrollSystem.displayStaffByType(Cutman.class);

        // Total payroll calculation
        System.out.println("\nTotal Payroll (including bonuses for boxers): $" + payrollSystem.calculateTotalPayroll());

        // Release a staff member and show updated payroll
        System.out.println("\nReleasing Boxer with ID 2 (Ryan Barker):");
        payrollSystem.releaseStaff(2);
        payrollSystem.displayAllStaff();
    }
}