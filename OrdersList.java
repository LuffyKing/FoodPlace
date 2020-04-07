package FoodPlace;

public class OrdersList{
    private Order[] orders;
    private int index;
    OrdersList(){
        orders = new Order[50];
        index = 0;
    }

    OrdersList(Order[] orders){
        this.orders = orders;
        index = orders.length - 1;
    }

    public void addOrderToList(Order order){
        if (index >= orders.length - 1) {
          resize(orders.length*2);
        }
        orders[index++] = order;
    }

    public void resize(int newLength){
        Order[] newArr = new Order[newLength];
        for (int i = 0; i < orders.length; i++) {
            newArr[i] = orders[i];
        }
        orders = newArr;
    }

    public void removeOrder(int orderId){
        for (int i = 0; i < orders.length; i++) {
            if(orders[i].getOrderId() == orderId){
                Order[] newArr = new Order[orders.length-1];
                int count = 0;
                for (int j = 0; j < orders.length; j++) {
                    if (j != i){
                        newArr[count++] = orders[j];
                    }
                }
                orders = newArr;
                // delete from db
                break;
            }
        }
    }

    
    public Order[] getOrders() {
        return orders;
    }

}
