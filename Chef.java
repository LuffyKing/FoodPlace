package FoodPlace;

public class Chef extends Staff{
    public Chef(String fname, String lname, int hoursToWork){
        super(fname, lname, hoursToWork, "chef");
    }
    public void completeOrder(Order order) {
        order.setCompletionStatus(true);
    }

    public void addDailySpecial(Menu menu, String description,
                                double price, String category){
        menu.createDailySpecial(description, price, category);
    }

    public void removeDailySpecial(Menu menu, int menuItemId){
        menu.removeMenuItem(menuItemId);
    }

    public void editDailySpecial(Menu menu, int menuItemId,  String description,
                                 double price, String category){
        menu.editMenuItem(menuItemId, description, price, category);
    }

}