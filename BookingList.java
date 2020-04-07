package FoodPlace;

public class BookingList {
    private Booking[] bookings;
    private int index;
    BookingList(){
        bookings = new Booking[50];
        index = 0;
    }
    BookingList(Booking[] bookings){
        this.bookings = bookings;
        index = bookings.length - 1;
    }

    public void addBookingToList(Booking booking){
        if (index >= bookings.length - 1) {
            resize(bookings.length*2);
        }
        bookings[index++] = booking;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }

    public void resize(int newLength){
        Booking[] newArr = new Booking[newLength];
        for (int i = 0; i < bookings.length; i++) {
            newArr[i] = bookings[i];
        }
        bookings = newArr;
    }

    public void removeBooking(int bookingId){
        for (int i = 0; i < bookings.length; i++) {
            if(bookings[i].getBookingID() == bookingId){
                Booking[] newArr = new Booking[bookings.length-1];
                int count = 0;
                for (int j = 0; j < bookings.length; j++) {
                    if (j != i){
                        newArr[count++] = bookings[j];
                    }
                }
                bookings = newArr;
                // delete from db
                break;
            }
        }
    }

    public void editBooking(int bookingId,  int numberOfGuests_, int bookingLength_){
        for (int i = 0; i < bookings.length; i++) {
            if(bookings[i].getBookingID() == bookingId){
                if (!bookings[i].getApproved()){
                    if (numberOfGuests_ > 0 ) {
                        bookings[i].setNumberOfGuests(bookingLength_);
                    }
                    if (bookingLength_ > 0){
                        bookings[i].setBookingLength(bookingLength_);
                    }

                } else{
                    throw new RuntimeException("Cannot edit an already approved booking");
                }

                // update from db
                break;
            }
        }
    }
    
}
