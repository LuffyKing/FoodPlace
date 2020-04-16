package FoodPlace.FoodDB;

import FoodPlace.*;
import javafx.collections.ObservableList;

import java.sql.*;

/**
*Handles everything to do with notifications in the database.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class NotificationDB {
    DBUtil pool;
    
    /**
    *Function to get a new connection instance to the database.
    */
    public NotificationDB() throws Exception{
        super();
        pool = new DBUtil();
    }

    /**
    *Returns a list of all possible notifications.
    *@return list of notifications
    */
    public ObservableList<Notification> getAllNotifications() throws SQLException {
        ObservableList<Notification> notifications = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from notifications")) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String message = rs.getString("message");
                        int cid = rs.getInt("customer_id");
                        Notification notification = new Notification(id, message, cid);
                        notifications.add(notification);
                    }
                }
            }
        }
        return notifications;
    }

    /**
    *Retrieves a specific notification from the database.
    *@param notificationId The Id of the notification to be retrieved.
    *@return The requested notification.
    */
    public Notification getNotification(int notificationId) throws SQLException {
        Notification notification = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from notifications where id = "+notificationId)) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String message = rs.getString("message");
                        int cid = rs.getInt("customer_id");
                        notification = new Notification(id, message, cid);
                    }
                }
            }
        }
        return notification;
    }

    /**
    *Creates a notification in the database.
    *@param message The notification message.
    *@param cid The customer ID for the notification.
    *@return The new notification.
    */
    public Notification createNotification(String message,
                             int cid) throws SQLException {
        Notification notification = null;
        String insert = "INSERT INTO NOTIFICATIONS\n"+
                "(message,\n"+
                "customer_id\n"+
                ")\n"+
                "VALUES( "+ message+",\n"+
                cid+"\n"+
                "); \n";
        String[] returnIds = {"id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        notification = getNotification(id);
                    }
                }
            }
        }
        return notification;
    }

    /**
    *Deletes a specific notification from the database.
    *@param notificationId The Id of the notification to be deleted.
    */
    public void deleteNotification(int notificationId) throws SQLException {
        String delete = "DELETE FROM NOTIFICATION where id = " + notificationId;
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
