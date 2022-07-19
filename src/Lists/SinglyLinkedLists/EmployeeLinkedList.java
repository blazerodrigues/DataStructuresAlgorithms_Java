package Lists.SinglyLinkedLists;

public class EmployeeLinkedList {

    private EmployeeNode head; //initialized to NULL by default
    private int size; //initialized to zero by default by the compiler

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void printList(){

        //printing starting from the head node
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while(current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }

        System.out.println("NULL");
    }

}
