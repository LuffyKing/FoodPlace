package FoodPlace;

/**
*This class represents the person superclass and contains a first name and last name for all people staff and customer.
*@author Damola Aderinwale (JavaDoc by Sara Philipson)
*@version ?
*/
abstract class Person{
    private String firstName;
    private String lastName;
    
    /**
    *Constuctor for person.
    *@param fname The first name.
    *@param lname The last name.
    */
    public Person(String fname, String lname){
        firstName = fname;
        lastName = lname;
    }
    
    /**
    *Returns the fist name of the person.
    *@return The first name.
    */
    public String getFirstName() {
        return firstName;
    }

    /**
    *Returns the last name of the person.
    *@return The last name.
    */
    public String getLastName() {
        return lastName;
    }

    /**
    *Function to return the combined first and last names.
    *@return The person's full name.
    */
    public String getFullName(){
        return firstName +" "+ lastName;
    }
}
