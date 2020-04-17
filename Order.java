package FoodPlace;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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


    public int getCustomerId() {
        return customerId.get();
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public void setOrderItems(ObservableList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public ObservableList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int getOrderId() {
        return orderId.get();
    }

    public String getOrderType() {
        return orderType.get();
    }

    public void setOrderType(String orderType) {
        this.orderType.set(orderType);
    }

    public LocalDateTime getDateTime() {
        return dateTime.get();
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime.set(dateTime);
    }

    public double orderTotal(){
        double sum = 0 ;
        for(OrderItem item: orderItems){
            sum += item.getTotal();
        }
        return sum;
    }

    public boolean getCompletionStatus() {
        return isComplete.get();
    }

    public void setCompletionStatus(boolean status) {
        this.isComplete.set(status);
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





