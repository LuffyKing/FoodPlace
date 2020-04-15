package FoodPlace;

import java.time.LocalDateTime;
import javafx.collections.ObservableList;

public class Customer extends Person{
    private String address;
    private int customerId;

    public Customer(String fname, String lname, String add, int cid) {
        super(fname, lname);
        address = add;
        // get after DB save
        customerId = cid;
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

    public void addOrderDelivery(ObservableList<OrderItem> items, int orderId, LocalDateTime dateTime, ObservableList<Order> orders){
        Delivery delivery = new Delivery(items, orderId, dateTime,address);
        orders.add(delivery);

    }
    public void removeOrder(Order order, ObservableList<Order> orders){
        orders.removeIf(anOrder -> order.getOrderId() == anOrder.getOrderId());
    }
    public void editOrderDelivery(Delivery delivery, ObservableList<OrderItem> items, String address){
        if(items != null){
            if (!delivery.getCompletionStatus()){
                delivery.setOrderItems(items);
            } else{
                throw new RuntimeException("Cannot edit an already completed order");
            }
        }
        if (address != null){
            if (delivery.getDeliveryStatus().equals("Not Started")){
                delivery.setDeliveryAddress(address);
            } else{
                throw new RuntimeException("Cannot edit a delivery that is in progress or has been completed");
            }
        }
    }
    public void addOrderTakeAway(ObservableList<OrderItem> items, int orderId, LocalDateTime dateTime ,LocalDateTime ptime, ObservableList<Order> orders){
        Takeaway takeaway = new Takeaway(items, orderId, dateTime, ptime);
        orders.add(takeaway);
    }
    public void editOrderTakeAway(Takeaway takeaway, ObservableList<OrderItem> items, LocalDateTime ptime){
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


    public void createBooking(int numberOfGuests_, int bookingLength_, LocalDateTime bookingTime_, ObservableList<Booking> bookingList, int bookingId){
        Booking booking = new Booking(numberOfGuests_, bookingLength_, bookingTime_, customerId, bookingId);
        bookingList.add(booking);
    }
    public void cancelBooking(Booking booking, ObservableList<Booking> bookingList){
        bookingList.removeIf(aBooking -> aBooking.getBookingID() == booking.getBookingID());
    }
    public void editBooking(Booking booking, int numberOfGuests, int bookingLength, LocalDateTime bookingTime_){
        if (booking == null){
            throw new RuntimeException("Booking does not exist!");
        }
        if (bookingTime_ == null){
            throw new RuntimeException("Booking time does not exist!");
        }
        if (numberOfGuests > 0){
            booking.setNumberOfGuests(numberOfGuests);
        }
        if (bookingLength > 0){
            booking.setBookingLength(bookingLength);
        }
        if (bookingTime_.isAfter(LocalDateTime.now().minusMinutes(1))){
            booking.setBookingTime(bookingTime_);
        }
    }
}
