package FoodPlace;

import javafx.collections.ObservableList;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Waiter extends Staff{
    public Waiter(String fname,
                  String lname,
                  int hoursToWork,
                  String sType,
                  int sId,
                  String uname,
                  String pword
                  ){
        super(fname,
                lname,
                hoursToWork,
                sType,
                sId,
                uname,
                pword);
    }

    public Waiter(String fname,
                  String lname,
                  int hoursToWork,
                  String sType,
                  int sId,
                  String uname,
                  String pword,
                  int hWorked
    ){
        super(fname,
                lname,
                hoursToWork,
                sType,
                sId,
                uname,
                pword,
                hWorked);
    }
    public void approveDelivery(Delivery delivery){
        if (!delivery.getApprovalStatus()) {
            delivery.setApproved(true);
        }
        else{
            throw new RuntimeException("Delivery has already been approved");
        }
    }

    public void addOrderEatIn(ObservableList<OrderItem> items,
                              int orderId,
                              LocalDateTime dateTime,
                              int customerId,
                              boolean isComplete,
                              int waiterId,
                              ObservableList<Order> orders){
        orders.add(new EatIn(items, orderId, dateTime, customerId, isComplete, waiterId));
    }
    public void removeOrderEatIn(int orderId,ObservableList<Order> orders){
        orders.removeIf(anOrder -> (anOrder.getOrderId() == orderId));
    }
    public void editOrderEatIn(EatIn eatin,
                               ObservableList<OrderItem> items,
                               LocalDateTime dateTime,
                               boolean isComplete,
                               int waiterId){
        eatin.setCompletionStatus(isComplete);
        if (items != null) {
            eatin.setOrderItems(items);
        }
        if (waiterId > 0) {
            eatin.setWaiterId(waiterId);
        }
        if (dateTime != null){
            eatin.setDateTime(dateTime);
        }
    }
    public void approveBooking(Booking booking){
        booking.approveBooking(true);
    }

    public void disapproveBooking(Booking booking){
        booking.approveBooking(false);
    }

}