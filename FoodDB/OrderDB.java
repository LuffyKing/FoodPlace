package FoodPlace.FoodDB;

import FoodPlace.*;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;

/**
*Links the order class to the sql database.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class OrderDB {
    DBUtil pool;
    
    /**
    *Function to get a new connection instance to the database.
    */
    public OrderDB() throws Exception{
        super();
        pool = new DBUtil();
    }

    /**
    *Edits a delivery order in the database.
    *@param orderId The Id of the order.
    *@param dateTime The date and time of the order.
    *@param customerId The Id of the customer associated with the order.
    *@param isComplete The status of the order, complete or not.
    *@param address The address the order needs to be delivered to.
    *@param driverId The Id of the driver handling the order.
    *@param deliveryStatus The status of the delivery.
    *@param isApproved The approval status of the order.
    *@param edt The estimated time of delivery.
    *@return The updated delivery order.
    */
    public Delivery editDeliveryOrder(int orderId,
                                      LocalDateTime dateTime,
                                      int customerId,
                                      boolean isComplete,
                                      String address,
                                      int driverId,
                                      String deliveryStatus,
                                      boolean isApproved,
                                      LocalDateTime edt) throws SQLException{
        Delivery delivery = null;
        String update = "UPDATE orders SET ";
        update += "status = " +isComplete +", ";
        update += "is_delivery_approved = " + isApproved +", ";
        if (dateTime!= null) {
            update += "created_at = " + Timestamp.valueOf(dateTime) + ",";
        }
        if (customerId > 0) {
            update += "customer_id = " + customerId + ",";
        }
        if (address != null){
            update += "address = " + address + ",";
        }
        if (driverId > 0){
            update += "driver_id = " + driverId + ",";
        }
        if (deliveryStatus != null){
            update += "delivery_status = '"+ deliveryStatus +"',";
        }
        if (update.lastIndexOf(",") == update.length()-1){
            update = update.substring(0, update.length()-2);
        }
        update += " where id = "+ orderId+";";
        String[] returnIds = {"id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(update, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Updating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt("GENERATED_KEY");
                        delivery = (Delivery) getOrder(id);
                    }
                }
            }
        }
        return delivery;
    }

    /**
    *Edits a takeaway order in the database.
    *@param orderId The ID of the order.
    *@param dateTime The date and time of the order.
    *@param customerId The ID of the customer associated with the order.
    *@param isComplete The completion status of the order.
    *@param pTime The pickup time of the order.
    *@param cStatus The collection status of the order.
    *@return The updated takeaway order.
    */
    public Takeaway editTakeawayOrder(int orderId,
                                      LocalDateTime dateTime,
                                      int customerId,
                                      boolean isComplete,
                                      LocalDateTime pTime,
                                      boolean cStatus) throws SQLException{
        Takeaway takeaway = null;
        String update = "UPDATE orders SET ";
        update += "status = " +isComplete +", ";
        update += "collection_status = "+ cStatus;
        if (dateTime!= null) {
            update += "created_at = " + Timestamp.valueOf(dateTime) + ",";
        }
        if (pTime != null){
            update += "pickup_time = "+ Timestamp.valueOf(pTime) + ",";
        }
        if (customerId > 0) {
            update += "customer_id = " + customerId + ",";
        }
        if (update.lastIndexOf(",") == update.length()-1){
            update = update.substring(0, update.length()-2);
        }
        update += " where id = "+ orderId+";";
        String[] returnIds = {"id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(update, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Updating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt("GENERATED_KEY");
                        takeaway = (Takeaway) getOrder(id);
                    }
                }
            }
        }
        return takeaway;
    }

    /**
    *Edits an eat in order in the database.
    *@param orderId The ID of the order.
    *@param dateTime The date and time of the order.
    *@param isComplete The completion status of the order.
    *@param waiterID The waiter associated with the order.
    *@return The updated eat in order.
    */
    public EatIn editEatInOrder(int orderId,
                                LocalDateTime dateTime,
                                boolean isComplete,
                                int waiterId) throws SQLException{
        EatIn eatin = null;
        String update = "UPDATE orders SET ";
        update += "status = " +isComplete +", ";
        if (dateTime!= null) {
            update += "created_at = " + Timestamp.valueOf(dateTime) + ",";
        }
        if (waiterId > 0) {
            update += "waiter_id = " + waiterId + ",";
        }
        if (update.lastIndexOf(",") == update.length()-1){
            update = update.substring(0, update.length()-2);
        }
        update += " where id = "+ orderId+";";
        String[] returnIds = {"id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(update, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Updating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt("GENERATED_KEY");
                        eatin = (EatIn) getOrder(id);
                    }
                }
            }
        }
        return eatin;
    }

    /**
    *Used to retrieve an order item from the database.
    *@param orderId The Id of the order to be retrieved.
    *@param lineItemId The Id for an order item.
    *@return The order item.
    */
    public OrderItem getAnOrderItem(int orderId, int lineItemId) throws SQLException{
        OrderItem orderItem = null;
        String select = "SELECT\n"+
                "(order_items.id as line_item_id,\n" +
                "quantity,\n"+
                "m_id,\n"+
                "order_id,\n"+
                "category,\n"+
                "isSpecial,\n"+
                "unitPrice,\n"+
                "name)\n"+
                "FROM menu, order_items \n"+
                "where order_id = "+ orderId+"\n"+
                "and order_items.menu_item_id = menu.m_id and order_items.id = "+ lineItemId+";";
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery(select)) {
                    while (rs.next()){
                        int quantity = rs.getInt("quantity");
                        int menuId = rs.getInt("m_id");
                        int oId = rs.getInt("order_id");
                        int lId = rs.getInt("line_item_id");
                        double price = rs.getDouble("unitPrice");
                        String name = rs.getString("name");
                        String desc = rs.getString("description");
                        String category = rs.getString("category");
                        boolean isSpecial = rs.getBoolean("isSpecial");
                        orderItem = new OrderItem(desc,
                                price,
                                category,
                                menuId,
                                name,
                                oId,
                                lId,
                                quantity,
                                isSpecial);
                    }
                }
            }
        }
        return orderItem;
    }

    /**
    *Creates a new order item in the database.
    *@param quantity The number of the item you want in the order.
    *@param order_id The Id of the order thatyou are adding the item to.
    *@param menu_item_id The Id of the menu item being added to the order.
    *@return The new order item.
    */
    public OrderItem createOrderItem(int quantity, int order_id, int menu_item_id) throws SQLException{
        OrderItem orderItem = null;
        String insert = "INSERT INTO ORDER_ITEMS\n"+
                "(quantity,\n"+
                "order_id,\n"+
                "menu_item_id\n"+
                ")"+
                "VALUES( "+ quantity+",\n"+
                order_id+",\n"+
                menu_item_id+"\n"+
                "); \n";
        String[] returnIds = {"id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating order item failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int line_item_id = rs.getInt("GENERATED_KEY");
                        orderItem = getAnOrderItem(order_id, line_item_id);
                    }
                }
            }
        }
        return orderItem;
    }

    /**
    *Create a delivery order in the database.
    *@param dateTime The date and time of the order.
    *@param customerId The Id of the customer who made the order.
    *@param isComplete The completion status of the order.
    *@param address The delivery address for the order.
    *@param driverId The driver responsible for the order.
    *@param deliveryStatus The status of the delivery.
    *@param isApproved The approval status of the order.
    *@param edt The estimated delivery time.
    *@return The new delivery order.
    */
    public Delivery createDeliveryOrder(LocalDateTime dateTime,
                                        int customerId,
                                        boolean isComplete,
                                        String address,
                                        int driverId,
                                        String deliveryStatus,
                                        boolean isApproved,
                                        LocalDateTime edt
                                        ) throws SQLException{

        String type = "delivery";
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        Timestamp edtTs = Timestamp.valueOf(edt);
        Delivery delivery = null;
        String insert = "INSERT INTO ORDERS\n"+
                "(customer_id,\n"+
                "status,\n"+
                "created_at\n"+
                "ord_type\n"+
                "driver_id\n"+
                "est_delivery_time\n"+
                "delivery_status\n"+
                "delivery_address\n"+
                "is_delivery_approved\n"+
                ")"+
                "VALUES( "+ customerId+",\n"+
                isComplete+",\n"+
                timestamp+",\n'"+
                type+"',\n"+
                driverId+",\n"+
                edtTs+",\n'"+
                deliveryStatus+"',\n'"+
                address+"',\n"+
                isApproved+",\n"+
                "); \n";
        String[] returnIds = {"id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating order item failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int order_id = rs.getInt("GENERATED_KEY");
                        delivery = (Delivery) getOrder(order_id);
                    }
                }
            }
        }
        return delivery;
    }

    /**
    *Creates an eat in order in the database.
    *@param item The list of items in the order.
    *@param dateTime The date and time of the order.
    *@param isComplete The completion status of the order.
    *@param waiterId The ID of the waiter associated with the order.
    *@return The new eat in order.
    */
    public EatIn createEatInOrder(ObservableList<OrderItem> item,
                                  LocalDateTime dateTime,
                                  boolean isComplete,
                                  int waiterId
    ) throws SQLException{
        String type = "eatIn";
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        EatIn eatin = null;
        String insert = "INSERT INTO ORDERS\n"+
                "(status,\n"+
                "created_at\n"+
                "ord_type\n"+
                "waiter_id\n"+
                ")"+
                "VALUES( "+ isComplete+",\n"+
                timestamp+",\n'"+
                type+"',\n"+
                waiterId+",\n"+
                "); \n";
        String[] returnIds = {"id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating order item failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int order_id = rs.getInt("GENERATED_KEY");
                        eatin = (EatIn) getOrder(order_id);
                    }
                }
            }
        }
        return eatin;
    }

    /**
    *Creates a new takeaway order in the database.
    *@param dateTime The date and time of the order.
    *@param customerId The ID of the customer associated with the order.
    *@param isComplete The completion status of the order.
    *@param pTime The pickup time of the order.
    *@param cStatus The collection status.
    *@return The new takeaway order.
    */
    public Takeaway createTakeawayOrder(LocalDateTime dateTime,
                                        int customerId,
                                        boolean isComplete,
                                        LocalDateTime ptime,
                                        boolean cStatus
    ) throws SQLException{
        String type = "takeaway";
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        Takeaway takeaway = null;
        String insert = "INSERT INTO ORDERS\n"+
                "(customer_id,\n"+
                "status,\n"+
                "created_at\n"+
                "ord_type\n"+
                "pickup_time\n"+
                "collection_status\n"+
                ")"+
                "VALUES( "+ customerId+",\n"+
                isComplete+",\n"+
                timestamp+",\n'"+
                type+"',\n"+
                ptime+",\n"+
                cStatus+",\n"+
                "); \n";
        String[] returnIds = {"id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating order item failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int order_id = rs.getInt("GENERATED_KEY");
                        takeaway = (Takeaway) getOrder(order_id);
                    }
                }
            }
        }
        return takeaway;
    }

    /**
    *Returns a list of all items in a specific order in the database.
    *@param orderId The Id of the order in question.
    *@return A list of all items in the order.
    */
    public ObservableList<OrderItem> getAllOrderItems(int orderId) throws SQLException{
        ObservableList<OrderItem> orderItems = null;
        String select = "SELECT\n"+
                "(order_items.id as line_item_id,\n" +
                "quantity,\n"+
                "m_id,\n"+
                "order_id,\n"+
                "category,\n"+
                "isSpecial,\n"+
                "unitPrice,\n"+
                "name)\n"+
                "FROM menu, order_items \n"+
                "where order_id = "+ orderId+"\n"+
                "and order_items.menu_item_id = menu.m_id;";
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery(select)) {
                    while (rs.next()){
                        int quantity = rs.getInt("quantity");
                        int menuId = rs.getInt("m_id");
                        int oId = rs.getInt("order_id");
                        int lId = rs.getInt("line_item_id");
                        double price = rs.getDouble("unitPrice");
                        String name = rs.getString("name");
                        String desc = rs.getString("description");
                        String category = rs.getString("category");
                        boolean isSpecial = rs.getBoolean("isSpecial");
                        OrderItem orderItem = new OrderItem(desc,
                                price,
                                category,
                                menuId,
                                name,
                                oId,
                                lId,
                                quantity,
                                isSpecial);
                        orderItems.add(orderItem);
                    }
                }
            }
        }
        return orderItems;
    }

    /**
    *Returns a list of all orders.
    *@return A list of all orders.
    */
    public ObservableList<Order> getAllOrders() throws SQLException {
        ObservableList<Order> orders = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Orders;")) {
                    while (rs.next()) {
                        Order newOrder = null;
                        int orderId = rs.getInt("id");
                        boolean status = rs.getBoolean("status");
                        int customerId = rs.getInt("customer_id");
                        int waiterId = rs.getInt("waiter_id");
                        int driverId = rs.getInt("driver_id");
                        String type = rs.getString("ord_type");
                        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                        LocalDateTime edt = rs.getTimestamp("est_delivery_time").toLocalDateTime();
                        String deliveryStatus = rs.getString("delivery_status");
                        String deliveryAddress = rs.getString("delivery_address");
                        boolean isDeliveryApproved = rs.getBoolean("is_delivery_approved");
                        LocalDateTime pickupTime = rs.getTimestamp("pickup_time").toLocalDateTime();
                        boolean collectionStatus = rs.getBoolean("collection_status");
                        ObservableList<OrderItem> orderItems = getAllOrderItems(orderId);
                        switch (type){
                            case "delivery": {
                                newOrder = new Delivery(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        deliveryAddress,
                                        driverId,
                                        deliveryStatus,
                                        isDeliveryApproved,
                                        edt);
                                break;
                            }
                            case "eatIn":{
                                newOrder = new EatIn(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        waiterId);
                                break;
                            }
                            case "takeaway":{
                                newOrder = new Takeaway(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        pickupTime,
                                        collectionStatus
                                );
                                break;
                            }
                        }
                        orders.add(newOrder);
                    }
                }
            }
        }
        return orders;
    }

    /**
    *Returns a list of orders a specific customer has in the database.
    *@param custId The Id of the customer whose orders you wish to retrieve.
    *@return A list of all orders or a specific customer.
    */
    public ObservableList<Order> getAllOrders(int custId) throws SQLException {
        ObservableList<Order> orders = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Orders where customer_id ="+ custId+" ;")) {
                    while (rs.next()) {
                        Order newOrder = null;
                        int orderId = rs.getInt("id");
                        boolean status = rs.getBoolean("status");
                        int customerId = rs.getInt("customer_id");
                        int waiterId = rs.getInt("waiter_id");
                        int driverId = rs.getInt("driver_id");
                        String type = rs.getString("ord_type");
                        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                        LocalDateTime edt = rs.getTimestamp("est_delivery_time").toLocalDateTime();
                        String deliveryStatus = rs.getString("delivery_status");
                        String deliveryAddress = rs.getString("delivery_address");
                        boolean isDeliveryApproved = rs.getBoolean("is_delivery_approved");
                        LocalDateTime pickupTime = rs.getTimestamp("pickup_time").toLocalDateTime();
                        boolean collectionStatus = rs.getBoolean("collection_status");
                        ObservableList<OrderItem> orderItems = getAllOrderItems(orderId);
                        switch (type){
                            case "delivery": {
                                newOrder = new Delivery(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        deliveryAddress,
                                        driverId,
                                        deliveryStatus,
                                        isDeliveryApproved,
                                        edt);
                                break;
                            }
                            case "eatIn":{
                                newOrder = new EatIn(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        waiterId);
                                break;
                            }
                            case "takeaway":{
                                newOrder = new Takeaway(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        pickupTime,
                                        collectionStatus
                                );
                                break;
                            }
                        }
                        orders.add(newOrder);
                    }
                }
            }
        }
        return orders;
    }

    /**
    *Retrieves a specific order from the database.
    *@param id The Id of the order to be retrieved.
    *@return An order.
    */
    public Order getOrder(int id) throws SQLException {
        Order order = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Orders where id = "+ id+";")) {
                    while (rs.next()) {
                        int orderId = rs.getInt("id");
                        boolean status = rs.getBoolean("status");
                        int customerId = rs.getInt("customer_id");
                        int waiterId = rs.getInt("waiter_id");
                        int driverId = rs.getInt("driver_id");
                        String type = rs.getString("ord_type");
                        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                        LocalDateTime edt = rs.getTimestamp("est_delivery_time").toLocalDateTime();
                        String deliveryStatus = rs.getString("delivery_status");
                        String deliveryAddress = rs.getString("delivery_address");
                        boolean isDeliveryApproved = rs.getBoolean("is_delivery_approved");
                        LocalDateTime pickupTime = rs.getTimestamp("pickup_time").toLocalDateTime();
                        boolean collectionStatus = rs.getBoolean("collection_status");
                        ObservableList<OrderItem> orderItems = getAllOrderItems(orderId);
                        switch (type){
                            case "delivery": {
                                order = new Delivery(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        deliveryAddress,
                                        driverId,
                                        deliveryStatus,
                                        isDeliveryApproved,
                                        edt);
                                break;
                            }
                            case "eatIn":{
                                order = new EatIn(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        waiterId);
                                break;
                            }
                            case "takeaway":{
                                order = new Takeaway(orderItems,
                                        orderId,
                                        createdAt,
                                        customerId,
                                        status,
                                        pickupTime,
                                        collectionStatus
                                );
                                break;
                            }
                        }

                    }
                }
            }
        }
        return order;
    }

    /**
    *Deletes a specific order from the database.
    *@param orderId The Id of the order to be deleted.
    */
    public void deleteOrder(int orderId) throws SQLException {
        String delete = "DELETE FROM ORDERS where id = " + orderId;
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(delete)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Deleting user failed, no rows affected.");
                }

            }
        }
    }

    /**
    *Deletes items from a specific order.
    *@param orderId The Id for the order from which you wish to delete items.
    */
    public void deleteOrderItems(int orderId) throws SQLException {
        String delete = "DELETE FROM ORDER_ITEMS where order_id = " + orderId;
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(delete)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Deleting user failed, no rows affected.");
                }

            }
        }
    }

    /**
    *Deletes a specific item from an order.
    *@param orderItemId The Id of the order item to be deleted.
    */
    public void deleteOrderItem(int orderItemId) throws SQLException {
        String delete = "DELETE FROM ORDER_ITEMS where id = " + orderItemId;
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(delete)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Deleting user failed, no rows affected.");
                }

            }
        }
    }

}
