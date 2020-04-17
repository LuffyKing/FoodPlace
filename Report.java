package FoodPlace;

import FoodPlace.FoodDB.ReportDB;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.Arrays;

/**
*This class represents the generated reports required by the manager.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Report {
    
    /**
    *Function to generate the most popular items report.
    *@param menu The menu.
    *@return An array of most popular menu items.
    */
    public static MenuItem[] getMostPopularItems(Menu menu){
        MenuItem[] menuItems = null;
        try {
            ReportDB reportDB = new ReportDB();
            int[] menuItemIds = reportDB.getMostPopularItems();
            menuItems = new MenuItem[menuItemIds.length];
            int count = 0;
            for (int m:
                 menuItemIds) {
                menuItems[count++] = menu.getMenuItem(m);
            }
            return menuItems;
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return menuItems;
    }

    /**
    *Function to generate the most active customer report.
    *@param customers A list of customers.
    *@return A filtered list of most active customers.
    */
    public static FilteredList<Customer> getMostActiveCustomers(ObservableList<Customer> customers){
        FilteredList<Customer> activeCustomers = null;
        try {
            ReportDB reportDB = new ReportDB();
            int[] customerIds = reportDB.getMostActiveCustomers();
            Arrays.sort(customerIds);
            activeCustomers = customers.filtered(customer -> Arrays.binarySearch(customerIds, customer.getCustomerId()) != 1);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return activeCustomers;
    }

    /**
    *Function to generate the most hours worked report.
    *@param staffs A list of staff members.
    *@return A filtered list of staff based on most hours worked.
    */
    public static FilteredList<Staff> getMostHoursWorked(ObservableList<Staff> staffs){
        FilteredList<Staff> activeEmps = null;
        try {
            ReportDB reportDB = new ReportDB();
            int[] staffIds = reportDB.getMostHoursWorked();
            Arrays.sort(staffIds);
            activeEmps= staffs.filtered(staff -> Arrays.binarySearch(staffIds, staff.getStaffId()) != 1);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return activeEmps;
    }

    /**
    *Function to generate the busiest time period report.
    *@return The busiest time period.
    */
    public static String getBusiestPeriod(){
        String busiestPeriod = null;
        try {
            ReportDB reportDB = new ReportDB();
            busiestPeriod  = reportDB.getBusiestPeriod();

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return busiestPeriod;
    }

}
