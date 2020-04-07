package FoodPlace;

import java.time.LocalDateTime;

public class Delivery extends Order {
    private String deliveryStatus;
    private String deliveryAddress;
    private LocalDateTime estimatedDeliveryTime;
    private boolean isApproved;
    private Driver driver;
    private static long deliveryTime = 45;
    Delivery(MenuItem[] item, String address){
        super(item);
        deliveryStatus = "Not Started";
        deliveryAddress = address;
        estimatedDeliveryTime = LocalDateTime.now().plusMinutes(deliveryTime);
        isApproved = false;
    }

    public static void setDeliveryTime(long time){
        deliveryTime = time;
    }

    public static long getDeliveryTime(long time){
        return deliveryTime;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean getApprovalStatus() {
        return isApproved;
    }


    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDriver(Driver driver) {
        if (isApproved) {
            this.driver = driver;
        }
        else{
            throw new RuntimeException("Delivery drivers can only be assigned to approved deliveries");
        }
    }

    public Driver getDriver() {
        return driver;
    }
}
