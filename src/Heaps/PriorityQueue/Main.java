package Heaps.PriorityQueue;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        //priority queue is a MIN heap //meaning LOWEST value is the root and has the highest priority
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

//        System.out.println("Peek = "+pq.peek());
//        pq.forEach((i)-> System.out.print(i+", "));
//        System.out.println();
//
//        System.out.println("Removed: "+pq.remove()); //removes root if nothing is passed // if object is passed, removes object
//        pq.forEach((i)-> System.out.print(i+", "));
//        System.out.println();
//
//        System.out.println("Poll = "+pq.poll()); //always removes root
//        pq.forEach((i)-> System.out.print(i+", "));
//        System.out.println();
//
        System.out.println("Removed: "+pq.remove(54));
//        pq.forEach((i)-> System.out.print(i+", "));
//        System.out.println();
//
//        System.out.println("Add: "+pq.add(-10));
//        pq.forEach((i)-> System.out.print(i+", "));
//        System.out.println();

        //convertng PriorityQueue heap to array
        Object[] pqArray = pq.toArray();
        for(Object pqa:pqArray){
            System.out.println(pqa);
        }

    }

}
