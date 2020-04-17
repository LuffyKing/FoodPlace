package FoodPlace.FoodDB;

import FoodPlace.Chef;
import FoodPlace.Driver;
import FoodPlace.Staff;
import FoodPlace.Waiter;
import javafx.collections.ObservableList;

import java.sql.*;

/**
*Links the staff class to the database.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public class StaffDB{
    DBUtil pool;
    
    /**
    *Function to get a new connection instance to the database.
    */
    public StaffDB() throws Exception{
        super();
        pool = new DBUtil();
    }

    /**
    *Returns a list of all staff.
    *@return A list of all staff.
    */
    public ObservableList<Staff> getAllStaff() throws SQLException {
        ObservableList<Staff> staffs = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Staff")) {
                    while (rs.next()) {
                        Staff newStaff = null;
                        int staffId = rs.getInt("s_id");
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        int hoursWorked = rs.getInt("hours_worked");
                        int hoursToWork = rs.getInt("hours_2bworked");
                        String type = rs.getString("type");
                        String username = rs.getString("S_username");
                        String password = rs.getString("password");
                        switch (type){
                            case "waiter": {
                                newStaff = new Waiter(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                            case "chef":{
                                newStaff = new Chef(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                            case "driver":{
                                newStaff = new Driver(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                        }
                        staffs.add(newStaff);
                    }
                }
            }
        }
        return staffs;
    }

    /**
    *Returns details about a specific staff member.
    *@param staffId The Id of the staff member you want to retrieve.
    *@return The staff details in question.
    */
    public Staff getStaff(int staffId) throws SQLException {
        Staff staff = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Staff where s_id = "+staffId)) {
                    while (rs.next()) {
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        int hoursWorked = rs.getInt("hours_worked");
                        int hoursToWork = rs.getInt("hours_2bworked");
                        String type = rs.getString("type");
                        String username = rs.getString("S_username");
                        String password = rs.getString("password");
                        switch (type){
                            case "waiter": {
                                staff = new Waiter(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                            case "chef":{
                                staff = new Chef(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                            case "driver":{
                                staff = new Driver(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return staff;
    }

<<<<<<< HEAD
    public Staff getStaff(String username, String password) throws SQLException {
        Staff staff = null;

        try (Connection conn = pool.getConnection()){
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from Staff where S_Username = '"+username+"'"+" and Password = '"+ password+"';")) {
                    if(rs.next()) {
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        int hoursWorked = rs.getInt("hours_worked");
                        int hoursToWork = rs.getInt("hours_2bworked");
                        String type = rs.getString("type");
                        int staffId = rs.getInt("s_id");
                        switch (type){
                            case "waiter": {
                                staff = new Waiter(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                            case "chef":{
                                staff = new Chef(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                            case "driver":{
                                staff = new Driver(firstName,
                                        lastName,
                                        hoursToWork,
                                        type,
                                        staffId,
                                        username,
                                        password,
                                        hoursWorked);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return staff;
    }

=======
    /**
    *Creates a new staff member in the database.
    *@param fname The first name.
    *@param lname The last name.
    *@param h2Work The hours the staff member needs to work.
    *@param sType The staff member type.
    *@param uname The staff username.
    *@param pword The staff password.
    *@return The new staff item.
    */
>>>>>>> 3e7a98f97f4d094c86c46796a0205c22b3a13f57
    public Staff createStaff(String fname,
                             String lname,
                             int h2Work,
                             String sType,
                             String uname,
                             String pword) throws SQLException {
        Staff staff = null;
        String insert = "INSERT INTO STAFF\n"+
                "(first_name,\n"+
                "last_name,\n"+
                "hours_worked,\n"+
                "hours_2bworked,\n"+
                "type,\n"+
                "S_username,\n"+
                "password)\n"+
                "VALUES( '"+ fname+"',\n'"+
                lname+"',\n"+
                0+",\n"+
                h2Work+",\n'"+
                sType+"',\n'"+
                uname+"',\n'"+
                pword+
                "'); \n";
        String[] returnIds = {"s_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(insert, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int sId = rs.getInt("GENERATED_KEY");
                        staff = getStaff(sId);
                    }
                }
            }
        }
        return staff;
    }

    /**
    *Deletes a staff member from the database.
    *@param staffId The Id of the staff member to be deleted.
    */
    public void deleteStaff(int staffId) throws SQLException {
        String delete = "DELETE FROM STAFF where s_id = " + staffId;
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
    *Edits the details of a staff member in the database.
    *@param staffId The Id of the staff member being edited.
    *@param fname The first name of the staff member.
    *@param lname The last name of the staff member.
    *@param h2Work The number of hours the staf member needs to work.
    *@param hWorked The number of hours the staff member has worked.
    *@param sType The type of staff member.
    *@param uname The staff member's username.
    *@param pword The staff member's password.
    *@return The edited staff details.
    */
    public Staff editStaff(int staffId,
                           String fname,
                           String lname,
                           int h2Work,
                           int hWorked,
                           String sType,
                           String uname,
                           String pword
                           ) throws SQLException {
        Staff staff = null;
        String update = "UPDATE STAFF SET ";
        if (fname != null) {
            update += "first_name = '" + fname + "',";
        }
        if (lname != null) {
            update += "last_name = '" + lname + "',";
        }
        if (hWorked > 0){
            update += "hours_worked = " + hWorked + ",";
        }
        if (h2Work > 0){
            update += "hours_2bworked = " + h2Work + ",";
        }
        if (sType != null){
            update += "type = '"+ sType +"',";
        }
        if (uname != null){
            update += "S_username ='" + uname+"',";
        }
        if (pword != null){
            update += "password = '" + pword+ "'";
        }
        if (update.lastIndexOf(",") == update.length()-1){
            update = update.substring(0, update.length()-2);
        }
        update += " where s_id = "+ staffId+";";
        String[] returnIds = {"s_id"};
        try (Connection conn = pool.getConnection()){
            try (PreparedStatement statement = conn.prepareStatement(update, returnIds)) {
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Updating user failed, no rows affected.");
                }
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int sId = rs.getInt("GENERATED_KEY");
                        staff = getStaff(sId);
                    }
                }
            }
        }
        return staff;
    }


}
