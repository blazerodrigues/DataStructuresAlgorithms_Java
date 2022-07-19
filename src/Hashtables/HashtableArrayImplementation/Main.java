package Hashtables.HashtableArrayImplementation;

public class Main {
    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane","Jones",789);
        Employee johnDoe = new Employee("John","Doe",456);
        Employee marySmith = new Employee("Mary","Smith",123);
        Employee mikeWilson = new Employee("Mike","Wilson",741);
        Employee billEnd = new Employee("Bill","End",852);

        SimpleHashTable ht = new SimpleHashTable();
        ht.put("Jones", janeJones);
        ht.put("Doe",johnDoe);
        ht.put("Wilson",mikeWilson);
        ht.put("Smith", marySmith); // Smith should cause collision with Jones

        //ht.printHashTable();

        System.out.println("Retrieve key Wilson: "+ht.get("Wilson"));

    }
}
