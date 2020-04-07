package FoodPlace;
import java.time.LocalDateTime;

abstract public class Orders {
    private int orderId;
    private String status;
    private LocalDateTime dateTime;
    private Object[][] orderItems;
    public Orders(Object[][] items){
        status = "Not Completed";
        dateTime = new LocalDateTime.now();
        orderItems = items;
        //save the staff to the db
        //get orderId
        orderId = -1;//get data from db
    }

    public double orderTotal(){
        double sum = 0 ;
        for(Object[] item: orderItems){
            sum += (Double) item[2];
        }
        return sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] printReceipt(){
        String[] receipt = new String[orderItems.length+1];
        int count = 0;
        for(Object[] item: orderItems){
            MenuItem menuItem = (MenuItem) item[0];
            String itemDetails = menuItem.getDescription()+","+menuItem.getUnitPrice()
                    +","+ (Double) item[2];
            receipt[count++] = itemDetails;
        }
        receipt[count] = ""+orderTotal();
        return receipt;
    }

}





