package FoodPlace;

public class MenuItem {
    private boolean isSpecial;
    private String description;
    private String category;
    private double unitPrice;
    private int menuItemId;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean getSpecial(){
        return isSpecial;
    }

}
