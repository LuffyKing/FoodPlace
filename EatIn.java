package FoodPlace;

public class EatIn extends Order {
    public EatIn(MenuItem[] items){
        super(items);
        setOrderType("Eat In");
    }
}
