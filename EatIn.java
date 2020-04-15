package FoodPlace;

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class EatIn extends Order {
    private int waiterId;
    public EatIn(ObservableList<OrderItem> items,
                 int orderId,
                 LocalDateTime dateTime,
                 int customerId,
                 boolean isComplete,
                 int waiterId){
        super(items, orderId, dateTime, customerId, isComplete);
        setOrderType("Eat In");
        this.waiterId = waiterId;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }
}
