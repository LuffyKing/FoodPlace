package uti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConUtil {
    Connection con = null;
    public static Connection connectDB()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/FoodPlace", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
            return null;
        }
    }
}