package SortAlgorithms;

public class InsertionSortRecursion {



    public static void main(String[] args) {

        int[] intArray = {20,35,-15,7,55,1,-22};

        insertionSortRecursive(intArray,intArray.length);

        for(int i = 0 ; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }

    }

    //input is the input array // numItems is the array length
    public static void insertionSortRecursive(int[] input, int numItems){
        if(numItems < 2){
            return; //break when numItems(array length) becomes 1
        }

        //decrement numItems by 1 for every recursive call
        insertionSortRecursive(input, numItems-1);

        //when there are 2 elements left, index 1 of array becomes newElement
        //when there are 3 elements left, index 2 of array becomes newElement
        //and so on...
        int newElement = input[numItems - 1];

        //below code is same as the iterative insertion sort
        int i;
        for(i=numItems-1;i>0 && input[i-1]>newElement;i--){
            input[i] = input[i-1];
        }

        input[i] = newElement;

    }



}
