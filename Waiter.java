package FoodPlace;

public class Waiter extends Staff{
    public Waiter(String fname, String lname, int hoursToWork){
        super(fname, lname, hoursToWork, "waiter");
    }
    public void approveDelivery(Delivery delivery){
        if (!delivery.getApprovalStatus()) {
            delivery.setApproved(true);
        }
        else{
            throw new RuntimeException("Delivery has already been approved");
        }
    }

    public void addOrderEatIn(MenuItem[] items, OrdersList orders){
        orders.addOrderToList(new EatIn(items));
    }
    public void removeOrderEatIn(Order order, OrdersList orders){
        orders.removeOrder(order.getOrderId());
    }
    public void editOrderEatIn(Order order, OrdersList orders, MenuItem[] menuItems){
        orders.editOrder(order.getOrderId(), menuItems);
    }
    public void approveBooking(Booking booking){
        booking.approveBooking(true);
    }

    public void disapproveBooking(Booking booking){
        booking.approveBooking(false);
    }

}