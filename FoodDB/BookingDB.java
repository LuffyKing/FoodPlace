package FoodPlace.FoodDB;

import FoodPlace.*;
import FoodPlace.Driver;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;

public class BookingDB extends DBUtil{
    DBPool pool;
    public BookingDB() throws Exception{
        super();
        pool = getDBConnectionPool();
    }

    public ObservableList<Booking> getAllBookings() throws SQLException {
        ObservableList<Booking> bookings = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from bookings")) {
                    while (rs.next()) {
                        Booking booking = null;
                        int bookingId = rs.getInt("b_id");
                        String name = rs.getString("name");
                        String type = rs.getString("type");
                        int customerId = rs.getInt("customer_id");
                        int staff_id = rs.getInt("staff_id");
                        LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
                        LocalDateTime endTime = rs.getTimestamp("end_time").toLocalDateTime();
                        int bookingLength = rs.getInt("booking_length");
                        int noOfGuests = rs.getInt("noOfGuests");
                        boolean approved = rs.getBoolean("approved");
                        booking = new Booking(noOfGuests, bookingLength, startTime, customerId, bookingId);
                        bookings.add(booking);
                    }
                }
            }
        }
        return bookings;
    }

    public Staff getStaff(int staffId) throws SQLException {
        Staff staff = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Staff where s_id = "+staffId)) {
                    while (rs.next()) {
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        int hoursWorked = rs.getInt("hours_worked");
                        int hoursToWork = rs.getInt("hours_2bworked");
                        String type = rs.getString("type");
                        String username = rs.getString("S_username");
                        String password = rs.getString("password");
                        switch (type){
                            case "waiter": {
                                staff = new Waiter(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                            case "chef":{
                                staff = new Chef(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                            case "driver":{
                                staff = new Driver(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return staff;
    }

    public Staff createStaff(String fname,
                             String lname,
                             int h2Work,
                             String sType,
                             String uname,
                             String pword) throws SQLException {
        Staff staff = null;
        String insert = "INSERT INTO STAFF\n"+
                "(first_name,\n"+
                "last_name,\n"+
                "hours_worked,\n"+
                "hours_2bworked,\n"+
                "type,\n"+
                "S_username,\n"+
                "password)\n"+
                "VALUES( "+ fname+",\n"+
                lname+",\n"+
                0+",\n"+
                h2Work+",\n"+
                sType+",\n"+
                uname+",\n"+
                pword+
                "); \n";
        String[] returnIds = {"s_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int sId = rs.getInt("s_id");
                        staff = getStaff(sId);
                    }
                }
            }
        }
        return staff;
    }

    public void deleteStaff(int staffId) throws SQLException {
        String delete = "DELETE FROM STAFF where s_id = " + staffId;
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(delete)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Deleting user failed, no rows affected.");
                }

            }
        }
    }

    public Staff editStaff(int staffId,
                           String fname,
                           String lname,
                           int h2Work,
                           int hWorked,
                           String sType,
                           String uname,
                           String pword
    ) throws SQLException {
        Staff staff = null;
        String update = "UPDATE STAFF SET ";
        if (fname != null) {
            update += "first_name = '" + fname + "',";
        }
        if (lname != null) {
            update += "last_name = '" + lname + "',";
        }
        if (hWorked > 0){
            update += "hours_worked = " + hWorked + ",";
        }
        if (h2Work > 0){
            update += "hours_2bworked = " + h2Work + ",";
        }
        if (sType != null){
            update += "type = '"+ sType +"',";
        }
        if (uname != null){
            update += "S_username ='" + uname+"',";
        }
        if (pword != null){
            update += "password = '" + pword+ "'";
        }
        if (update.lastIndexOf(",") == update.length()-1){
            update = update.substring(0, update.length()-2);
        }
        update += " where s_id = "+ staffId+";";
        String[] returnIds = {"s_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(update, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Updating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int sId = rs.getInt("s_id");
                        staff = getStaff(sId);
                    }
                }
            }
        }
        return staff;
    }


}
