package FoodPlace;
import java.time.LocalDateTime;

abstract public class Order {
    private int orderId;
    private boolean isComplete;
    private LocalDateTime dateTime;
    private MenuItem[] orderItems;
    private String orderType;
    public Order(MenuItem[] items){
        isComplete = false;
        dateTime = LocalDateTime.now();
        orderItems = items;
        //save the staff to the db
        //get orderId
        orderId = -1;//get data from db
    }

    public void setOrderItems(MenuItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public MenuItem[] getOrderItems() {
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

    public double orderTotal(){
        double sum = 0 ;
        for(MenuItem item: orderItems){
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
        String[] receipt = new String[orderItems.length+1];
        int count = 0;
        for(MenuItem menuItem: orderItems){
            String itemDetails = menuItem.getDescription()+","+menuItem.getUnitPrice()
                    +","+ menuItem.getTotal();
            receipt[count++] = itemDetails;
        }
        receipt[count] = ""+orderTotal();
        return receipt;
    }

}





