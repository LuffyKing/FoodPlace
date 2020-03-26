package FoodPlace;

abstract class Person{
    private String firstName;
    private String lastName;
    public Person(String fname, String lname){
        firstName = fname;
        lastName = lname;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return firstName +" "+ lastName;
    }
}