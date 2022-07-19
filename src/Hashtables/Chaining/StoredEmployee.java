package Hashtables.Chaining;

public class StoredEmployee {


    //making the fields public to avoid setters and getters and making the sample code cluttered
    //in production, use private
    public String storedKey; // this is the lastname string
    public Employee storedEmployee;

    public StoredEmployee(String key, Employee employee){
        this.storedKey = key;
        this.storedEmployee = employee;
    }


}
