package sample;

public class Booking {
    public static final int defaultBookingLength = 1;

    private final int bookingID;
    private int numberOfGuests;
    //private ??? timeOfBooking;
    private int bookingLength;
    private boolean approved;
    private final int customerID;

    public Booking(final int bookingID_, int numberOfGuests_, int bookingLength_, boolean approved_, final int customerID_){
        bookingID = bookingID_;
        numberOfGuests = numberOfGuests_;
        bookingLength = bookingLength_;
        approved = approved_;
        customerID = customerID_;
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

    public boolean getApproved() {
        return approved;
    }

    public boolean setApproved(boolean newApproved) {
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
