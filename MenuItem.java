package FoodPlace;

public class MenuItem {
    private boolean isSpecial;
    private String description;
    private String category;
    private double unitPrice;
    private int menuItemId;
    private int quantity;
    public MenuItem(String desc, double unitP, String cat){
        description = desc;
        unitPrice = unitP;
        category = cat;
        isSpecial = false;
        quantity = 0;
        // save to db then get the id
        menuItemId = -1;
    }

    public double getTotal() {
        return quantity * unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setAsSpecial(boolean special) {
        isSpecial = special;
    }

}
