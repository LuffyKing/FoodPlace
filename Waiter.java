package FoodPlace;

import javafx.collections.ObservableList;

public class Waiter extends Staff{
    public Waiter(String fname,
                  String lname,
                  int hoursToWork,
                  String sType,
                  int sId,
                  String uname,
                  String pword
                  ){
        super(fname,
                lname,
                hoursToWork,
                sType,
                sId,
                uname,
                pword);
    }

    public Waiter(String fname,
                  String lname,
                  int hoursToWork,
                  String sType,
                  int sId,
                  String uname,
                  String pword,
                  int hWorked
    ){
        super(fname,
                lname,
                hoursToWork,
                sType,
                sId,
                uname,
                pword,
                hWorked);
    }
    public void approveDelivery(Delivery delivery){
        if (!delivery.getApprovalStatus()) {
            delivery.setApproved(true);
        }
        else{
            throw new RuntimeException("Delivery has already been approved");
        }
    }

    public void addOrderEatIn(ObservableList<OrderItem> items, ObservableList<Order> orders){
        orders.add(new EatIn(items, ord));
    }
    public void removeOrderEatIn(int orderId,ObservableList<Order> orders){
        orders.removeIf(anOrder -> (anOrder.getOrderId() == orderId));
    }
    public void editOrderEatIn(Order order, ObservableList<OrderItem> orders, MenuItem[] menuItems){
        orders.editOrder(order.getOrderId(), menuItems);
    }
    public void approveBooking(Booking booking){
        booking.approveBooking(true);
    }

    public void disapproveBooking(Booking booking){
        booking.approveBooking(false);
    }

}