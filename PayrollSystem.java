package usingScannerclasses;

import java.util.ArrayList;

public class PayrollSystem {
    private ArrayList<Object> staffList;

    public PayrollSystem(){
        staffList = new ArrayList<>();
    }
    public void addStaff(Object staff){
        staffList.add(staff);
    }

    public void displayAllStaff(){
        for(Object staff : staffList){
            System.out.println(staff);
        }
    }

    public double calculateTotalPayroll(){
        double totalPayroll = 0;
        for(Object staff : staffList){
            if (staff instanceof Veteran){
                totalPayroll +=((Veteran) staff).calculatePayroll();
            } else if (staff instanceof Rookie ) {
                totalPayroll += ((Rookie) staff).calculatePayroll();
            } else if (staff instanceof Trainer) {
                totalPayroll +=((Trainer) staff).calculatePayroll();
            } else if (staff instanceof CutMan) {
                totalPayroll +=((CutMan) staff).calculatePayroll();
            }
        }
        return totalPayroll;
    }


        public void releaseStaff(int id) {
            staffList.removeIf(staff -> {
                if (staff instanceof Veteran) return ((Veteran) staff).getId() == id;
                if (staff instanceof Rookie) return ((Rookie) staff).getId() == id;
                if (staff instanceof Trainer) return ((Trainer) staff).getId() == id;
                if (staff instanceof CutMan) return ((CutMan) staff).getId() == id;
                return false;
            });
        }
    }

