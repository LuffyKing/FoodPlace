package FoodPlace;

/**
*This class represents notifications which have an Id, description, and associated customer.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Notification {
    private final int id;
    private final String text;
    private final int customerId;
    
    /**
    *Constructor for a notification.
    *@param id The ID of the notification.
    *@param text The notification message.
    *@param customerId The Id of the associated customer.
    */
    public Notification(int id, String text, int customerId){
        this.id = id;
        this.text = text;
        this.customerId = customerId;
    }

    /**
    *Returns the customer Id associated with the notification.
    *@return The customer Id.
    */
    public int getCustomerId() {
        return customerId;
    }

    /**
    *Returns the Id of the notification.
    *@return The notification Id.
    */
    public int getId() {
        return id;
    }

    /**
    *Retruns the notification text.
    *@return The notification text.
    */
    public String getText() {
        return text;
    }
}
