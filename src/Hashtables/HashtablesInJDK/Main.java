package Hashtables.HashtablesInJDK;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 789);
        Employee johnDoe = new Employee("John", "Doe", 456);
        Employee marySmith = new Employee("Mary", "Smith", 123);
        Employee mikeWilson = new Employee("Mike", "Wilson", 741);
//        Employee billEnd = new Employee("Bill","End",852);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
//        hashMap.put("Wilson",mikeWilson);

        //note the difference between list iterator and map iterator
//        Iterator<Employee> iterator = hashMap.values().iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        for(Map.Entry<String, Employee> hashMapElement : hashMap.entrySet()){
//            System.out.println("Key = "+hashMapElement.getKey()+" , Value = "+hashMapElement.getValue());
//        }

//        hashMap.forEach((k, v) -> {
//            System.out.println("Using hashmap.forEach::: Key - " + k + " , Value - " + v);
//        });

//        System.out.println(hashMap.containsKey("Doe"));
//        System.out.println(hashMap.containsValue(janeJones));

        //if we put another element in the hashtable with the same key, the existing value at the key will be replaced with the new value
//        Employee employee = hashMap.put("Doe",mikeWilson); //when replacing old value with new value, OLD value is returned by the method
//        System.out.println(employee);
//        System.out.println(hashMap.put("Wilson", mikeWilson)); //returns null if this is a brand new put operation, where the key is being inserted for the first time

//        Employee employee = hashMap.putIfAbsent("Doe",mikeWilson); //putIfAbsent() will not overwrite the new value on the old value, and will return the old value. In case of new key, it will return null.
//        System.out.println(employee);
//        System.out.println();

//        System.out.println(hashMap.get("Smith"));//should return value based on input key
//        System.out.println(hashMap.get("Someone"));//else return null if key does not exist
//
//        System.out.println(hashMap.getOrDefault("Someone",mikeWilson)); //if key is not found, instead of returing null getOrDefault returns the default value that we provide

        hashMap.forEach((k, v) -> {
            System.out.println("Using hashmap.forEach::: Key - " + k + " , Value - " + v);
        });

        System.out.println();
        System.out.println(hashMap.remove("Jones")); //returns removed employee.
        System.out.println(hashMap.remove("Jones")); //returns null if employee no longer exists.
        System.out.println();

        hashMap.forEach((k, v) -> {
            System.out.println("Using hashmap.forEach::: Key - " + k + " , Value - " + v);
        });



    }
}
