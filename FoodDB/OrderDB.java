package FoodPlace.FoodDB;

import FoodPlace.*;
import javafx.collections.ObservableList;

import java.sql.*;
import java.sql.Driver;
import java.time.LocalDateTime;

public class OrderDB extends DBUtil  {
    DBPool pool;
    public OrderDB() throws Exception{
        super();
        pool = getDBConnectionPool();
    }



    public OrderItem getAnOrderItem(int orderId, int lineItemId) throws SQLException{
        OrderItem orderItem = null;
        String select = "SELECT\n"+
                "(order_items.id as line_item_id,\n" +
                "quantity,\n"+
                "m_id,\n"+
                "order_id,\n"+
                "price,\n"+
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

    public Delivery createDeliveryOrder(ObservableList<OrderItem> item,
                                        LocalDateTime dateTime,
                                        int customerId,
                                        boolean isComplete,
                                        String address,
                                        int driverId,
                                        String deliveryStatus,
                                        boolean isApproved,
                                        LocalDateTime edt
                                        ){
        String type = "delivery";
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        Timestamp edtTs = Timestamp.valueOf(edt);
        OrderItem orderItem = null;
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
                        int line_item_id = rs.getInt("id");
                        orderItem = getAnOrderItem(order_id, line_item_id);
                    }
                }
            }
        }
        return orderItem;
    }

    public ObservableList<OrderItem> getAllOrderItems(int orderId) throws SQLException{
        ObservableList<OrderItem> orderItems = null;
        String select = "SELECT\n"+
                "(order_items.id as line_item_id,\n" +
                "quantity,\n"+
                "m_id,\n"+
                "order_id,\n"+
                "price,\n"+
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

    public ObservableList<Order> getOrder(int id) throws SQLException {
        ObservableList<Order> orders = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Orders where id = "+ id+";")) {
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



    public Staff createStaff(String fname,
                             String lname,
                             int h2Work,
                             String sType,
                             String uname,
                             String pword) throws SQLException {
        Staff staff = null;
        String insert = "INSERT INTO STAFF\n"+
                "(first_name,\n"+
                "last_name,\n"+
                "hours_worked,\n"+
                "hours_2bworked,\n"+
                "type,\n"+
                "username,\n"+
                "password)\n"+
                "VALUES( "+ fname+",\n"+
                lname+",\n"+
                0+",\n"+
                h2Work+",\n"+
                sType+",\n"+
                uname+",\n"+
                pword+
                "); \n";
        String[] returnIds = {"s_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int sId = rs.getInt("s_id");
                        staff = getStaff(sId);
                    }
                }
            }
        }
        return staff;
    }

    public void deleteStaff(int staffId) throws SQLException {
        String delete = "DELETE FROM STAFF where s_id = " + staffId;
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(delete)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Deleting user failed, no rows affected.");
                }

            }
        }
    }

    public Staff editStaff(int staffId,
                           String fname,
                           String lname,
                           int h2Work,
                           int hWorked,
                           String sType,
                           String uname,
                           String pword
    ) throws SQLException {
        Staff staff = null;
        String update = "UPDATE STAFF SET ";
        if (fname != null) {
            update += "first_name = '" + fname + "',";
        }
        if (lname != null) {
            update += "last_name = '" + lname + "',";
        }
        if (hWorked > 0){
            update += "hours_worked = " + hWorked + ",";
        }
        if (h2Work > 0){
            update += "hours_2bworked = " + h2Work + ",";
        }
        if (sType != null){
            update += "type = '"+ sType +"',";
        }
        if (uname != null){
            update += "username ='" + uname+"',";
        }
        if (pword != null){
            update += "password = '" + pword+ "'";
        }
        if (update.lastIndexOf(",") == update.length()-1){
            update = update.substring(0, update.length()-2);
        }
        update += " where s_id = "+ staffId+";";
        String[] returnIds = {"s_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(update, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Updating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int sId = rs.getInt("s_id");
                        staff = getStaff(sId);
                    }
                }
            }
        }
        return staff;
    }
}