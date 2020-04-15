package FoodPlace;

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

    public double getTotal() {
        return quantity * getUnitPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getLineItemId() {
        return lineItemId;
    }
}
