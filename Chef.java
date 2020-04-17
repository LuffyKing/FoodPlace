package FoodPlace;

public class Chef extends Staff{
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
    public void completeOrder(Order order) {
        order.setCompletionStatus(true);
    }

    public void addDailySpecial(Menu menu, String description,
                                double price, String category, int mId, String name){
        menu.createDailySpecial(description, price, category, mId, name);
    }

    public void removeDailySpecial(Menu menu, int menuItemId){
        menu.removeMenuItem(menuItemId);
    }

    public void editDailySpecial(Menu menu,MenuItem menuItem,  String description,
                                 double price, String category){
        menu.editMenuItem(menuItem, description, price, category);
    }

}