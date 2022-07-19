package Lists.JDKlinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson",3245);
        Employee billEnd = new Employee("Bill","End",78);

        LinkedList<Employee> list = new LinkedList<>();
        //addFirst() method adds to the FRONT of the list
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        Iterator iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("NULL");

//        for(Employee employee : list){
//            System.out.println(employee);
//        }

        //add() method adds to the END of the list
        //addLast() method will also give the SAME output
        list.add(billEnd);
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("NULL");

        // add() and addLast() do the SAME
        // remove() and removeFirst() do the SAME
        //So, always read the documentation before using the method as they are not consistent.

        //remove() method will also do the SAME thing
        list.removeFirst();
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("NULL");


        list.removeLast();
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("NULL");


    }


}
