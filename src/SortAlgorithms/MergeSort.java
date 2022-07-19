package SortAlgorithms;

public class MergeSort {

    public static void main(String[] args) {

        int[] intArray = {20,35,-15,7,55,1,-22};

        mergeSort(intArray,0,intArray.length);

        for(int i = 0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }

    }

    //start follows conventional array indexes (0 based)
    //end is index+1 (accounting for array length)
    public static void mergeSort(int[] input,int start, int end){

        //checking if array has atleast one element
        //this is the break condition for recursion
        if(end - start < 2){
            return;
        }

        int mid = (start+end)/2;

        //(middle element is placed in the second half of the array in this implementation)
        //recursive calls
        mergeSort(input,start,mid); //first half
        mergeSort(input,mid,end); //second half

        //the left and right arrays are merged to form INPUTstring
        //inside this method implementation, later, TEMP array is used for shifting elements internally
        merge(input,start,mid,end);

    }

    public static void merge(int[] input, int start, int mid, int end){

        //optimization1 : principle - Left and Right arrays are already sorted
        //so if lastElementOfLEFTarray <= firstElementOfRIGHTarray
        //then dont make any changes to input array as combination of the two arrays will be sorted
        if(input[mid-1]<=input[mid]){
            return;
        }

        int i = start; //variable to iterate over left array
        int j = mid; //variable to iterate over right array

        int tempIndex = 0; //index of temp array

        //end - start gives length of left+right arrays
        int[] temp = new int[end - start];

        //break out of loop if we reach the end of either left or right array
        while(i<mid && j<end){
            //insert the smaller element in the temp array and increment respective index
            temp[tempIndex++] = input[i]<=input[j] ? input[i++] : input[j++];
        }

        //above and below code is also an OPTIMIZATION2
        //CASE1: if we reach the end of LEFT array , remaining RIGHT array elements remain as they are!
        //CASE2: if we reach the end of the RIGHT array, remaining LEFT array elements are MOVED to the extreme right of the original array!
        //so we do not need to copy the elements to TEMP in CASE1 or CASE2
        //optimization1 and optimization2 work on the same principle.

        //System.arraycopy(sourceArray, sourceIndex, destArray, destIndex, lengthOfMOVED)
        //if we reach the end of the RIGHT array, remaining LEFT array elements are MOVED to the extreme right of the original array(CASE2)
        // input , i : start index of remaining elements of the left array
        // input , start+tempIndex : start index of the extreme right of the RIGHT array
        //mid - i : length of array to be MOVED
        System.arraycopy(input,i,input,start+tempIndex,mid-i);

        //copying the TEMP array to the INITIAL part of the original input array
        System.arraycopy(temp,0, input, start, tempIndex);



    }

}
