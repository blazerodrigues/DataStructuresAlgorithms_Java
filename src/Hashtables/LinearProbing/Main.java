package Hashtables.LinearProbing;

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
        ht.put("Smith", marySmith);

//        ht.printHashTable();

//        System.out.println("Retrieve key Wilson: "+ht.get("Wilson"));
//        System.out.println("Retrieve key Smith: "+ht.get("Smith"));
//        System.out.println("Retrieve key Jones: "+ht.get("Jones"));

        ht.remove("Wilson");
        ht.remove("Jones");
        System.out.println(ht.remove("Smith"));
        ht.printHashTable();


    }
}
