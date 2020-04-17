package FoodPlace;

import javafx.collections.ObservableList;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
*This calss represents the waiter type of staff and the functions that are specific to them.
*author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Waiter extends Staff{
    
    /**
    *Constructor for the waiter.
    *@param fname The first name.
    *@param lname The last name.
    *@param hoursToWork The number of hours they need to work.
    *@param sType The staff type (waiter).
    *@param sId The staff Id.
    *@param uname The waiter's username.
    *@param pword The waiter's password.
    */
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

    /**
    *Constructor for the waiter including the number of hours that have been worked.
    *@param fname The first name.
    *@param lname The last name.
    *@param hoursToWork The number of hours they need to work.
    *@param sType The staff type (waiter).
    *@param sId The staff Id.
    *@param uname The waiter's username.
    *@param pword The waiter's password.
    *@param hWorked The number of hours worked.
    */
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
    
    /**
    *Approves a delivery order.
    *@param delivery The delivery whose status to update.
    */
    public void approveDelivery(Delivery delivery){
        if (!delivery.getApprovalStatus()) {
            delivery.setApproved(true);
        }
        else{
            throw new RuntimeException("Delivery has already been approved");
        }
    }

    /**
    *Creates an eat in order.
    *@param items The list of items in the order.
    *@param orderId The order id.
    *@param dateTime The date and time of the order.
    *@param customerId The Id of the customer the order is associated with.
    *@param isComplete The completion status of the order.
    *@param waiterId The Id of the waiter who made the order.
    *@param orders The list of order the order will be added to.
    */
    public void addOrderEatIn(ObservableList<OrderItem> items,
                              int orderId,
                              LocalDateTime dateTime,
                              int customerId,
                              boolean isComplete,
                              int waiterId,
                              ObservableList<Order> orders){
        orders.add(new EatIn(items, orderId, dateTime, customerId, isComplete, waiterId));
    }
    
    /**
    *Deletes a specific eat in order.
    *@param orderId The order Id of the order to be deleted.
    *@param orders The list from which the order will be removed.
    */
    public void removeOrderEatIn(int orderId,ObservableList<Order> orders){
        orders.removeIf(anOrder -> (anOrder.getOrderId() == orderId));
    }
    
    /**
    *Function to edit and eat in order.
    *@param eatin The eat in order to be edited.
    *@param items The list of items in the order.
    *@param dateTime The date and time of the order.
    *@param isComplete The completion status of the order.
    *@param waiterId The waiter associated with the order.
    */
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
    
    /**
    *Function to approve a booking.
    *@param booking The booking to be approved.
    */
    public void approveBooking(Booking booking){
        booking.approveBooking(true);
    }

    /**
    *Function to decline a booking.
    *@param booking The booking to be declined.
    */
    public void disapproveBooking(Booking booking){
        booking.approveBooking(false);
    }

}
