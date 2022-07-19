package Trees.BinarySearchTrees;

public class Tree {

    private TreeNode root; //this field is all we need, as, if we know the root we can traverse the binary search tree

    public void insert(int value){
        if(root == null){
            root = new TreeNode(value);
        }else{
            root.insertTreeNode(value); //calling insertTreeNode method of the TreeNode class
        }
    }

    public TreeNode get(int value){
        if(root != null){
            return root.get(value);
        }

        return null;
    }

    public void delete(int value){
        //root changes only if root is the node that is deleted, else the same root is returned
        root = delete(root,value);
        //delete(root,value) returns TreeNode root.
    }

    private TreeNode delete(TreeNode subtreeRoot, int value){

        if(subtreeRoot == null){
            return subtreeRoot; //returning null only!!!
        } //for subtree it would mean that if we are checking the left or right subtree and of the root is null, means that left or right subtree DOES NOT EXIST!!!

        //value is less than the subtreeRoot
        if(value<subtreeRoot.getData()){
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(),value));
        }//value is greater than the subtreeRoot
        else if(value>subtreeRoot.getData()){
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(),value));
        }//value is equal to the subtreeRoot and it has to be deleted.
        else{
            //This is applicable for CASE 1 deletion: When deletion node is a leaf node //and CASE 2 deletion: When deletion node has  one child

            if(subtreeRoot.getLeftChild() == null){
                return subtreeRoot.getRightChild(); // this returns right child if it exists (CASE2), else returns null. Returning null would mean that recusively the Parent's left or right child would be set to null (CASE1)
            }else if(subtreeRoot.getRightChild() == null){
                return subtreeRoot.getLeftChild();
            }

            //Case 3 !!! : when deletion node has two children
            //we set MIN value from the deletion nodes right subTree as the deletion node's value
            //we then delete the MIN value node from the deletion node's right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min()); // we are over-writing MIN value as the deletion node's value // we are not actually removing that node
            //deleting the node that has the smallest value in the right subtree // since we have already written that value in subtreeRoot node above, we can pass subtreeNode.getdata() as the second input parameter "value" in the delete(root,value) recursive method
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(),subtreeRoot.getData()));

        }

        //if node to be deleted is not found, return SAME subtreeRoot as was inputted in the recursive method
        return subtreeRoot;

    }

    public int min(){
        if(root == null){
            return Integer.MIN_VALUE;
        }else {
            return root.min();
        }
    }

    public int max(){
        if(root == null){
            return Integer.MAX_VALUE;
        }else{
            return root.max();
        }
    }

    public void traverseInOrder(){
        if(root != null){
            root.traverseInOrder();
        }
    }

    public void traversePreOrder(){
        if(root != null){
            root.traversePreOrder();
        }
    }


}
