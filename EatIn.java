package FoodPlace;

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

/**
*This class represents the eat in order type.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class EatIn extends Order {
    private int waiterId;
  
    /**
    *Constructor for an eat in order.
    *@param items A list of items in the eat in order.
    *@param orderId The order Id.
    *@param dateTime The date and time of the eat in order.
    *@param customerId The customer Id associated with the eat in order.
    *@param isComplete The completion status of the eat in order.
    *@param waiterId The Id of the waiter who created the eat in order.
    */
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

    /**
    *Returns the waiter Id associated with the eat in order.
    *@return The waiter Id.
    */
    public int getWaiterId() {
        return waiterId;
    }

    /**
    *Updates the waiter Id associated with the eat in order.
    *@param waiterId The waiter Id.
    */
    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }
}
