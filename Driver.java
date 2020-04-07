package FoodPlace;

public class Driver extends Staff{
    public Driver(String fname, String lname, int hoursToWork){
        super(fname, lname, hoursToWork, "driver");
    }
    public void completeDelivery(Delivery delivery){
        delivery.setDeliveryStatus("Completed");
    }
    public void startDelivery(Delivery delivery){
        delivery.setDeliveryStatus("Started");
    }
}