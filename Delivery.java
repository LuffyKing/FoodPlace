package FoodPlace;

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

/**
*This class represents the delivery type of order.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Delivery extends Order {
    private String deliveryStatus;
    private String deliveryAddress;
    private LocalDateTime estimatedDeliveryTime;
    private boolean isApproved;
    private int driverId;

    /**
    *Constructor for a delivery order.
    *@param item The list of items in the order.
    *@param orderId The order Id.
    *@param dateTime The date and time the order was created.
    *@param customerId The Id of the customer who made the order.
    *@param isComplete The completion status of the order.
    *@param address The delivery address.
    *@param driverId The Id of the driver who is associated with the order.
    */
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
        estimatedDeliveryTime = LocalDateTime.now().plusMinutes(45);
        isApproved = false;
        this.driverId = driverId;
    }

    /**
    *Constructor for a delivery order with delivery status, approval status & estimated delivery time.
    *@param item The list of items in the order.
    *@param orderId The order Id.
    *@param dateTime The date and time the order was created.
    *@param customerId The Id of the customer who made the order.
    *@param isComplete The completion status of the order.
    *@param address The delivery address.
    *@param driverId The Id of the driver who is associated with the order.
    *@param deliveryStatus The delivery status for the order.
    *@param isApproved The approval status of the order.
    *@param edt The estimated delivery time of the order.
    */
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



    /**
    *Updates the approval status for the delivery order.
    *@param approved The new approval status.
    */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    /**
    *Returns the approval status of the delivery.
    *@return The approval status of the delivery.
    */
    public boolean getApprovalStatus() {
        return isApproved;
    }

    /**
    *Returns the estimated delivery time.
    *@return The estimated delivery time.
    */
    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    /**
    *Returns the delivery address.
    *@return The delivery address.
    */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
    *Updates the delivery address for the delivery.
    *@param deliveryAddress The new delivery address.
    */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
    *Updates the delivery status for the delivery order.
    *@param status The new delivery status.
    */
    public void setDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

    /**
    *Returns the delivery status for the delivery.
    *@return The delivery status.
    */
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
    *Function to assign a driver to an approved delivery order.
    *@param driverId The Id of the driver assigned to the order.
    */
    public void setDriver(int driverId) {
        if (isApproved) {
            this.driverId = driverId;
        }
        else{
            throw new RuntimeException("Delivery drivers can only be assigned to approved deliveries");
        }
    }

    /**
    *Returns the Id of the delivery driver assigned to the delivery.
    *@return The delivery driverId.
    */
    public int getDriver() {
        return driverId;
    }
}
