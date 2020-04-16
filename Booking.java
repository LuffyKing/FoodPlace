package FoodPlace;

import java.time.LocalDateTime;

/**
*This class represents a booking that consists of a: date, time, length, number of guests & an associated customer.
*@author Sara Philipson
*@version ?
*/

public class Booking {

    private final int bookingID;
    private int numberOfGuests;
    private LocalDateTime bookingTime;
    private int bookingLength;
    private boolean approved;
    private final int customerID;
    private int waiterID;

    /**
     *Creates a booking
     *@param numberOfGuests_ the number of guests in the booking.
     *@param bookingLength_ the length of the booking in hours.
     *@param bookingTime_ the date and time of the booking.
     *@param customerID_ the ID of the customer who has created the booking.
     *@param bookingID_ the ID associated with the booking.
     */
    public Booking(int numberOfGuests_,
                   int bookingLength_,
                   LocalDateTime bookingTime_,
                   final int customerID_,
                   int bookingID_
    ){
        numberOfGuests = numberOfGuests_;
        bookingLength = bookingLength_;
        bookingTime = bookingTime_;
        customerID = customerID_;
        bookingID = bookingID_;
        approved = false;
    }


    /**
    *Creates a booking.
    *@param numberOfGuests_ the number of guests in the booking.
    *@param bookingLength_ the length of the booking in hours.
    *@param bookingTime_ the date and time of the booking.
    *@param customerID_ the ID of the customer who has created the booking.
    *@param bookingID_ the ID associated with the booking.
     * @param waiterID_ the id of the approving waiter
     * @param approved_ the approval status
    */
    public Booking(int numberOfGuests_,
                   int bookingLength_,
                   LocalDateTime bookingTime_,
                   final int customerID_,
                   int bookingID_,
                   int waiterID_,
                   boolean approved_
                   ){
        numberOfGuests = numberOfGuests_;
        bookingLength = bookingLength_;
        approved = approved_;
        bookingTime = bookingTime_;
        customerID = customerID_;
        bookingID = bookingID_;
        waiterID = waiterID_;
    }
    /**
     *Retrieves the staff ID of the approving waiter.
     *@return waiterID
     */
    public int getWaiterID() {
        return waiterID;
    }
    /**
     *Sets ID of the approving waiter.
     *@return waiterID
     */
    public void setWaiterID(int waiterID) {
        this.waiterID = waiterID;
    }

    /**
    *Retrieves the booking ID.
    *@return bookingID
    */
    public int getBookingID() {
        return bookingID;
    }

    /**
    *retrieves the number of guests in the booking
    *@return numberOfGuests
    */
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
    *Updates and returns new value for the number of guests in a booking.
    *@param newGuestNumber The new number of guests in the booking.
    *@return new numberOfGuests
    */
    public int setNumberOfGuests(final int newGuestNumber) {
        if (newGuestNumber > 0) {
            numberOfGuests = newGuestNumber;
        }
        return numberOfGuests;
    }

    /**
    *Retrieves the length of the booking in hours.
    *@return bookingLength in hours
    */
    public int getBookingLength() {
        return bookingLength;
    }

    /**
    *Updates and returnes the length of the booking.
    *@param newBookingLength The new length of the booking in hours.
    *@return new bookingLength in hours
    */
    public int setBookingLength(int newBookingLength) {
        if (newBookingLength >= 1){
            bookingLength = newBookingLength;
        }
        return bookingLength;
    }

    /**
    *Retrieves the date and time of the booking.
    *@return date and time of the booking.
    */
     public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    /**
    *Updates and returns the date and time of the booking but only if the time is later than the current date and time.
    *@param newBookingTime The new date and time of the booking
    *@return the updated date and time of the booking.
    */
    public LocalDateTime setBookingTime(LocalDateTime newBookingTime) {
        if (newBookingTime.isAfter(bookingTime)) {
            return bookingTime;
        }
        throw new RuntimeException("Booking times must be in the future.");
    }
    
    /**
    *Returns the status of the booking, true for approved, false for not approved.
    *@return the status of the booking, whether it has been approved or not.
    */
    public boolean getApproved() {
        return approved;
    }

    /**
    *Updates the status of the booking based on if it has been accepted or declined.
    *@param newApproved the new status for the booking.
    *@return new status of the booking.
    */
    public boolean approveBooking(boolean newApproved) {
        approved = newApproved;
        if (approved == true) {
            notifyAcceptance();
        }
        if (approved == false) {
            notifyDeclined();
        }
        return approved;
    }

    /**
    *Retrieves the customer ID that is associated with the booking.
    *@return the customerID
    */
    public int getCustomerID() {
        return customerID;
    }

    /**
    *Notifies of the acceptance of the booking.
    *@return a message stating that the booking has been accepted.
    */
    private String notifyAcceptance() {
        String accepted = "Booking has been accepted.";
        return accepted;
    }

    /**
    *Notifies that the booking has been declined.
    *@return a message stating that the booking has been declined.
    */
    private String notifyDeclined() {
        String declined = "Booking has been declined.";
        return declined;
    }

    //table assignment?? who is making table?? are we making table? do we need to?


}
