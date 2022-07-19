package Lists.ArrayListsAndVector;

import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        //only difference between ArrayList and Vector classes is that:
        //ArrayList is NOT thread safe
        //Vector is thread safe

//        List<Employee> employeeList = new ArrayList<>();

        List<Employee> employeeList = new Vector<>();


        employeeList.add(new Employee("Jane","Jones",123));
        employeeList.add(new Employee("John","Doe",4567));
        employeeList.add(new Employee("Mary","Smith",22));
        employeeList.add(new Employee("Mike","Wilson",3245));

//        employeeList.forEach(employee -> System.out.println(employee));

//        System.out.println(employeeList.get(1));

//        System.out.println(employeeList.isEmpty());

        //.set() is used for REPLACEMENT
        employeeList.set(1,new Employee("John","Adams",4568));
//        employeeList.forEach(employee -> System.out.println(employee));

//        System.out.println(employeeList.size());

        //adding at a specific index //other elements of the list are automatically moved down
        employeeList.add(3, new Employee("John","Doe",4567));
//        employeeList.forEach(employee -> System.out.println(employee));

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for(Employee employee: employeeArray){
//            System.out.println(employee);
//        }

        //returns  false when equals method is not implemented in the Employee class.
        //Default equals method checks for exact same instances
        System.out.println(employeeList.contains(new Employee("Mary","Smith",22)));
        System.out.println(employeeList.indexOf(new Employee("John","Doe",4567)));

        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));



    }


}
