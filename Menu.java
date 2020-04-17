package FoodPlace;

import javafx.collections.ObservableList;

/**
*This class represents the menu which is a list of menu items.
*@author Damola Aderinwale (JavaDoc by Haixin Wang & Sara Philipson)
*@version ?
*/

public class Menu {
    private ObservableList<MenuItem> menuItems;
    /**
    *Constructor for the menu.
    *@param menuItems The item on menu.
    */
    public Menu(ObservableList<MenuItem> items){
        menuItems = items;
    }

    /**
    *Returns the menu items.
    *@return The menu items.
    */
    public ObservableList<MenuItem> getMenuItems() {
        return menuItems;
    }
    
    /**
    *Function to check menu item id and return if match.
    *@param menuItemId The menu item id.
    *@return The found menu items.
    */
    public MenuItem getMenuItem(int menuItemId){
        MenuItem foundMenuItem = null;
        for (MenuItem menuItem:
             menuItems) {
            if (menuItem.getMenuItemId() == menuItemId){
                foundMenuItem = menuItem;
            }
        }
        return  foundMenuItem;
    }

    /**
    *Function to check for a duplicate item by check description and category.
    *@param description The description.
    *@param category The category.
    *@return True or false depending on if it is a duplicate or not.
    */
    public boolean isDuplicate(String description, String category){
        for (MenuItem item:
             menuItems) {
            if(item.getDescription().equals(description) && item.getCategory().equals(category)){
                return true;
            }
        }
        return false;
    }

    /**
    *Function to check for a duplicate item by checking against the description, category & exception id.
    *@param description The description.
    *@param category The category.
    *@param exceptionId The exception Id.
    *@return True or false depending on if it is a duplicate or not.
    */
    public boolean isDuplicate(String description, String category, int exceptionId){
        for (MenuItem item:
                menuItems) {
            if(item.getDescription().equals(description) && item.getCategory().equals(category)
                    && exceptionId != item.getMenuItemId()){
                return true;
            }
        }
        return false;
    }

    /**
    *Function to add a new menu item to the menu.
    *@param description The description.
    *@param price The price.
    *@param category The category.
    *@param mId The menu id.
    *@param name The name.
    *@return The new menu item.
    */
    public MenuItem addMenuItem(String description, double price, String category, int mId, String name){
        if (!isDuplicate(description, category)){
            MenuItem item = new MenuItem(description, price, category, mId, name);
            menuItems.add(item);
            return item;
            // save to db
        } else {
            throw new RuntimeException("The menu item already exists");
        }
    }

    /**
    *Function to remove menu item from the menu.
    *@param menuItemId The menu item id.
    */
    public void removeMenuItem(int menuItemId){
        menuItems.removeIf(menuItem -> menuItem.getMenuItemId() == menuItemId);

    }

    /**
    *Function to edit a menu item in the menu.
    *@param menuItem The menu item .
    *@param description The item description.
    *@param price The price.
    *@param category The item category.
    */
    public void editMenuItem(MenuItem menuItem, String description, double price, String category){
        if (description != null && category != null) {
            if (isDuplicate(description, category, menuItem.getMenuItemId())) {
                throw new RuntimeException("The edit operation will create a duplicate menu item");
            }
        }
        if (description != null) {
            menuItem.setDescription(description);
        }
        if (price > 0){
            menuItem.setUnitPrice(price);
        }
        if (category != null){
            menuItem.setCategory(category);
        }
    }
    
    /**
    *Update the item on the menu's status as a special or not.
    *@param menuItem The menu item.
    *@param status The special status.
    */
    private void updateSpecials(MenuItem menuItem, boolean status){
        menuItem.setAsSpecial(status);
    }
    
    /**
    *Turns a menu item into a special.
    *@param menuItem The menu item.
    */
    public void assignMenuItemAsSpecial(MenuItem menuItem){
        updateSpecials(menuItem, true);
    }

    /**
    *Remove the special status from a menu item.
    *@param menuItem The menu item.
    */
    public void removeMenuItemAsSpecial(MenuItem menuItem){
        updateSpecials(menuItem, false);
    }

    /**
    *Create a daily special menu item.
    *@param description The description.
    *@param price The price.
    *@param category The category.
    *@param mId The menu id.
    *@param name The name.
    */
    public void createDailySpecial(String description, double price, String category, int mId, String name){
        MenuItem item = addMenuItem(description, price, category, mId, name);
       item.setAsSpecial(true);
    }




}
    
