package FoodPlace;

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

/**
*This class represents a takeaway type of order.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Takeaway extends Order{
    private LocalDateTime pickupTime;
    private boolean collectionStatus;
   
    /**
    *Constructor for a takeaway order.
    *@param items A list of items in the takeaway order.
    *@param orderId The order Id.
    *@param dateTime The date and time of the order.
    *@param customerId The Id of the customer who made the order.
    *@param isCompleted The completion status of the takeaway order.
    *@param ptime The pickup time of the order.
    */
    public Takeaway(ObservableList<OrderItem> items,
             int orderId,
             LocalDateTime dateTime,
             int customerId,
             boolean isCompleted,
             LocalDateTime ptime){
        super(items, orderId, dateTime, customerId, isCompleted);
        pickupTime = ptime;
        collectionStatus = false;
    }

    /**
    *Constructor for a takeaway order with collection status included.
    *@param items A list of items in the takeaway order.
    *@param orderId The order Id.
    *@param dateTime The date and time of the order.
    *@param customerId The Id of the customer who made the order.
    *@param isCompleted The completion status of the takeaway order.
    *@param ptime The pickup time of the order.
    *@param cStatus The collection status of the order.
    */
    public Takeaway(ObservableList<OrderItem> items,
             int orderId,
             LocalDateTime dateTime,
             int customerId,
             boolean isCompleted,
             LocalDateTime ptime,
             boolean cStatus){
        super(items, orderId, dateTime, customerId, isCompleted);
        pickupTime = ptime;
        collectionStatus = cStatus;
    }

    /**
    *Returns the collection status.
    *@return The collection status.
    */
    public boolean getCollectionStatus() {
        return collectionStatus;
    }

    /**
    *Updates the collection status of the takeaway order.
    *@param status The new collection status.
    */
    public void setSetCollectionStatus(boolean status) {
        this.collectionStatus = status;
    }

    /**
    *Returns the pickup time for the takeaway order.
    *@return The pickup time.
    */
    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    /**
    *Updates the pickup time for the takeaway order.
    *@param pickupTime The new pickup time.
    */
    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }
}
