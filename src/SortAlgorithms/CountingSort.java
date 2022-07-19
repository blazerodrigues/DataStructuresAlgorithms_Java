package SortAlgorithms;

public class CountingSort {
    public static void main(String[] args) {
        int[] intArray = {2,5,9,8,2,8,7,10,4,3};

        countingSort(intArray,1,10);

        for(int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    //min and max indicate the min and max element of the array
    public static void countingSort(int[] input, int min, int max){

        //max - min + 1 //eg 10-1+1 = 10 //eg 10-0+1=11 //we are adding +1 for initializing length
        //since it is an int array, naturally all array elements are 0 initially
        int[] countArray = new int[(max-min)+1];

        //iterating over input array
        for(int i=0;i<input.length;i++){

            countArray[input[i] - min]++; //eg 6-1 = 5 // eg 6-0 = 6

        }

        int j = 0; //j iterates over input array
        //iterating from min value to max value
        for(int i=min; i<=max;i++){
            //loop to check that non-zero count exists in the count array for "i" value
            //i-min to make it 0 based index  //eg 6-1 = 5 // eg 6-0 = 6
            while(countArray[i-min]>0){ // this is useful of the same element exists multiple times in the array
                input[j++] = i; //copying countArray elements to input array
                countArray[i-min]--; //decrementing the count
            }
        }

    }


}
