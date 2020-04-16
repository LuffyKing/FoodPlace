package FoodPlace;

/**
*This class represents the delivery driver staff type and the functiond specific to them.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Driver extends Staff{
    
    /**
    *Contructor for the delivery driver.
    *@param fname First Name.
    *@param lname Last Name.
    *@param hoursToWork The number of hours the driver needs to work.
    *@param sType The staff type (driver).
    *@param sId The staff Id.
    *@param uname The driver's username.
    *@param pword The driver's password.
    */
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
    
    /**
    *Contructor for the delivery driver including the number of hours worked.
    *@param fname First Name.
    *@param lname Last Name.
    *@param hoursToWork The number of hours the driver needs to work.
    *@param sType The staff type (driver).
    *@param sId The staff Id.
    *@param uname The driver's username.
    *@param pword The driver's password.
    *@param hWorked The number of hours worked.
    */
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
    
    /**
    *Function to mark the delivery as being completed.
    *@param delivery The delivery order to be updated.
    */
    public void completeDelivery(Delivery delivery){
        delivery.setDeliveryStatus("Completed");
    }
    
    /**
    *Function to mark the delivery as underway.
    *@param delivery The delivery order to be updated.
    */
    public void startDelivery(Delivery delivery){
        delivery.setDeliveryStatus("Started");
    }
}
