package FoodPlace;

import java.time.LocalDateTime;
import javafx.collections.ObservableList;

/**
*This class represents a customer who is a person and all the functions specific to them.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Customer extends Person{
    private String address;
    private int customerId;

    /**
    *Constructor for the customer, some details obtained from person class.
    *@param fname The first name of the customer.
    *@param lname The last name of the customer.
    *@param add The customer address.
    *@param cid The customer Id.
    */
    public Customer(String fname, String lname, String add, int cid) {
        super(fname, lname);
        address = add;
        // get after DB save
        customerId = cid;
    }

    /**
    *Returns the customer Id
    *@return The customer Id.
    */
    public int getCustomerId() {
        return customerId;
    }

    /**
    *Updates the customer Id.
    *@param customerId The new customer Id
    */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
    *Returns the customer's address.
    *@return The customer's address.
    */
    public String getAddress() {
        return address;
    }

    /**
    *Updates a customer's address.
    *@param add The customer's address.
    */
    public void setAddress(String add) {
        address = add;
    }

    /**
    *Creates a new delivery order.
    *@param items A list of items in the order.
    *@param orderId The Id of the order.
    *@param dateTime The date and time of the order.
    *@param orders The list of orders to add the order to.
    */
    public void addOrderDelivery(ObservableList<OrderItem> items, int orderId, LocalDateTime dateTime, ObservableList<Order> orders){
        Delivery delivery = new Delivery(items, orderId, dateTime, customerId,false, address, 0);
        orders.add(delivery);
    }
    
    /**
    *Removes an order from the order list.
    *@param order The order to be removed.
    *@param orders The list from whichthe order will be removed.
    */
    public void removeOrder(Order order, ObservableList<Order> orders){
        orders.removeIf(anOrder -> order.getOrderId() == anOrder.getOrderId());
    }
    
    /**
    *Function to edit a delivery order.
    *@param delivery The delivery order to be edited.
    *@param items The list of items in the order.
    *@param address The delivery address.
    */
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
    
    /**
    *Function to create a takeaway order.
    *@param items The list of items in the order.
    *@param orderId The order ID.
    *@param dateTime The date and time of the order.
    *@param ptime The pickup time.
    *@param orders The order list the order will be added to.
    */
    public void addOrderTakeAway(ObservableList<OrderItem> items, int orderId, LocalDateTime dateTime ,LocalDateTime ptime, ObservableList<Order> orders){
        Takeaway takeaway = new Takeaway(items, orderId, dateTime, customerId, false,ptime, false);
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

    /**
    *The function to create a booking.
    *@param numberOfGuests_ The number of guests in the booking.
    *@param bookingTime_ The date and time the booking is for.
    *@param bookingList The list the booking will be added to.
    *@param bookingLength_ The length of the booking in hours.
    *@param bookingId The booking ID.
    */
    public void createBooking(int numberOfGuests_, int bookingLength_, LocalDateTime bookingTime_, ObservableList<Booking> bookingList, int bookingId){
        Booking booking = new Booking(numberOfGuests_, bookingLength_, bookingTime_, customerId, bookingId);
        bookingList.add(booking);
    }
    
    /**
    *Function to cancel a booking.
    *@param booking The booking to be cancelled.
    *@param bookinglist The list from which the booking will be deleted.
    */
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
