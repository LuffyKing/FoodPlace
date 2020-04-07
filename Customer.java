package FoodPlace;

import java.time.LocalDateTime;

public class Customer extends Person{
    private String address;
    private int customerId;

    public Customer(String fname, String lname, String add) {
        super(fname, lname);
        address = add;
        // get after DB save
        customerId = -1;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String add) {
        address = add;
    }

    public void addOrderDelivery(MenuItem[] items, OrdersList orders){
        Delivery delivery = new Delivery(items, address);
        orders.addOrderToList(delivery);

    }
    public void removeOrder(Order order, OrdersList orders){
        orders.removeOrder(order.getOrderId());
    }
    public void editOrderDelivery(Delivery delivery, MenuItem[] items, String address){
        if(items != null){
            if (!delivery.getCompletionStatus()){
                delivery.setOrderItems(items);
            } else{
                throw new RuntimeException("Cannot edit an already completed order");
            }
        }
        if (address != null){
            if (delivery.getDeliveryStatus() == "Not Started"){
                delivery.setDeliveryAddress(address);
            } else{
                throw new RuntimeException("Cannot edit a delivery that is in progress or has been completed");
            }
        }
    }
    public void addOrderTakeAway(MenuItem[] items, LocalDateTime ptime, OrdersList orders){
        Takeaway takeaway = new Takeaway(items, ptime);
        orders.addOrderToList(takeaway);
    }
    public void editOrderTakeAway(Takeaway takeaway, MenuItem[] items, LocalDateTime ptime){
        if(items != null){
            if (!takeaway.getCompletionStatus()){
                takeaway.setOrderItems(items);
            } else{
                throw new RuntimeException("Cannot edit an already completed order");
            }
        }
        if (ptime != null){
            if (!takeaway.getCollectionStatus()){
               takeaway.setPickupTime(ptime);
            } else{
                throw new RuntimeException("Cannot edit a take away order that has been picked up.");
            }
        }
    }


    public void createBooking(int numberOfGuests_, int bookingLength_, BookingList bookingList){
        Booking booking = new Booking(numberOfGuests_, bookingLength_, customerId);
        bookingList.addBookingToList(booking);
    }
    public void cancelBooking(Booking booking, BookingList bookingList){
        bookingList.removeBooking(booking.getBookingID());
    }
    public void editBooking(Booking booking, int numberOfGuests, int bookingLength,BookingList bookingList){
        bookingList.editBooking(booking.getBookingID(), numberOfGuests, bookingLength);
    }
}