package FoodPlace;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
*This class represents the manager staff type and the functions that are specific to them.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Manager extends Staff{
    
    /**
    *Contructor for the manager.
    *@param fname First Name.
    *@param lname Last Name.
    *@param hoursToWork The number of hours the driver needs to work.
    *@param sType The staff type (manager).
    *@param sId The staff Id.
    *@param uname The manager's username.
    *@param pword The manager's password.
    */
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
    
    /**
    *Contructor for the manager including the number of hours worked.
    *@param fname First Name.
    *@param lname Last Name.
    *@param hoursToWork The number of hours the driver needs to work.
    *@param sType The staff type (manager).
    *@param sId The staff Id.
    *@param uname The manager's username.
    *@param pword The manager's password.
    @param hWorked The number of hours worked.
    */
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
    
    /**
    *Function to create a new staff member.
    *@param fname First Name.
    *@param lname Last Name.
    *@param hoursToWork The number of hours the staff member needs to work.
    *@param sType The staff type.
    *@param sId The staff Id.
    *@param uname The staff member's username.
    *@param pword The staff member's password.
    */
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
    
    /**
    *Function to delete a staff member.
    *@param personId The Id of the staff member to be removed.
    *@param staffs The list from which the staff member will be removed.
    */
    public void removeStaff(int personId, ObservableList<Staff> staffs){
        staffs.removeIf(staff -> personId == staff.getStaffId());
    }

    /**
    *Function to generate the most popular menu items report.
    *@param menu The menu from which the items will be taken.
    *@return An array of menu items that are ordered most.
    */
    public MenuItem[] generateReport(Menu menu){
        return Report.getMostPopularItems(menu);
    }

    /**
    *Function to retrieve the staff members with the most hours worked.
    *@param staffs The list from which the staff members will be retrieved.
    *@return A filtered list of the top 5 staff members in terms of number of hours worked.
    */
    public FilteredList<Staff> generateReportStaff(ObservableList<Staff> staffs){
        return Report.getMostHoursWorked(staffs);
    }

    /**
    *Function to retrieve the most active customers in terms of number of bookings made.
    *@param customers The list of customers to be filtered.
    *@return A filtered list of the most active customers.
    */
    public FilteredList<Customer> generateReport(ObservableList<Customer> customers){
        return Report.getMostActiveCustomers(customers);
    }

    /**
    *Function to generate a report on the busiest persiod in the restaurant based on booking times.
    *@return The busiest time period.
    */
    public String generateReport(){
        return Report.getBusiestPeriod();
    }

}
