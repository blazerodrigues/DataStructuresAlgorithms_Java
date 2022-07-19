package Stacks.LinkedListImplementation;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {

    //the linkedStack is being backed by a LinkedList
    private LinkedList<Employee> stack;

    public LinkedStack(){
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printStack(){
        //iterator traverses from head of the linkedList to tail
        //this corresponds to top to bottom traversal of stack
        ListIterator<Employee> iterator = stack.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }



}
