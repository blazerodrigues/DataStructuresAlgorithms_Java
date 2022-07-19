package Stacks.StacksArray;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack; //stack is an array of Employee class
    private int top; //pointer that points to the top // top field (int) default initialization is 0 , it points to the top of the stack

    //constructor accepts EXTRA parameter CAPACITY
    //this is to initialize the array capacity
    //it will define the maximum no. of items that can be stored on the stack
    //since it is an array , capacity once fixed cannot be changed
    //for resizing, new array will have to created and elements from old array will have to be copied to the new array
    public ArrayStack(int capacity){
        stack = new Employee[capacity];
    }

    public void push(Employee employee){
        if(top == stack.length){ //size of the array is full
            //need to resize the backing array
            Employee[] newArray = new Employee[2*stack.length]; //new array size is usually taken as TWICE the size of original stack array length
            //arraycopy(src,srcPos,dest,destPos,length of array that is to be copied)
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray; //storing the reference of the newArray in the stack array variable
        }
        stack[top++] = employee; //add new element at the top position and then increment top
    }

    public Employee pop(){
        if(isEmpty()){
            throw new EmptyStackException(); //throwing exception to allow user to handle this condition
        }

        Employee employee = stack[--top]; // decrementing the top first to get array 0based index
        stack[top] = null;

        return employee;

    }

    public Employee peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top-1];
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return top == 0; //if top equals zero, return true
    }

    public void printStack(){
        for(int i = top-1; i>=0;i--){
            System.out.println(stack[i]);
        }
    }


}
