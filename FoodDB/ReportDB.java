package FoodPlace.FoodDB;

import java.sql.*;
import java.util.HashMap;

public class ReportDB extends DBUtil{
    DBPool pool;
    public ReportDB() throws Exception {
        super();
        pool = getDBConnectionPool();
    }

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
    public int[] getMostActiveCustomers() throws SQLException {
        int[] ans = null;
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT Customer_id,COUNT(b_id) AS counts FROM bookings GROUP BY Customers_id ORDER BY counts DESC LIMIT 5")) {
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
