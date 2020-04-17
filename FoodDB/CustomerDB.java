package FoodPlace.FoodDB;

import FoodPlace.*;

import java.sql.*;

public class CustomerDB {
    DBUtil pool;
    public CustomerDB() throws Exception{
        super();
        pool = new DBUtil();
    }

    public Customer getCustomer(String username, String password) throws SQLException {
        Customer customer = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Customers where C_Username = '"+username+"'"+" and Password = '"+ password+"';")) {
                    if(rs.next()) {
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        String address = rs.getString("address");
                        int cid = rs.getInt("c_id");
                        customer = new Customer(firstName, lastName, address,cid);
                    }
                }
            }
        }
        return customer;
    }

    public Customer getCustomer(int customerId) throws SQLException {
        Customer customer = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Customers where c_id = "+customerId+";")) {
                    if(rs.next()) {
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        String address = rs.getString("address");
                        int cid = rs.getInt("c_id");
                        customer = new Customer(firstName, lastName, address,cid);
                    }
                }
            }
        }
        return customer;
    }

    public Customer createCustomer(String fname,
                             String lname,
                             String address,
                             String uname,
                             String pword) throws SQLException {
        Customer customer = null;
        String insert = "INSERT INTO CUSTOMERS\n"+
                "(first_name,\n"+
                "last_name,\n"+
                "C_Username,\n"+
                "address,\n"+
                "password)\n"+
                "VALUES( '"+ fname+"',\n'"+
                lname+"',\n'"+
                uname+"',\n'"+
                address+"',\n'"+
                pword+
                "'); \n";
        String[] returnIds = {"c_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int cId = rs.getInt("GENERATED_KEY");
                        customer = getCustomer(cId);
                    }
                }
            }
        }
        return customer;
    }
}
