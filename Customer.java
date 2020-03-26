package FoodPlace;

public class Customer extends Person{
    private String address;
    private static int count = 0;
    private int customerId;

    public Customer(String fname, String lname, String add) {
        super(fname, lname);
        address = add;
        customerId = count++;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String add) {
        address = add;
    }

    public void addOrderDelivery(){

    }
    public void removeOrderDelivery(int orderId){

    }
    public void editOrderDelivery(int orderId){

    }
    public void addOrderTakeAway(){

    }
    public void editOrderTakeAway(int orderId){

    }
    public void removeOrderTakeAway(int orderId){

    }
    public void addEvent(int eventId){

    }
    public void removeEvent(int eventId){

    }
    public void editEvent(int eventId){

    }
    public void registerEvent(){

    }
    public void createBooking(){

    }
    public void cancelBooking(int bookingId){

    }
    public void editBooking(int bookingId){

    }
}