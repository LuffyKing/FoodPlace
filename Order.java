package FoodPlace;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setOrderItems(ObservableList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public ObservableList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double orderTotal(){
        double sum = 0 ;
        for(OrderItem item: orderItems){
            sum += item.getTotal();
        }
        return sum;
    }

    public boolean getCompletionStatus() {
        return isComplete;
    }

    public void setCompletionStatus(boolean status) {
        this.isComplete = status;
    }

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





