package FoodPlace.FoodDB;

public class DBUtil {
    private static DBUtil instance = null;
    private DBPool pool;
    public DBUtil() throws Exception {
        pool = new DBPool("username", "password");
    }
    public static DBUtil getInstance() throws Exception {
        if (instance == null) instance = new DBUtil();
        return instance;
    }

    public DBPool getDBConnectionPool() {
        return pool;
    }
}
