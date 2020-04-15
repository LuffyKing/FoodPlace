package FoodPlace;

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Takeaway extends Order{

    private LocalDateTime pickupTime;
    private boolean collectionStatus;
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

    public boolean getCollectionStatus() {
        return collectionStatus;
    }

    public void setSetCollectionStatus(boolean status) {
        this.collectionStatus = status;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }
}
