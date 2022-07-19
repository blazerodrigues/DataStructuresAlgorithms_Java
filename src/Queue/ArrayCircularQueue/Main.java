package Queue.ArrayCircularQueue;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane","Jones",789);
        Employee johnDoe = new Employee("John","Doe",456);
        Employee marySmith = new Employee("Mary","Smith",123);
        Employee mikeWilson = new Employee("Mike","Wilson",741);
        Employee billEnd = new Employee("Bill","End",852);

        ArrayCircularQueue queue = new ArrayCircularQueue(5);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.remove();
        queue.add(marySmith);
        queue.remove();
        queue.add(mikeWilson);
        queue.remove();
        queue.add(billEnd);
        queue.remove();
        queue.add(janeJones);
        queue.printQueue();


//        ArrayCircularQueue queue = new ArrayCircularQueue(5);
//        queue.add(janeJones);
//        queue.add(johnDoe);
//        queue.add(marySmith);
//        queue.add(mikeWilson);
//        queue.add(billEnd);
//
//        System.out.println("----------after adding--------");
//        queue.printQueue();
//
//        queue.remove();
//        queue.remove();
//
//        System.out.println("----------after removal--------");
//        queue.printQueue();
//
//        System.out.println("----------peeking--------");
//        System.out.println(queue.peek());
//
//        System.out.println("----------print after peeking--------");
//        queue.printQueue();
//
//        System.out.println("----------removing all--------");
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//
//        System.out.println("----------print after removing all--------");
//        queue.printQueue();
//
//        queue.add(mikeWilson);
//        System.out.println("----------print queue after adding when list was empty--------");
//        queue.printQueue();


    }



        
}
