package FoodPlace.FoodDB;

import FoodPlace.*;
import javafx.collections.ObservableList;

import java.sql.*;

/**
*To link the menu class to the sql database.
*@vauthor Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class MenuDB {
    DBUtil pool;
   
    /**
    *Function to get a new connection instance to the database.
    */
    MenuDB() throws Exception{
        super();
        pool = new DBUtil();
    }

    /**
    *Used to create a new MenuItem in the database.
    *@param desc A description of the item.
    *@param unitP Price of the item.
    *@param cat Category of the item.
    *@param nameVar The name of the item.
    *@param special Indicates if the item is a daily special or not.
    *@return the newly created menu item.
    */
    public MenuItem createMenuItem(String desc,
                                double unitP,
                                String cat,
                                String nameVar,
                                boolean special) throws SQLException {
        MenuItem menuItem = null;
        String insert = "INSERT INTO MENU\n"+
                "(name,\n"+
                "isSpecial,\n"+
                "category,\n"+
                "description,\n"+
                "unitPrice\n"+
                ")\n"+
                "VALUES( '"+ nameVar+"',\n"+
                special+",\n'"+
                cat+"',\n'"+
                desc+"',\n"+
                unitP+
                "); \n";
        String[] returnIds = {"m_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int mId = rs.getInt("GENERATED_KEY");
                        menuItem = getMenuItem(mId);
                    }
                }
            }
        }
        return menuItem;
    }

    /**
    *Retrives a list of all items in the menu from the database.
    *@return A list of all MenuItems
    */
    public ObservableList<MenuItem> getAllMenuItems() throws SQLException {
        ObservableList<MenuItem> menuItems = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Menu")) {
                    while (rs.next()) {
                        int mId = rs.getInt("m_id");
                        String name = rs.getString("name");
                        double unitPrice = rs.getDouble("unitPrice");
                        String category = rs.getString("category");
                        String description = rs.getString("description");
                        boolean special = rs.getBoolean("isSpecial");
                        MenuItem menuItem = new MenuItem(description, unitPrice, category, mId, name, special);
                        menuItems.add(menuItem);
                    }
                }
            }
        }
        return menuItems;
    }

    /**
    *Function to retrieve a specific menu item from the database.
    *@param menuItemId The ID of the menu item you wish to retrieve.
    *@return The specific menu item asked for.
    */
    public MenuItem getMenuItem(int menuItemId) throws SQLException {
        MenuItem menuItem = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Menu where m_id="+menuItemId+";")) {
                    while (rs.next()) {
                        int mId = rs.getInt("m_id");
                        String name = rs.getString("name");
                        double unitPrice = rs.getDouble("unitPrice");
                        String category = rs.getString("category");
                        String description = rs.getString("description");
                        boolean special = rs.getBoolean("isSpecial");
                        menuItem = new MenuItem(description, unitPrice, category, mId, name, special);
                    }
                }
            }
        }
        return menuItem;
    }

    /**
    *Deletes a specific menu item from the database.
    *@param menuItemId the Id of the menu item to be deleted.
    */
    public void deleteMenuItem(int menuItemId) throws SQLException {
        String delete = "DELETE FROM MENU where m_id = " + menuItemId;
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
    *Edits a specific menu item in the database.
    *@param menuItemId The Id of the menu item.
    *@param name The name of the menu item.
    *@param isSpecial The status to say if the item is a daily special or not.
    *@param category The menu item category.
    *@param desc The description of the item.
    *@param unitPrice The price of the item.
    *@return The updated menu item.
    */
    public MenuItem editMenuItem(int menuItemId,
                           String name,
                           boolean isSpecial,
                           String category,
                           String desc,
                           double unitPrice
    ) throws SQLException {
        MenuItem menuItem = null;
        String update = "UPDATE MENU SET ";
        update += "isSpecial = "+isSpecial+",";
        if (name != null) {
            update += "name = '" + name + "',";
        }
        if (category != null) {
            update += "category = '" + category + "',";
        }
        if (desc != null){
            update += "description = '" + desc + "',";
        }
        if (unitPrice > 0){
            update += "unitPrice = " + unitPrice + ",";
        }
        if (update.lastIndexOf(",") == update.length()-1){
            update = update.substring(0, update.length()-2);
        }
        update += " where m_id = "+ menuItemId+";";
        String[] returnIds = {"m_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(update, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Updating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int mId = rs.getInt("GENERATED_KEY");
                        menuItem = getMenuItem(mId);
                    }
                }
            }
        }
        return menuItem;
    }
}
