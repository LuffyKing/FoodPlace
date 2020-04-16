package FoodPlace.FoodDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static String dbHost = "localhost";
    private static int dbPort = 3306;
    private static String dbName = "food_place";
    private static DBUtil instance = null;
    private Connection conn;
    public DBUtil() throws Exception {
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        conn = DriverManager.getConnection(url, "username", "password");
        System.out.println("Connected " + conn);
    }

    public Connection getConnection() {
        return conn;
    }

    public static DBUtil getInstance() throws Exception {
        if (instance == null) instance = new DBUtil();
        return instance;
    }
}
