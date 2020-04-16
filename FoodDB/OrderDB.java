package FoodPlace.FoodDB;

import FoodPlace.*;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;

public class OrderDB {
    DBUtil pool;
    public OrderDB() throws Exception{
        super();
        pool = new DBUtil();
    }

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
                        int id = rs.getInt("id");
                        delivery = (Delivery) getOrder(id);
                    }
                }
            }
        }
        return delivery;
    }

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
                        int id = rs.getInt("id");
                        takeaway = (Takeaway) getOrder(id);
                    }
                }
            }
        }
        return takeaway;
    }

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
                        int id = rs.getInt("id");
                        eatin = (EatIn) getOrder(id);
                    }
                }
            }
        }
        return eatin;
    }

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
                        int line_item_id = rs.getInt("id");
                        orderItem = getAnOrderItem(order_id, line_item_id);
                    }
                }
            }
        }
        return orderItem;
    }

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
                timestamp+",\n"+
                type+",\n"+
                driverId+",\n"+
                edtTs+",\n"+
                deliveryStatus+",\n"+
                address+",\n"+
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
                        int order_id = rs.getInt("id");
                        delivery = (Delivery) getOrder(order_id);
                    }
                }
            }
        }
        return delivery;
    }

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
                timestamp+",\n"+
                type+",\n"+
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
                        int order_id = rs.getInt("id");
                        eatin = (EatIn) getOrder(order_id);
                    }
                }
            }
        }
        return eatin;
    }

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
                timestamp+",\n"+
                type+",\n"+
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
                        int order_id = rs.getInt("id");
                        takeaway = (Takeaway) getOrder(order_id);
                    }
                }
            }
        }
        return takeaway;
    }


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
