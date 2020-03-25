
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Vector;
import java.util.Properties;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class FoodDB {
    private static FoodDB instance = null;
    private DBPool pool;
    private FoodDB() throws Exception {
        pool = new DBPool("username", "password");
    }
    public static FoodDB getInstance() throws Exception {
        if (instance == null) instance = new FoodDB();
        return instance;
    }
    public int getMostPopularMenu() throws SQLException {
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT Menu_id,COUNT(id) AS counts FROM orders GROUP BY Menu_id ORDER BY counts DESC LIMIT 1")) {
                    if (rs.next()) {
                        int id  = rs.getInt("id");
                        int counts = rs.getInt("counts");
                        return id;
                    } else {
                        throw new RuntimeException("No data.");
                    }
                }
            }
        }
    }
    public int getMostActiveCustomer() throws SQLException {
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT Customers_id,COUNT(b_id) AS counts FROM bookings GROUP BY Customers_id ORDER BY counts DESC LIMIT 1")) {
                    if (rs.next()) {
                        int id  = rs.getInt("Customers_id");
                        int counts = rs.getInt("counts");
                        return id;
                    } else {
                        throw new RuntimeException("No data.");
                    }
                }
            }
        }
    }
    public int getHighestWork() throws SQLException {
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT S_id, hours_worked + hours_2bworked AS worktime FROM Staff ORDER BY worktime DESC LIMIT 1")) {
                    if (rs.next()) {
                        int id  = rs.getInt("S_id");
                        int worktime = rs.getInt("worktime");
                        return worktime;
                    } else {
                        throw new RuntimeException("No data.");
                    }
                }
            }
        }
    }
    public int getBusiest() throws SQLException {
        HashMap<Integer, Integer> periods = new HashMap<>();
        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT HOUR(end_time) AS s_end, HOUR(start_time) AS s_start FROM table_schedule")) {
                    while (rs.next()) {
                        int s_start = rs.getInt("s_start");
                        int s_end  = rs.getInt("s_end");
                        for (int i = 0; i < s_end - s_start; i++) {
                            int u = s_start + i;
                            if (u > 23) {
                                u = u - 24;
                            }
                            periods.put(s_start + i, periods.getOrDefault(s_start + i,0) + 1);
                        }
                    }
                }
            }
        }
        int highest = -1;
        int highestPeriod = -1;
        for (int i: periods.keySet()) {
            if (periods.get(i) > highest) {
                highest = periods.get(i);
                highest = i;
            }
        }
        return highestPeriod;
    }
    public DataSource getDBConnectionPool() {
        return DBPool;
    }
}
class DBPool implements DataSource {
    private static String dbHost = "localhost";
    private static int dbPort = 3389;
    private static String dbName = "foodplace";
    private Vector<Connection> connections = new Vector<>();
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch(Exception e) {
            e.printStackTrace();
        }
       
    }

    DBPool(String username, String password) throws Exception {
        for (int i = 0; i < 10; i++) {
            String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected " + conn);
            connections.addElement(conn);
        }
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        // TODO Auto-generated method stub
        
    }
 
    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub
        
    }
 
    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
 
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }
 
    @Override
    public Connection getConnection() throws SQLException {
        if (connections.size()>0) {
            final Connection conn = connections.remove(0);
            return (Connection) Proxy.newProxyInstance(DBPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler(){
                @Override
                public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                    if(!method.getName().equals("close")){
                        return method.invoke(conn, args);
                    }else{
                        connections.addElement(conn);
                        return null;
                    }
                }
            });
        }else {
            throw new RuntimeException("Server Busy");
        }
    }
 
    @Override
    public Connection getConnection(String username, String password)
            throws SQLException {
        return null;
    }
}