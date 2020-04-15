package FoodPlace;

public class Driver extends Staff{
    public Driver(String fname,
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

    public Driver(String fname,
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
    public void completeDelivery(Delivery delivery){
        delivery.setDeliveryStatus("Completed");
    }
    public void startDelivery(Delivery delivery){
        delivery.setDeliveryStatus("Started");
    }
}