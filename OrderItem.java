package FoodPlace;

/**
*This class represents the delivery type of order.
*@author Damola Aderinwale (JavaDoc by Haixin Wang)
*@version ?
*/

public class OrderItem extends MenuItem {
    private int quantity;
    private int orderId;
    private int lineItemId;
    public OrderItem(String desc,
                     double unitP,
                     String cat,
                     int mId,
                     String nameVar,
                     int oId,
                     int lId){
        super(desc, unitP, cat, mId, nameVar);
        orderId = oId;
        lineItemId = lId;
        quantity = 0;
    }
    
    /**
    *Constructor for a order item.
    *@param desc The item.
    *@param unitP The unit price.
    *@param cat The category.
    *@param mId The menu item id.
    *@param nameVar The name.
    *@param oId The older id.
    *@param lId The line item id.
    *@param quant The quantity.
    *@param special The special items.
    */
    public OrderItem(String desc,
              double unitP,
              String cat,
              int mId,
              String nameVar,
              int oId,
              int lId,
              int quant,
              boolean special){
        super(desc,
                unitP,
                cat,
                mId,
                nameVar,
                special);
        orderId = oId;
        lineItemId = lId;
        quantity = quant;
    }

    /**
    *Returns the delivery time (order placed time + 45 minutes).
    *@return The delivery time.
    */
    public double getTotal() {
        return quantity * getUnitPrice();
    }

    /**
    *Returns the item quantity.
    *@return The item quantity.
    */
    public int getQuantity() {
        return quantity;
    }

    /**
    *Updates the item quantity.
    *@param quantity The item quantity.
    */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
    *Returns the order id.
    *@return The order id.
    */
    public int getOrderId() {
        return orderId;
    }

    /**
    *Returns the line item id.
    *@return The line item id.
    */
    public int getLineItemId() {
        return lineItemId;
    }
}
