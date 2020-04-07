package FoodPlace;

public class Menu {
    private MenuItem[] menuItems;
    int currIndex;
    public Menu(){
        menuItems = new MenuItem[50];
        currIndex = 0;
    }
    public Menu(MenuItem[] items){
        menuItems = items;
        currIndex = menuItems.length-1;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public boolean isDuplicate(String description, String category){
        for (MenuItem item:
             menuItems) {
            if(item.getDescription() == description && item.getCategory() == category){
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicate(String description, String category, int exceptionId){
        for (MenuItem item:
                menuItems) {
            if(item.getDescription() == description && item.getCategory() == category
                    && exceptionId != item.getMenuItemId()){
                return true;
            }
        }
        return false;
    }

    public void resize(int newLength){
        MenuItem[] newArr = new MenuItem[newLength];
        for (int i = 0; i < menuItems.length; i++) {
            newArr[i] = menuItems[i];
        }
        menuItems = newArr;
    }

    public void addMenuItem(String description, double price, String category){
        if (!isDuplicate(description, category)){
            MenuItem item = new MenuItem(description, price, category);
            if (currIndex + 1 == menuItems.length) {
                resize(menuItems.length * 2);
            }
            menuItems[++currIndex] = item;
            // save to db
        } else {
            throw new RuntimeException("The menu item already exists");
        }
    }

    public void removeMenuItem(int menuItemId){
        for (int i = 0; i < menuItems.length; i++) {
            if(menuItems[i].getMenuItemId() == menuItemId){
                MenuItem[] newArr = new MenuItem[menuItems.length-1];
                int count = 0;
                for (int j = 0; j < menuItems.length; j++) {
                    if (j != i){
                        newArr[count++] = menuItems[j];
                    }
                }
                menuItems = newArr;
                // delete from db
                break;
            }
        }
    }

    public void editMenuItem(int menuItemId, String description, double price, String category){
        for (int i = 0; i < menuItems.length; i++) {
            if(menuItems[i].getMenuItemId() == menuItemId){
                if (description != null && category != null) {
                    if (isDuplicate(description, category, menuItemId)) {
                        throw new RuntimeException("The edit operation will create a duplicate menu item");
                    }
                }
                if (description != null) {
                    menuItems[i].setDescription(description);
                }
                if (price != -1){
                    menuItems[i].setUnitPrice(price);
                }
                if (category != null){
                    menuItems[i].setCategory(category);
                }

                // update from db
                break;
            }
        }
    }
    private void updateSpecials(int menuItemId, boolean status){
        for (int i = 0; i < menuItems.length; i++) {
            if(menuItems[i].getMenuItemId() == menuItemId){
                menuItems[i].setAsSpecial(status);
                // update from db
                break;
            }
        }
    }
    public void assignMenuItemAsSpecial(int menuItemId){
        updateSpecials(menuItemId, true);
    }

    public void removeMenuItemAsSpecial(int menuItemId){
        updateSpecials(menuItemId, false);
    }

    public void createDailySpecial(String description, double price, String category){
        addMenuItem(description, price, category);
        menuItems[currIndex].setAsSpecial(true);
    }




}
    
