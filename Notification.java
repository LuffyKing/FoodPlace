package FoodPlace;

public class Notification {
    private final int id;
    private final String text;
    private final int customerId;
    public Notification(int id, String text, int customerId){
        this.id = id;
        this.text = text;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
