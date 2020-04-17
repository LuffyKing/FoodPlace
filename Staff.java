package FoodPlace;

/**
*This class represents the staff in the business with the information that they all have in common.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
public abstract class Staff extends Person{
    private int staffId;
    private int hoursWorked;
    private int hoursToBeWorked;
    private String staffType;
    private String username;
    private String password;
   
    /**
    *Constructor for a staff member.
    *@param fname The first name.
    *@param lname The last name.
    *@param hoursToWork The number of hours the staff member needs to work.
    *@param sType The staff member type.
    *@param sId The staff member Id.
    *@param uname The staff member's username.
    *@param pword The staff member's password.
    */
    public Staff(String fname,
                 String lname,
                 int hoursToWork,
                 String sType,
                 int sId,
                 String uname,
                 String pword){
        super(fname,lname);
        hoursWorked = 0;
        hoursToBeWorked = hoursToWork;
        staffId = sId;
        staffType = sType;
        username = uname;
        password = pword;
    }

    /**
    *Constructor for a staff member including the number of hours they have worked.
    *@param fname The first name.
    *@param lname The last name.
    *@param hoursToWork The number of hours the staff member needs to work.
    *@param sType The staff member type.
    *@param sId The staff member Id.
    *@param uname The staff member's username.
    *@param pword The staff member's password.
    *@param hWorked The number of hours they have worked.
    */
    public Staff(String fname,
                 String lname,
                 int hoursToWork,
                 String sType,
                 int sId,
                 String uname,
                 String pword,
                 int hWorked){
        super(fname,lname);
        hoursWorked = hWorked;
        hoursToBeWorked = hoursToWork;
        staffId = sId;
        staffType = sType;
        username = uname;
        password = pword;
    }

    /**
    *Returns the staff member's password.
    *@return The password.
    */
    public String getPassword() {
        return password;
    }

    /**
    *Updates the staff member password.
    *@param password The new password for the staff member.
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
    *Returns the staff type.
    *@return The staff type.
    */
    public String getStaffType() {
        return staffType;
    }

    /**
    *Returns the staff member's username.
    *@return The username.
    */
    public String getUsername() {
        return username;
    }

    /**
    *Updates a staff member's username.
    *@param username The new username.
    */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
    *Returns the number of hours the staff member needs to work.
    *@return The number of hours to be worked.
    */
    public int getHoursToBeWorked() {
        return hoursToBeWorked;
    }

    /**
    *Updates the number of hours that the staff member needs to work.
    *@param hoursToBeWorked The number of hours to be worked.
    */
    public void setHoursToBeWorked(int hoursToBeWorked) {
        this.hoursToBeWorked = hoursToBeWorked;
    }

    /**
    *Updates the number of hours that have been worked by the staff member.
    *@param hoursWorked The number of hours worked.
    */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
    *Returns the number of hours that have been worked by a staff member.
    *@return The number of hours that have been worked.
    */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
    *Returns the staff ID.
    *@return The staff ID.
    */
    public int getStaffId() {
        return staffId;
    }
}
