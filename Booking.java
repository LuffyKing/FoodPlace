package FoodPlace;

import java.time.LocalDateTime;

public class Booking {

    private final int bookingID;
    private int numberOfGuests;
    private LocalDateTime bookingTime;
    private int bookingLength;
    private boolean approved;
    private final int customerID;

    public Booking(int numberOfGuests_, int bookingLength_, LocalDateTime bookingTime_, final int customerID_, int bookingID_){
        numberOfGuests = numberOfGuests_;
        bookingLength = bookingLength_;
        approved = false;
        bookingTime = bookingTime_;
        customerID = customerID_;
        bookingID = bookingID_;
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public int setNumberOfGuests(final int newGuestNumber) {
        if (newGuestNumber > 0) {
            numberOfGuests = newGuestNumber;
        }
        return numberOfGuests;
    }

    public int getBookingLength() {
        return bookingLength;
    }

    public int setBookingLength(int newBookingLength) {
        if (newBookingLength >= 1){
            bookingLength = newBookingLength;
        }
        return bookingLength;
    }

     public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public LocalDateTime setBookingTime(LocalDateTime newBookingTime) {
        if (newBookingTime.isAfter(bookingTime)) {
            return bookingTime;
        }
        throw new RuntimeException("Booking times must be in the future.");
    }
    
    public boolean getApproved() {
        return approved;
    }

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

    public int getCustomerID() {
        return customerID;
    }

    private String notifyAcceptance() {
        String accepted = "Booking has been accepted.";
        return accepted;
    }

    private String notifyDeclined() {
        String declined = "Booking has been declined.";
        return declined;
    }

    //table assignment?? who is making table?? are we making table? do we need to?


}
