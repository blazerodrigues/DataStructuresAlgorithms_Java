package Lists.LinkedListChallenge2;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {

        //this condition is different // addToFront logics would apply
        if(head == null || head.getValue()>=value){
            addToFront(value);
            return;
        }

        //find the insertion point based on sorting condition
        //we have a dual pointer traversal as this is a singly linked list
        //solving the problem that we cannot go backwards
        IntegerNode previous = head;
        IntegerNode current = head.getNext();

        //breaking condition is that we reach the end of the list (null)
        // or value greater than current value is encountered
        while(current!=null && current.getValue()<value){
            previous = current;
            current = current.getNext();
        }

        //insert the newNode (between previous and current)
        IntegerNode newNode = new IntegerNode(value);
        newNode.setNext(current);
        previous.setNext(newNode);

        size++;

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
