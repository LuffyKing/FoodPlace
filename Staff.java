package FoodPlace;

abstract class Staff extends Person{
    private int staffId;
    private int hoursWorked;
    private int hoursToBeWorked;
    private static int count = 0;
    private String staffType;

    public Staff(String fname, String lname, int hoursToWork, String sType){
        super(fname,lname);
        hoursWorked = 0;
        hoursToBeWorked = hoursToWork;
        staffId = count++;
        staffType = sType;
        //save the staff to the db
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