package Hashtables.Chaining;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {

    //using array of LinkedList class having generic set to StoredEmployee
    //This will back the hashtable implementation
    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable(){

        hashtable = new LinkedList[10]; //initializing array of LinkedList class to size 10

        for(int i=0;i<hashtable.length;i++){
            hashtable[i] = new LinkedList<StoredEmployee>(); //initializing each LinkedList element of the "array of LinkedList" class
        }

    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key,employee));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);

        //iterating over the linkedlist present at the hashedkey index in the hashtable
        LinkedList<StoredEmployee> list = hashtable[hashedKey];
        ListIterator<StoredEmployee> iter = list.listIterator();
        StoredEmployee storedEmployeeINSTANCE = null;
        while (iter.hasNext()){
            storedEmployeeINSTANCE = iter.next();
            if(storedEmployeeINSTANCE.storedKey.equals(key)){
                return storedEmployeeINSTANCE.storedEmployee;
            }
        }
        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);

        //iterating over the linkedlist present at the hashedkey index in the hashtable
        LinkedList<StoredEmployee> list = hashtable[hashedKey];
        ListIterator<StoredEmployee> iter = list.listIterator();
        StoredEmployee storedEmployeeINSTANCE = null;
        int index = -1; //index is for performance improvement, so that we can remove the element from the LinkedList by passing this index, and not by passing the storedEmployee object - which would require iteratinng over all the elements in the linkedlist to search for the storedEmployee object that is to be removed.
        while (iter.hasNext()){
            index++; //index will be incremented from -1 to 0 on first iteration
            storedEmployeeINSTANCE = iter.next();
            if(storedEmployeeINSTANCE.storedKey.equals(key)){
                break;
            }
        }

        if (storedEmployeeINSTANCE==null || !storedEmployeeINSTANCE.storedKey.equals(key)){
            return null;
        }else {
//            hashtable[hashedKey].remove(storedEmployeeINSTANCE);
            hashtable[hashedKey].remove(index); // this is index based remove() //improves performance over object based remove
            return storedEmployeeINSTANCE.storedEmployee;
        }

    }

    private int hashKey(String key){
//        return key.length() % hashtable.length; //commenting this as hashcode method should be called in the class // we will now use String class's default hashcode method

        //We use Math.abs to give absolute value as String hashcode method can sometimes give negative values which is not acceptable in our array based hashtable implementation
        return Math.abs(key.hashCode() % hashtable.length);

    }

    public void printHashTable(){
        for(int i=0;i<hashtable.length;i++){
            if(hashtable[i].isEmpty()){
                System.out.println("Position "+i+" : EMPTY");

            }else{
                System.out.print("Position "+i+" : ");
                ListIterator<StoredEmployee> iter = hashtable[i].listIterator();
                while(iter.hasNext()){
                    System.out.print(iter.next().storedEmployee);
                    System.out.print(" <-> ");
                }
                System.out.println("null");
            }
        }
    }


}
