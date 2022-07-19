package Hashtables.LinearProbing;

public class SimpleHashTable {

//    private Employee[] hashtable; //Employee ARRAY backing the hashtable implementation

    //StoredEmployee ARRAY backing the hashtable implementation
    //using storedEmployee[] instead of employee[] because we need to store key(last name) and value(employee obj) BOTH for get method implementation in linear probing
    private StoredEmployee[] hashtable;


    public SimpleHashTable(){
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee){

        int hashedKey = hashKey(key); // gets the hashed key value

        //LINEAR PROBING
        if(isOccupied(hashedKey)){
            int stopIndex = hashedKey;
            //moving ahead from the stopIndex
            //1st case wrap to 0 if we are at the end of the array
            //else we increment
            if(hashedKey == hashtable.length-1){
                hashedKey = 0; //wrapping
            }else{
                hashedKey++;
            }
            //now using while loop, we check for free locations in hash table
            while(isOccupied(hashedKey) && hashedKey!=stopIndex){
                hashedKey = (hashedKey+1) % hashtable.length; //%hastable.length to wrap to the front of the array eg 0-9 array, 10%10 = 0
            }
        }


        if(isOccupied(hashedKey)){
            System.out.println("Sorry, collisiton at "+hashedKey);
        }else{
            hashtable[hashedKey] = new StoredEmployee(key,employee);
        }


    }

    public Employee get(String key){
        int hashedKey = findKey(key);

        if(hashedKey == -1){
            return null;
        }

        return hashtable[hashedKey].storedEmployee;
    }

    public Employee remove(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }

        Employee employee = hashtable[hashedKey].storedEmployee;
        hashtable[hashedKey] = null;

        //REHASHING !!!!!!!!!!
        //saving current hashtable as oldHashtable
        StoredEmployee[] oldHashtable = hashtable;
        //initializing new StoredEmployee[] array for new hashtable
        hashtable = new StoredEmployee[oldHashtable.length];
        //
        for(int i=0;i<oldHashtable.length;i++){
            if(oldHashtable[i] != null){
                put(oldHashtable[i].storedKey, oldHashtable[i].storedEmployee);
            }
        }


        return  employee;
    }


    private int hashKey(String key){
        //this will always return value from 0 - 9
        //as we are are doing % hashtable.length
        return key.length() % hashtable.length;
    }

    //to be used in get() , needed to implement linear probing for get()
    private int findKey(String key){
        int hashedKey = hashKey(key);
        if(hashtable[hashedKey] != null && hashtable[hashedKey].storedKey.equals(key)){
            return hashedKey;
        }

        //LINEAR PROBING to find/search
        int stopIndex = hashedKey;
        if(hashedKey == hashtable.length-1){
            hashedKey = 0; //wrapping to move ahead of stopIndex
        }
        else{
            hashedKey++; //moving ahead of stopIndex
        }
        //hashtable[hashedKey]!=null //this condition is to be noted: in linear probing, if element is not possible to be inserted at the original hashKey, then it is inserted at the next possible non - null location
        //so if hashtable[hashedKey]=null it is safe to assume that the element does not exist in the hash table // this is also the reason why hashtable REHASHING is done after removal of an element from the hashtable.
        while(hashedKey!=stopIndex && hashtable[hashedKey]!=null && !hashtable[hashedKey].storedKey.equals(key)){
            hashedKey = (hashedKey+1) % hashtable.length;
        }


        if(hashtable[hashedKey] !=null && hashtable[hashedKey].storedKey.equals(key)){
            return hashedKey;
        }else{
            return -1;
        }

    }

    public boolean isOccupied(int index){
        return hashtable[index] != null;
    }

    public void printHashTable(){
        for(int i = 0; i<hashtable.length; i++){
            if(hashtable[i] == null){
                System.out.println("Position : "+i+" - EMPTY");
            }else {
                System.out.println("Position : "+i+" - "+hashtable[i].storedEmployee);
            }
        }
    }



}
