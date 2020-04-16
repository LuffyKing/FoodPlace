package FoodPlace;

/**
*This class represents a staff member who is a chef and the functions specific to this worker type.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class Chef extends Staff{
    
    /**
    *Constructor for creating a chef. Details are obtained from person class.
    *@param fname The first name.
    *@param lname The last name.
    *@param hoursToWork The number of hours the chef needs to work
    *@param sType The staff member type (chef).
    *@param sId The staff Id number.
    *@param uname The username of the chef.
    *@param pword The password of the chef.
    */
    public Chef(String fname,
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
    *Constructor for creating a chef containing the number of hours they have worked. Details are obtained from person class.
    *@param fname The first name.
    *@param lname The last name.
    *@param hoursToWork The number of hours the chef needs to work
    *@param sType The staff member type (chef).
    *@param sId The staff Id number.
    *@param uname The username of the chef.
    *@param pword The password of the chef.
    *@param hWorked The number of hours worked.
    */
    public Chef(String fname,
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
    *Function to allow the chef to mark an order as completed.
    *@param order The order being completed.
    */
    public void completeOrder(Order order) {
        order.setCompletionStatus(true);
    }

    /**
    *Function to add a daily special to the menu.
    *@param menu The menu
    *@param description The description of the special.
    *@param price The price of the special.
    *@param category The type of item the special is.
    *@param mId The menu Id of the special.
    */
    public void addDailySpecial(Menu menu, String description,
                                double price, String category, int mId){
        menu.createDailySpecial(description, price, category, mId);
    }

    /**
    *Function to remove a daily special from the menu.
    *@param menu The menu
    *@param menuItemId The Id of the item to be removed.
    */
    public void removeDailySpecial(Menu menu, int menuItemId){
        menu.removeMenuItem(menuItemId);
    }

    /**
    *Function to edit a daily special.
    *@param menu The menu.
    *@param MenuItem The item on the menu.
    *@param description The description of the item.
    *@param price The price of the item.
    *@param category The item category.
    */
    public void editDailySpecial(Menu menu,MenuItem menuItem,  String description,
                                 double price, String category){
        menu.editMenuItem(menuItem, description, price, category);
    }

}
