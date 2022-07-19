package Heaps.HeapImplementation;

public class Heap {

    //IMPORTANT : in the implementation, dont get confused between INDEX values and the INT ELEMENT VALUES forming the heap

    private int[] heap; //we use arrays to implement heap
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity]; //we initialize the heap array to capacity that is input into the constructor
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is Full!");
        }

        heap[size] = value;

        //When we insert a node at index size, we have to heapify all elements in the heap that are above the tree level that we insert the latest (new) node
        //This is to ensure that parent's value is greater than the child value as this is a MAX heap
        fixHeapAbove(size);

        size++;
    }

    //Returns the root node of the heap
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty!");
        }

        return heap[0];
    }

    //method will be called from the main method, input will be the index of the Heap array that has to be deleted.
    //This is weird, as in real life, we would pass the value that is to be deleted, then Linear Search the heap array to find the index that is to be deleted.
    public int delete(int index) {
        if (isEmpty()) { //if the heap array is empty, obviously any index will be out of bounds
            throw new IndexOutOfBoundsException("Heap is Empty!");
        }

        int parent = getParent(index); //getting the parent of the item that is to be deleted
        int deletedValue = heap[index]; //storing deletedValue in a variable as we have to return it later

        heap[index] = heap[size - 1]; //We replace the item that is to be deleted with the lowest level's right-most item. This replacing item is the last item in the heap array.

        //HEAPIFY!

        //if index=0 ie. ROOT , OR , REPLACEDitem < PARENT
        //we check index==0 first so that heap[parent] for the root should not throw index out of bounds exception
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        size--;

        return deletedValue; //returning the value that we deleted
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index]; //we store this value in a variable for future use

        //break out condition // index = 0 ie we reach the root // Or new Index's parent value is greater
        while (index > 0 && newValue > heap[getParent(index)]) {

            //we repeatedly move parent elements of the heap DOWN
            //in a way we are trying to bubble up the newValue to it's proper position
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;

    }

    //input index is the index below which heap is to be fixed (down the heap) (from index to lastHeapIndex in terms of ARRAY implementation)
    //lastHeapValue is size-1
    private void fixHeapBelow(int index, int lastHeapIndex) {

        int childToSwap; //this is the INDEX of the child to swap

        //internally index value keeps changing (incrementally) //we have to break out when index>lastHeapIndex
        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (leftChild <= lastHeapIndex) { // left child exists
                if (rightChild > lastHeapIndex) {//right child does NOT exist
                    //meaning ONLY LEFT child exists, so childToSwap will be the leftChild
                    childToSwap = leftChild;
                } else { //right child exists
                    //meaning BOTH LEFT and RIGHT children exist
                    //childToSwap will be the greater of the two children
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);

                }

                //if value(index) < value(childToSwap) SWAP the value at index with the child value at childToSwapIndex
                if (heap[index] < heap[childToSwap]) { //child currently is greater than the parent
                    //swap
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else { // child currently is LESSER than parent, AS REQUIRED in MAX heap
                    //so there is no need to explore the lower levels of the heap
                    //explicitly break out of the while loop
                    break;
                }

                index = childToSwap; //assigning (incremented) value to index to repeat the above steps for LOWER levels of the heap

            } else {//this means left and right children BOTH do NOT exist
                //so we explicitly break out of the while loop
                break;
            }
        }
    }

    //we are just printing out the heap array
    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }


    public boolean isFull() {
        return size == heap.length;
    }

    //input here is array 0based index
    public int getParent(int index) {
        return (index - 1) / 2; //not using floor function as any double value in anyway floored when we convert it to int // eg 7.5 would be converted to 7.
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //input is index of parent and left/right(true/false)
    public int getChild(int index, boolean left) {

        //2i+1 for leftChild
        //2i+2 for rightChild
        return 2 * index + (left ? 1 : 2);
    }

    //HEAP SORT!!!
    public void sort(){
        int lastHeapIndex = size-1; //last index of array (0 based)
        for(int i=0;i<lastHeapIndex;i++){
            //swap "last heap element" with the root
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex-i]; //reducing the last element index by 1 everytime whilst looping
            heap[lastHeapIndex-i] = temp;

            fixHeapBelow(0,lastHeapIndex-i-1); //fixing heap below, EXCLUDING the last heap element index where root was swapped and placed
        }
    }



}
