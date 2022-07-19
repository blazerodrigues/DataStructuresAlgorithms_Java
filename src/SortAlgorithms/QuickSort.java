package SortAlgorithms;

public class QuickSort {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        quickSort(intArray, 0,intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

    //start index follows conventional array index(base 0)
    //end element is index+1 (accounting for array length)
    public static void quickSort(int[] input, int start, int end) {

        //breaking condition is partitioned array result should have atleast one element
        if (end - start < 2) {
            return;
        }

        //method returns new index of the pivot element
        int pivotIndex = partition(input, start, end);

        //recursive call to quickSort
        //pivotIndex is excluded in both cases
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);

    }

    public static int partition(int[] input, int start, int end) {

        //the first element of the array is the pivot
        int pivot = input[start];

        //i and j are used to traverse the array from start and end positions respectively
        int i = start;
        int j = end;

        //if i is not less than j, break out of the loop
        while (i < j) {

            //empty loop to traverse the array from right to left, searching for element lesser than the pivot
            while (i < j && input[--j] >= pivot) ;
            //when either of the above conditions is false
            //check if i>j, loop broke because j found an element less than the pivot
            if (i < j) {
                input[i] = input[j];
            }

            //LOGIC:
            //backup the pivot element
            //find  smaller element using j then swap with i position
            //find greater element using i and swap with j position
            //finally if i>j, break and set pivot at


            //SIMILARLY
            //empty loop body
            //traversing array from left to right, incrementing i till an element is found which is greater than the pivot
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }


        }

        //assigning pivot element to j
        //(i think we can use i also instead of j, as  i = j when the above while loop is broken)
        input[j] = pivot;
        return j;

    }

}
