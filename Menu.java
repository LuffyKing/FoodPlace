package FoodPlace;

import javafx.collections.ObservableList;

public class Menu {
    private ObservableList<MenuItem> menuItems;
    public Menu(ObservableList<MenuItem> items){
        menuItems = items;
    }

    public ObservableList<MenuItem> getMenuItems() {
        return menuItems;
    }
    
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

    public boolean isDuplicate(String description, String category){
        for (MenuItem item:
             menuItems) {
            if(item.getDescription().equals(description) && item.getCategory().equals(category)){
                return true;
            }
        }
        return false;
    }

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

    public void removeMenuItem(int menuItemId){
        menuItems.removeIf(menuItem -> menuItem.getMenuItemId() == menuItemId);

    }

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
    private void updateSpecials(MenuItem menuItem, boolean status){
        menuItem.setAsSpecial(status);
    }
    public void assignMenuItemAsSpecial(MenuItem menuItem){
        updateSpecials(menuItem, true);
    }

    public void removeMenuItemAsSpecial(MenuItem menuItem){
        updateSpecials(menuItem, false);
    }

    public void createDailySpecial(String description, double price, String category, int mId, String name){
        MenuItem item = addMenuItem(description, price, category, mId, name);
       item.setAsSpecial(true);
    }




}
    
