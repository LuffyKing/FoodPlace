package FoodPlace.FoodDB;

import FoodPlace.*;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;

/**
*Links the booking class to the sql database.
*@author Damola Aderinwale
*@version ?
*/
public class BookingDB {
    DBUtil pool;
    
    /**
    *
    */
    public BookingDB() throws Exception{
        super();
        pool = new DBUtil();
    }

    /**
    *Retrieve a booking from the database.
    *@param bookingId the ID of the booking to be retrieved.
    *@return booking The details of the booking.
    */
    public Booking getBooking(int bookingId) throws SQLException {
        Booking booking = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from bookings b_id = "+bookingId)) {
                    while (rs.next()) {
                        int customerId = rs.getInt("customer_id");
                        int waiter_id = rs.getInt("waiter_id");
                        LocalDateTime bookingTime = rs.getTimestamp("booking_time").toLocalDateTime();
                        int bookingLength = rs.getInt("booking_length");
                        int noOfGuests = rs.getInt("noOfGuests");
                        boolean approved = rs.getBoolean("approved");
                        booking = new Booking(noOfGuests,
                                bookingLength,
                                bookingTime,
                                customerId,
                                bookingId,
                                waiter_id,
                                approved);
                    }
                }
            }
        }
        return booking;
    }

    /**
    *Return a list of booking for a specific customer ID in the database.
    *@param customerId The customer ID for which you want to retrieve the bookings of.
    *@return a list of bookings for a specific customer.
    */
    public ObservableList<Booking> getAllCustomerBookings(int customerId) throws SQLException {
        ObservableList<Booking> bookings = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from bookings customer_id = "+customerId)) {
                    while (rs.next()) {
                        Booking booking = null;
                        int bookingId = rs.getInt("b_id");
                        int waiter_id = rs.getInt("waiter_id");
                        LocalDateTime bookingTime = rs.getTimestamp("booking_time").toLocalDateTime();
                        int bookingLength = rs.getInt("booking_length");
                        int noOfGuests = rs.getInt("noOfGuests");
                        boolean approved = rs.getBoolean("approved");
                        booking = new Booking(noOfGuests,
                                bookingLength,
                                bookingTime,
                                customerId,
                                bookingId,
                                waiter_id,
                                approved);
                        bookings.add(booking);
                    }
                }
            }
        }
        return bookings;
    }

    /**
    *Retrieves a list of all bookings in the database.
    *@return a list of all bookings.
    */
    public ObservableList<Booking> getAllBookings() throws SQLException {
        ObservableList<Booking> bookings = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from bookings")) {
                    while (rs.next()) {
                        Booking booking = null;
                        int bookingId = rs.getInt("b_id");
                        int customerId = rs.getInt("customer_id");
                        int waiter_id = rs.getInt("waiter_id");
                        LocalDateTime bookingTime = rs.getTimestamp("booking_time").toLocalDateTime();
                        int bookingLength = rs.getInt("booking_length");
                        int noOfGuests = rs.getInt("noOfGuests");
                        boolean approved = rs.getBoolean("approved");
                        booking = new Booking(noOfGuests,
                                              bookingLength,
                                              bookingTime,
                                              customerId,
                                              bookingId,
                                              waiter_id,
                                              approved);
                        bookings.add(booking);
                    }
                }
            }
        }
        return bookings;
    }
    
    /**
    *Creates a booking in the database.
    *@param numberOfGuests_ The number of guests in the booking.
    *@param bookingLength_ The length of the booking.
    *@param bookingTime_ The date and time of the booking.
    *@param customerID_ The Id of the customer that the booking is associated with.
    *@param waiterID_ The Id of the waiter.
    *@param approved_ The status of the booking, approved or not.
    *@return the booking that has been created.
    */
    public Booking createBooking(int numberOfGuests_,
                                 int bookingLength_,
                                 LocalDateTime bookingTime_,
                                 final int customerID_,
                                 int waiterID_,
                                 boolean approved_) throws SQLException {
        Booking booking = null;
        Timestamp timestamp = Timestamp.valueOf(bookingTime_);
        String insert = "INSERT INTO bookings\n"+
                "(customer_id,\n"+
                "waiter_id,\n"+
                "booking_time,\n"+
                "noOfGuests,\n"+
                "approved,\n"+
                "booking_length)\n"+
                "VALUES( "+ customerID_+",\n"+
                waiterID_+",\n"+
                timestamp+",\n"+
                numberOfGuests_+",\n"+
                approved_+",\n"+
                bookingLength_+"\n"+
                "); \n";
        String[] returnIds = {"b_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int bId = rs.getInt("s_id");
                        booking = getBooking(bId);
                    }
                }
            }
        }
        return booking;
    }

    /**
    *Deletes a specific booking from the database.
    *@param bookingId The ID of the booking to be deleted.
    */
    public void deleteBooking(int bookingId) throws SQLException {
        String delete = "DELETE FROM bookings where b_id = " + bookingId;
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(delete)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Deleting user failed, no rows affected.");
                }

            }
        }
    }

    /**
    *Deletes all bookings associated with a specific customer.
    *@param customerId The Id of the customer.
    */
    public void deleteAllCustomerBookings(int customerId) throws SQLException {
        String delete = "DELETE FROM bookings where customer_id = " + customerId;
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(delete)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Deleting user failed, no rows affected.");
                }

            }
        }
    }

    /**
    *Edits a booking in the database.
    *@param bookingId The Id of the booking to be edited.
    *@param numberOfGuests_ The new number of guests in the booking.
    *@param bookingLength_ The new length of the booking.
    *@param bookingTime_ The new date and time of the booking.
    *@param approved_ The new approval status of the booking.
    *@return the edited booking.
    */
    public Booking editBooking(int bookingId,
                             int numberOfGuests_,
                             int bookingLength_,
                             LocalDateTime bookingTime_,
                             boolean approved_
    ) throws SQLException {
        Booking booking = null;
        String update = "UPDATE Booking SET ";
        update += " approved=" +approved_+", ";
        if (numberOfGuests_ > 0) {
            update += "noOfGuests = " + numberOfGuests_ + ",";
        }
        if (bookingLength_ > 0) {
            update += "booking_length = " + bookingLength_ + ",";
        }
        if (bookingTime_ != null){
            Timestamp timestamp = Timestamp.valueOf(bookingTime_);
            update += "booking_time = " + timestamp + ",";
        }
        if (update.lastIndexOf(",") == update.length()-1){
            update = update.substring(0, update.length()-2);
        }
        update += " where b_id = "+ bookingId+";";
        String[] returnIds = {"s_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(update, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Updating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int bId = rs.getInt("b_id");
                        booking = getBooking(bId);
                    }
                }
            }
        }
        return booking;
    }


}
