package Hashtables.Chaining;

public class Main {
    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane","Jones",789);
        Employee johnDoe = new Employee("John","Doe",456);
        Employee marySmith = new Employee("Mary","Smith",123);
        Employee mikeWilson = new Employee("Mike","Wilson",741);
//        Employee billEnd = new Employee("Bill","End",852);

        ChainedHashtable ht = new ChainedHashtable();
        ht.put("Jones", janeJones);
        ht.put("Doe",johnDoe);
        ht.put("Smith", marySmith);
        ht.put("Wilson",mikeWilson);


        ht.printHashTable();
        System.out.println();

//        System.out.println("Retrieve key Smith: "+ht.get("Smith"));
//        System.out.println();
//
//        ht.remove("Doe");
//        ht.remove("Jones");
//        ht.printHashTable();


    }
}
