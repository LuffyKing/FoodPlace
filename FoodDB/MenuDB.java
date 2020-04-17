package FoodPlace.FoodDB;

import FoodPlace.*;
import javafx.collections.ObservableList;

import java.sql.*;

public class MenuDB {
    DBUtil pool;
    MenuDB() throws Exception{
        super();
        pool = new DBUtil();
    }

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
