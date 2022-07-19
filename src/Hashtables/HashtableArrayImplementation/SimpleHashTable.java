package Hashtables.HashtableArrayImplementation;

public class SimpleHashTable {

    private Employee[] hashtable; //Employee ARRAY backing the hashtable implementation

    public SimpleHashTable(){
        hashtable = new Employee[10];
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key); //this returns the index where key's value should be put in the hashtable ARRAY

        //this hashKey does not avoid collisions :(
        if(hashtable[hashedKey] != null){
            System.out.println("Sorry, there is already an employee at position "+hashedKey);

        }else{

            hashtable[hashedKey] = employee;
        }

    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }


    private int hashKey(String key){
        //this will always return value from 0 - 9
        //as we are are doing % hashtable.length
        return key.length() % hashtable.length;
    }

    public void printHashTable(){
        for(int i = 0; i<hashtable.length; i++){
            System.out.println(hashtable[i]);
        }
    }



}
