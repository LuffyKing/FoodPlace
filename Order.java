package FoodPlace;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
*This class represents a staff member who is a chef and the functions specific to this worker type.
*@author Damola Aderinwale (JavaDoc by Haixin Wang)
*@version ?
*/

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

abstract public class Order {
    private SimpleIntegerProperty orderId;
    private SimpleBooleanProperty isComplete;
    private SimpleObjectProperty<LocalDateTime> dateTime;
    private ObservableList<OrderItem> orderItems;
    private SimpleStringProperty orderType;
    private SimpleIntegerProperty customerId;
    public Order(ObservableList<OrderItem> orderItems,
                 int orderId,
                 LocalDateTime dateTime,
                 int customerId,
                 boolean isComplete){
        this.dateTime = new SimpleObjectProperty<LocalDateTime>(dateTime);
        this.orderItems = orderItems;
        this.orderId = new SimpleIntegerProperty(orderId);//get data from db
        this.customerId = new SimpleIntegerProperty(customerId);
        this.isComplete = new SimpleBooleanProperty(isComplete);
    }



    /**
    *Returns the customer Id.
    *@return The customer Id.
    */
    public int getCustomerId() {
        return customerId.get();
    }
    
    /**
    *Updates the customer Id.
    *@param customerId The new customer Id.
    */
    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    /**
    *Updates the order items.
    *@param orderItems The new order items.
    */
    public void setOrderItems(ObservableList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
    *Returns the order item.
    *@return The order item.
    */
    public ObservableList<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
    *Returns the order id.
    *@return The order id.
    */
    public int getOrderId() {
        return orderId.get();
    }

    /**
    *Returns the order type.
    *@return The order id.
    */
    public String getOrderType() {
        return orderType.get();
    }

    /**
    *Updates the order type.
    *@param orderType The new order type.
    */
    public void setOrderType(String orderType) {
        this.orderType.set(orderType);
    }

    /**
    *Returns the date time.
    *@return The date time.
    */
    public LocalDateTime getDateTime() {
        return dateTime.get();
    }

    /**
    *Updates the data time.
    *@param dateTime The new date time.
    */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime.set(dateTime);
    }

    /**
    *Function to count total order
    */
    public double orderTotal(){
        double sum = 0 ;
        for(OrderItem item: orderItems){
            sum += item.getTotal();
        }
        return sum;
    }

    /**
    *Returns the status of whether complete or not.
    *@return The status of completion.
    */
    public boolean getCompletionStatus() {
        return isComplete.get();
    }

    /**
    *Updates the status of whether complete or not.
    *@param status The status of completion.
    */
    public void setCompletionStatus(boolean status) {
        this.isComplete.set(status);
    }

    /**
    *Function to print the receipt with order items and unit price and total.
    *@return The actual receipt with order items and unit price and total.
    */
    public String[] printReceipt(){
        String[] receipt = new String[orderItems.size()+1];
        int count = 0;
        for(OrderItem orderItem: orderItems){
            String itemDetails = orderItem.getName()+","+orderItem.getUnitPrice()
                    +","+ orderItem.getTotal();
            receipt[count++] = itemDetails;
        }
        receipt[count] = ""+orderTotal();
        return receipt;
    }

}





