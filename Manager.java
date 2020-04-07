package FoodPlace;

public class Manager extends Staff{
    public Manager(String fname, String lname, int hoursToWork){
        super(fname, lname, hoursToWork, "manager");
    }
    public int addStaff(String fname, String lname, int hoursToWork, String sType){
        Staff newStaff = null;
        switch (sType){
            case "waiter": {
                newStaff = new Waiter(fname, lname, hoursToWork);
                break;
            }
            case "chef":{
                newStaff = new Chef(fname, lname, hoursToWork);
                break;
            }
            case "driver":{
                newStaff = new Driver(fname, lname, hoursToWork);
                break;
            }
        }
        return newStaff.getStaffId();
    }
    public void removeStaff(int personId){
        // db
    }

    public void generateReport(){
        // db
    }
}