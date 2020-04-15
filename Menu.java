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
    
    public MenuItem getMenuItem(int menuItemId){
        MenuItem menuItem = null;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i].getMenuItemId() == menuItemId){
                menuItem = menuItems[i];
            }
        }
        return  menuItem;
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

    public void resize(int newLength){
        MenuItem[] newArr = new MenuItem[newLength];
        System.arraycopy(menuItems, 0, newArr, 0, menuItems.length);
        menuItems = newArr;
    }

    public void addMenuItem(String description, double price, String category, int mId){
        if (!isDuplicate(description, category)){
            MenuItem item = new MenuItem(description, price, category, mId);
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

    public void createDailySpecial(String description, double price, String category, int mId){
        addMenuItem(description, price, category, mId);
        menuItems[currIndex].setAsSpecial(true);
    }




}
    
