package FoodPlace.FoodDB;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Vector;
import java.util.logging.Logger;

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