package Hashtables.Challenge2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));
        employees.forEach(e -> System.out.println(e));


        ListIterator<Employee> iterator = employees.listIterator();
        List<Employee> removeList = new ArrayList<>();
        HashMap<Integer,Employee> employeeTable = new HashMap<>();

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employeeTable.containsKey(employee.getId())){
                removeList.add(employee);
            }else{
                employeeTable.put(employee.getId(),employee);
            }
        }

        for(Employee removeEmployee: removeList){
            employees.remove(removeEmployee);
        }

        System.out.println("---------------------------------");
        employees.forEach(e -> System.out.println(e));

    }



}
