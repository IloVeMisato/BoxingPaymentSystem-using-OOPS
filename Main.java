package usingScannerclasses;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning){
            System.out.println("\nChoose an option : ");
            System.out.println("1.Add Veteran Boxer : ");
            System.out.println("2.Add Rookie Boxer : ");
            System.out.println("3.Add Trainer : ");
            System.out.println("4.Add Cutman : ");
            System.out.println("5.Display all active Staff : ");
            System.out.println("6.Calculate Total Payroll : ");
            System.out.println("7.Release Staff by Id");
            System.out.println("8.Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 :
                    //Veteran Boxer
                    System.out.println("Add Veteran Boxer ID : ");
                    int vId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Veteran Name : ");
                    String vName = scanner.nextLine();
                    System.out.println("Enter Monthly Payment :");
                    double vPayment = scanner.nextDouble();
                    System.out.println("Enter Bonus Percentage : ");
                    double vBonus = scanner.nextDouble();

                    payrollSystem.addStaff(new Veteran(vId,vName,vPayment,vBonus));
                    System.out.println("Veteran Boxer added Successfully");
                    break;

                case 2:
                    //Rookie
                    System.out.println("Add Rookie Boxer ID : ");
                    int rId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Rookie Name : ");
                    String rName = scanner.nextLine();
                    System.out.println("Enter Matches Played :");
                    int matches = scanner.nextInt();
                    System.out.println("Enter Minutes Lasted : ");
                    int minutes = scanner.nextInt();
                    System.out.println("Enter Performance Bonus per Minute : ");
                    int bonusPerMinute = scanner.nextInt();

                    //more...
                    payrollSystem.addStaff(new Rookie(rId,rName,matches,minutes,bonusPerMinute));
                    System.out.println("Rookie Boxer added Successfully");
                    break;

                case 3:
                    //Trainer
                    System.out.println("Add Trainer ID : ");
                    int tId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Trainer Name : ");
                    String tName = scanner.nextLine();
                    System.out.println("Enter Hours Worked :");
                    int hoursWorked = scanner.nextInt();
                    System.out.println("Enter Hourly Rate : ");
                    double hourlyRate = scanner.nextDouble();

                    // m
                    payrollSystem.addStaff(new Trainer(tId,tName,hoursWorked,hourlyRate));
                    System.out.println("Trainer added Successfully");
                    break;


                case 4:
                    //CutMan
                    System.out.println("Add CutMan ID : ");
                    int cId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter CutMan Name : ");
                    String cName = scanner.nextLine();
                    System.out.println("Enter Monthly Salary :");
                    int cSalary = scanner.nextInt();


                    //m
                    payrollSystem.addStaff(new CutMan(cId,cName,cSalary));
                    System.out.println("CutMan added Successfully");
                    break;


                case 5:
                    //display all staff
                    payrollSystem.displayAllStaff();
                    break;

                case 6:
                    //calculate total payroll yahape
                    System.out.println("Total Payroll(including bonuses for boxers):$" + payrollSystem.calculateTotalPayroll());
                    break;

                case 7:
                    System.out.println("Enter Staff ID to release:");
                    int releaseId = scanner.nextInt();
                    payrollSystem.releaseStaff(releaseId);
                    System.out.println("Staff with ID " + releaseId + " has been released.");
                    break;

                case 8:
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Invalid option, Please try again .");
                    break;

            }

        }
        scanner.close();
    }
}
// earlier this was not working because of no constructor class for trainer, veteran, rookie and all,logic behind it. calling constructors and all
// separate payrollsystem class
//override tostring method, return type as string.