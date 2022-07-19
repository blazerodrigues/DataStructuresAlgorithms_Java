package Queue.ArrayCircularQueue;

import java.util.NoSuchElementException;

public class ArrayCircularQueue {

    private Employee[] queue;
    private int front;
    private int back;

    //later, back always points to the next position

    public ArrayCircularQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {

        //queue.length gives the capacity of the array
        //size() gives the number of elements actually present in the array

        //queue.length - 1 because element can be added at that index but back cannot be incremented as it will be an invalid index after back++
        if (size() == queue.length - 1) {

            int numItems = size(); //saving for later use

            Employee[] newArray = new Employee[2 * queue.length];

            //Copying wraped queue from front to end of array
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            //copying wraped queue elements from start of array to back
            //then placing them after in the newArray after the front elements
            if(front > back) {
                System.arraycopy(queue, 0, newArray, queue.length - front, back);
            }
            queue = newArray;

            //resetting front and back positions to align with the newArray queue
            front = 0;
            back = numItems;

        }

        queue[back] = employee;

        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0; //wrapping the queue to the start
        }

    }

    /*
     * 0 - jane
     * 1 - john
     * 2 -       - back
     * 3 - mike  - front
     * 4 - bill
     */

    /*
     * 0 - mike - front
     * 1 - bill
     * 2 - jane
     * 3 - john
     * 4 -      - back
     */

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;

        //memory optimization
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }

    }

    public void printQueue() {

        if (front <= back) {
            for (int i = 0; i < back; i++) {
                if(queue[i]!= null)
                    System.out.println(queue[i]);
            }
        }else{
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }

    }

}
