package FoodPlace;

public abstract class Staff extends Person{
    private int staffId;
    private int hoursWorked;
    private int hoursToBeWorked;
    private String staffType;
    private String username;
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffType() {
        return staffType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHoursToBeWorked() {
        return hoursToBeWorked;
    }

    public void setHoursToBeWorked(int hoursToBeWorked) {
        this.hoursToBeWorked = hoursToBeWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public int getStaffId() {
        return staffId;
    }
}