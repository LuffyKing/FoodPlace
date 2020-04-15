package FoodPlace;

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Delivery extends Order {
    private String deliveryStatus;
    private String deliveryAddress;
    private LocalDateTime estimatedDeliveryTime;
    private boolean isApproved;
    private int driverId;
    private static long deliveryTime = 45;
    public Delivery(ObservableList<OrderItem> item,
             int orderId,
             LocalDateTime dateTime,
             int customerId,
             boolean isComplete,
             String address,
             int driverId){
        super(item, orderId, dateTime, customerId, isComplete);
        deliveryStatus = "Not Started";
        deliveryAddress = address;
        estimatedDeliveryTime = LocalDateTime.now().plusMinutes(deliveryTime);
        isApproved = false;
        this.driverId = driverId;
    }

    public Delivery(ObservableList<OrderItem> item,
            int orderId,
            LocalDateTime dateTime,
            int customerId,
            boolean isComplete,
            String address,
            int driverId,
            String deliveryStatus,
            boolean isApproved,
            LocalDateTime edt){
        super(item, orderId, dateTime, customerId, isComplete);
        this.deliveryStatus = deliveryStatus;
        deliveryAddress = address;
        estimatedDeliveryTime = edt;
        this.isApproved = isApproved;
        this.driverId = driverId;
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

    public void setDriver(int driverId) {
        if (isApproved) {
            this.driverId = driverId;
        }
        else{
            throw new RuntimeException("Delivery drivers can only be assigned to approved deliveries");
        }
    }

    public int getDriver() {
        return driverId;
    }
}
