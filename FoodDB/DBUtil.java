package FoodPlace.FoodDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
*Utility class for the database, used to log in to mySQL.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class DBUtil {
    private static String dbHost = "localhost";
    private static int dbPort = 3306;
    private static String dbName = "food_place";
    private static DBUtil instance = null;
    private Connection conn;
    
    /**
    *The function to log in to the mySql database.
    */
    public DBUtil() throws Exception {
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        conn = DriverManager.getConnection(url, "username", "password");
        System.out.println("Connected " + conn);
    }

    /**
    *Establishes the connection to the database through logging in.
    *@return Connection Connection to the database.
    */
    public Connection getConnection() {
        return conn;
    }

    /**
    *Used to get a new instance of connection to the database.
    *@return new instance of connection to the database.
    */
    public static DBUtil getInstance() throws Exception {
        if (instance == null) instance = new DBUtil();
        return instance;
    }
}
