package FoodPlace;

import javafx.collections.ObservableList;

/**
*This class represents the generated reports required by the manager.
*@author Haixi Wang
*@author Damola Aderinwale 
*@version ?
*/

public class Menu {
    private ObservableList<MenuItem> menuItems;
    /**
    *Updates the menu item.
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
    *Function to remove duplicate item by check description and category.
    *@param menuItem The menu item.
    *@param description The description.
    *@param category The category.
    *@return The menu item that not duplicate.
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
    *Function to remove duplicate item by check exception id.
    *@param menuItem The menu item.
    *@param description The description.
    *@param category The category.
    *@return The menu item that not duplicate.
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
    *Function to save to database.
    *@param menuItem The menu item.
    *@param description The description.
    *@param price The price.
    *@param category The category.
    *@param mId The menu id.
    *@param name The name.
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
    *Function to remove menu item.
    *@param menuItemId The menu item id.
    */
    public void removeMenuItem(int menuItemId){
        menuItems.removeIf(menuItem -> menuItem.getMenuItemId() == menuItemId);

    }

    /**
    *Function to edit menu item.
    *@param menuItem The menu item .
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
    *set the specials.
    *@param setAsApecial The specials.
    */
    private void updateSpecials(MenuItem menuItem, boolean status){
        menuItem.setAsSpecial(status);
    }
    
    /**
    *Updates the special.
    *@param menuItem The menu item.
    */
    public void assignMenuItemAsSpecial(MenuItem menuItem){
        updateSpecials(menuItem, true);
    }

    /**
    *Remove the specials.
    *@param menuItem The menu item.
    */
    public void removeMenuItemAsSpecial(MenuItem menuItem){
        updateSpecials(menuItem, false);
    }

    /**
    *Create the specials.
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
    
