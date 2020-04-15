package FoodPlace;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class Manager extends Staff{
    public Manager(
            String fname,
            String lname,
            int hoursToWork,
            String sType,
            int sId,
            String uname,
            String password
    ){
        super(
                fname,
                lname,
                hoursToWork,
                sType,
                sId,
                uname,
                password);
    }
    public Manager(
            String fname,
            String lname,
            int hoursToWork,
            String sType,
            int sId,
            String uname,
            String password,
            int hWorked
    ){
        super(
                fname,
                lname,
                hoursToWork,
                sType,
                sId,
                uname,
                password,
                hWorked);
    }
    public void addStaff(String fname,
                         String lname,
                         int hoursToWork,
                         String sType,
                         int sId,
                         String uname,
                         String password,
                         ObservableList<Staff> staffs){
        Staff newStaff = null;
        switch (sType){
            case "waiter": {
                newStaff = new Waiter(
                        fname,
                        lname,
                        hoursToWork,
                        sType,
                        sId,
                        uname,
                        password);
                break;
            }
            case "chef":{
                newStaff = new Chef(fname,
                        lname,
                        hoursToWork,
                        sType,
                        sId,
                        uname,
                        password);
                break;
            }
            case "driver":{
                newStaff = new Driver(fname,
                        lname,
                        hoursToWork,
                        sType,
                        sId,
                        uname,
                        password);
                break;
            }
        }
        staffs.add(newStaff);
    }
    public void removeStaff(int personId, ObservableList<Staff> staffs){
        staffs.removeIf(staff -> personId == staff.getStaffId());
    }

    public MenuItem[] generateReport(Menu menu){
        return Report.getMostPopularItems(menu);
    }

    public FilteredList<Staff> generateReportStaff(ObservableList<Staff> staffs){
        return Report.getMostHoursWorked(staffs);
    }

    public FilteredList<Customer> generateReport(ObservableList<Customer> customers){
        return Report.getMostActiveCustomers(customers);
    }

    public String generateReport(){
        return Report.getBusiestPeriod();
    }

}