package FoodPlace.FoodDB;

import java.sql.*;
import java.util.HashMap;

/**
*Queries the database to generate specific report types.
*@author Damola Aderinwale
*@version ?
*/
public class ReportDB{
  
    /**
    *Prints out the top 5 most active customers.
    *@param args
    */
    public static void main(String[] args) {
        try {
            ReportDB rp = new ReportDB();
            int[] a = rp.getMostActiveCustomers();
            for (int i:
                 a) {
                System.out.println(i);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    
    DBUtil pool;
    
    /**
    *Function to get a new connection instance to the database.
    */
    public ReportDB() throws Exception{
        super();
        pool = new DBUtil();
    }

    /**
    *Queries the database to generate most popular items report.
    *@return The most ordered 5 items on the menu.
    */
    public int[] getMostPopularItems() throws SQLException {
        int[] ans = null;
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT menu_item_id,COUNT(id) AS order_count FROM orders GROUP BY menu_item_id ORDER BY order_counts DESC LIMIT 5")) {
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    final int columnCount = rsMetaData.getColumnCount();
                    ans = new int[columnCount];
                    int count = 0;
                    while (rs.next()){
                        ans[count++] = rs.getInt("menu_item_id");
                    }
                }
            }
        }
        return ans;
    }
    
    /**
    *Queries the database to generate the most active customers report.
    *@return The 5 customers who have made the most bookings.
    */
    public int[] getMostActiveCustomers() throws SQLException {
        int[] ans = null;
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT customer_id,COUNT(b_id) AS counts FROM bookings GROUP BY customer_id ORDER BY counts DESC LIMIT 5")) {
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    final int columnCount = rsMetaData.getColumnCount();
                    ans = new int[columnCount];
                    int count = 0;
                    while (rs.next()){
                        ans[count++] = rs.getInt("customer_id");
                    }
                }
            }
        }
        return ans;
    }
    
    /**
    *Queries the database to generate the most hourd worked report.
    *@return The top 5 staff members in terms of hours worked.
    */
    public int[] getMostHoursWorked() throws SQLException {
        int[] ans = null;
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT S_id, hours_worked FROM Staff ORDER BY hours_worked DESC LIMIT 5")) {
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    final int columnCount = rsMetaData.getColumnCount();
                    ans = new int[columnCount];
                    int count = 0;
                    while (rs.next()){
                        ans[count++] = rs.getInt("s_id");
                    }
                }
            }
        }
        return ans;
    }
    
    /**
    *Queries the database to determine what is the busiest time for the restaurant.
    *@return The date and time of most booked time slot.
    */
    public String getBusiestPeriod() throws SQLException {
        HashMap<String, Integer> periods = new HashMap<String, Integer>();
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select DATE_FORMAT(start_time, '%H:%i') as s_time, DATE_FORMAT(end_time, '%H:%i') as e_time from bookings")) {
                    while (rs.next()) {
                        Timestamp s_start = rs.getTimestamp("s_time");
                        Timestamp e_end  = rs.getTimestamp("e_time");
                        String periodKey = s_start + " - "+e_end;
                        periods.put(periodKey, periods.getOrDefault(periodKey,1));
                    }
                }
            }
        }
        int highest = Integer.MIN_VALUE;
        String highestPeriod = "";
        for (String i: periods.keySet()) {
            if (periods.get(i) > highest) {
                highest = periods.get(i);
                highestPeriod = i;
            }
        }
        return highestPeriod;
    }
}
