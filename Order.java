package FoodPlace;

/**
*This class represents a staff member who is a chef and the functions specific to this worker type.
*@author Damola Aderinwale (JavaDoc by Haixin Wang)
*@version ?
*/

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

abstract public class Order {
    private int orderId;
    private boolean isComplete;
    private LocalDateTime dateTime;
    private ObservableList<OrderItem> orderItems;
    private String orderType;
    private int customerId;
    public Order(ObservableList<OrderItem> orderItems,
                 int orderId,
                 LocalDateTime dateTime,
                 int customerId,
                 boolean isComplete){
        this.dateTime = dateTime;
        this.orderItems = orderItems;
        this.orderId = orderId;//get data from db
        this.customerId = customerId;
        this.isComplete = isComplete;
    }
    
    /**
    *Returns the customer Id.
    *@return The customer Id.
    */
    public int getCustomerId() {
        return customerId;
    }
    
    /**
    *Updates the customer Id.
    *@param customerId The new customer Id.
    */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
        return orderId;
    }

    /**
    *Returns the order type.
    *@return The order id.
    */
    public String getOrderType() {
        return orderType;
    }

    /**
    *Updates the order type.
    *@param orderType The new order type.
    */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
    *Returns the date time.
    *@return The date time.
    */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
    *Updates the data time.
    *@param dateTime The new date time.
    */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
    *Function to count total order
    *@param orderTotal The total orders.
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
        return isComplete;
    }

    /**
    *Updates the status of whether complete or not.
    *@param isComplete The status of completion.
    */
    public void setCompletionStatus(boolean status) {
        this.isComplete = status;
    }

    /**
    *Function to print the recept with order items and unit price and total.
    *@param recept Get the new recept.
    *@param count The number count.
    *@param getName The order name.
    *@param getUnitPrice the order unit price.
    *@param getTotal the order total price.
    *@return The actual recept with order items and unit price and total.
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





