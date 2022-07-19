package Trees.BinarySearchTrees;

public class TreeNode {

    //Tree's NODE!

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    //constructor
    public TreeNode(int data) {
        this.data = data;
    }


    public void insertTreeNode(int value) {
        //value is the input value , data is the int value existing in THIS treeNode
        if (value == data) { //we are not allowing duplicate entries in our version of BST implementation
            return;
        }

        if (value < data) { //we will try to insert the tree node to the LEFT
            if (leftChild == null) { // if THIS treenode's left child does not exist
                leftChild = new TreeNode(value); // make a treeNODE of the input value and place it here
            } else {//if leftChild != null
                leftChild.insertTreeNode(value); // call insertTreeNode method on the THIS leftChild
            }
        }//similarly below...
        else { //if value>data // we will try to insert the tree node to the RIGHT

            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {//if rightChild != null
                rightChild.insertTreeNode(value);
            }
        }
    }

    public TreeNode get(int value) {
        if (value == data) {
            return this; //returns THIS TreeNode
        }

        if (value < data) {
            //traverse left children
            if (leftChild != null) {
                return leftChild.get(value); //get() method of TreeNode class , this is not a getter method
            }

        } else { // if value > data
            //traverse right children
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        //if not found
        return null;

    }

    public int min() { //this is the LEFTMOST leftChild  of BST
        if (leftChild == null) {
            return data;
        } else { // keep calling min() on leftChild
            return leftChild.min();
        }
    }

    public int max(){ //this is the RIGHTMOST rightChild of BST
        if(rightChild == null){
            return data;
        }else { //keep calling max() on rightChild
            return rightChild.max();
        }

    }


    public void traverseInOrder() {
        //this reminds me of recursion?!

        //if leftChild exists, traverse leftChildren first
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }

        //one left traversal returns (void) , print THIS data
        System.out.print(data + ", ");

        //next, if  rightChild exists, traverse rightChildren
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }

    }

    public void traversePreOrder(){
        System.out.print(data+", ");

        if(leftChild != null){
            leftChild.traversePreOrder();
        }

        if(rightChild != null){
            rightChild.traversePreOrder();
        }
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
