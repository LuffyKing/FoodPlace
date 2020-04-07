package FoodPlace;

import java.time.LocalDateTime;

public class Takeaway extends Order{

    private LocalDateTime pickupTime;
    private boolean pickupStatus;
    private boolean collectionStatus;
    Takeaway(MenuItem[] items, LocalDateTime ptime){
        super(items);
        LocalDateTime pickupTime = ptime;
        collectionStatus = false;
    }

    public boolean getCollectionStatus() {
        return collectionStatus;
    }

    public void setSetCollectionStatus(boolean status) {
        this.collectionStatus = status;
    }

    public boolean getPickupStatus() {
        return pickupStatus;
    }

    public void setPickupStatus(boolean status) {
        this.pickupStatus = status;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }
}
