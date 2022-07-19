package Heaps.HeapImplementation;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(80); //index 0, wrt heap ARRAY //remember that we are passing the ARRAY index as input in the delete() method //weird! However, as per the course instructor, heaps generally do not have a "delete any node" option implementation.. Usually heaps only have a delete root option. And we know that root is INDEX 0 always!So root VALUE need not be passed, root index can be passed directly.
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

//        heap.printHeap();
//        System.out.println("Peek: "+heap.peek());
//        System.out.println("------------------------");
//
//        System.out.println("Deleted "+heap.delete(0));
//        heap.printHeap();
//        System.out.println("Peek: "+heap.peek());
//        heap.printHeap();

        heap.printHeap();
        heap.sort();
        heap.printHeap();


    }
}
