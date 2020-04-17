package FoodPlace;

/**
*This class represents the items in the menu.
*@author Damola Aderinwale (JavaDoc by Haixin Wang & Sara Philipson)
*@version ?
*/

public class MenuItem {
    private boolean isSpecial;
    private String description;
    private String category;
    private double unitPrice;
    private int menuItemId;
    private String name;
    
    /**
    *Constructor for a menu item.
    *@param desc The item.
    *@param unitP The unit price.
    *@param cat The category.
    *@param mId The menu item id.
    *@param nameVar The name.
    */
    public MenuItem(String desc,
                    double unitP,
                    String cat,
                    int mId,
                    String nameVar){
        description = desc;
        unitPrice = unitP;
        category = cat;
        isSpecial = false;
        menuItemId = mId;
        name = nameVar;
    }

    /**
    *Constructor for a menu item.
    *@param desc The item.
    *@param unitP The unit price.
    *@param cat The category.
    *@param mId The menu item id.
    *@param nameVar The name.
    *@param oId The older id.
    *@param lId The line item id.
    *@param quant The quantity.
    *@param special The special items.
    */
    public MenuItem(String desc,
                    double unitP,
                    String cat,
                    int mId,
                    String nameVar,
                    boolean special){
        description = desc;
        unitPrice = unitP;
        category = cat;
        isSpecial = special;
        menuItemId = mId;
        name = nameVar;
    }

    /**
    *Returns the item name.
    *@return The item name.
    */
    public String getName() {
        return name;
    }

    /**
    *Updates the item name.
    *@param name The item name.
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    *Returns the item description.
    *@return The item description.
    */
    public String getDescription() {
        return description;
    }

    /**
    *Updates the item description.
    *@param description The item description.
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
    *Returns the unit price.
    *@return The unit price.
    */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
    *Updates the unit price.
    *@param unitPrice The unit price.
    */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
    *Updates the item category.
    *@param categoty The item category.
    */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
    *Returns the item category.
    *@return The item category.
    */
    public String getCategory() {
        return category;
    }

    /**
    *Returns the menu item id.
    *@return The menu item id.
    */
    public int getMenuItemId() {
        return menuItemId;
    }

    /**
    *Updates the specials.
    *@param special The specials.
    */
    public void setAsSpecial(boolean special) {
        isSpecial = special;
    }

    /**
    *Returns the specials.
    *@return The specials.
    */
    public boolean getSpecial(){
        return isSpecial;
    }

}
