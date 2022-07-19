package SortAlgorithms;

public class RadixSort {

    public static void main(String[] args) {
        int[] radixArray = {4725,4586,1330,8792,1594,5729};

        radixSort(radixArray,4,10);

        for(int i=0;i<radixArray.length;i++){
            System.out.println(radixArray[i]);
        }
    }

    //input is the entire array // Radix is base 10 // width is 4 (length of each individual element of the array)
    public static void radixSort(int[] input, int width, int radix){

        //NOT traversing the array, we are traversing the positions from 0 to width
        // 0 , 10s , 100s ,1000s position
        for(int i=0;i<width;i++){
            radixSingleSort(input,i,radix);
        }

    }

    //input = passing the entire input array
    //position is "i"  // radix is base 10
    public static void radixSingleSort(int[] input, int position, int radix){

        //number of items in input array //eg 6
        int numItems = input.length;
        //initializing the countArray to the size of the radix, eg 10 (0 - 9)
        int[] countArray = new int[radix];

        //for - each loop over the input array
        // value eg 4725
        for(int value : input){
            int DIGIT = getDigit(value,position,radix);
            countArray[DIGIT]++;
        }

        //adjusting the counts of the above count array
        //we are setting count of jth element = count of jth element + count of j-1 th element
        //this is for STABLE sort

        //iterating over the count array
        //starting at j = 1, as j=0 does not have j-1
        for(int j = 1; j<radix; j++){

            countArray[j] = countArray[j]+countArray[j-1];

        }

        //below we are implementing STABLE COUNTING SORT

        //initializing temp array, length of temp array = length of input array
        int[] temp = new int[numItems];

        //traversing over the input and temp arrays
        //starting at the right most of the arrays and then decrementing
        for(int INDEX = numItems - 1; INDEX>=0; INDEX--){

            int DIGIT = getDigit(input[INDEX],position,radix);
            //decrementing the count array for that particular digit //for array 0 based indexing
            //resulting count is the index in temp array where we place the input[INDEX] value
            int tempINDEX = --countArray[DIGIT];
            temp[tempINDEX] = input[INDEX];

        }

        //copying the elements of the temp array to the input array

        for(int INDEX=0;INDEX<numItems;INDEX++){
            input[INDEX] = temp[INDEX];
        }



    }


    //position  = 0 ,10s,100s,1000s etc in this case
    //value = the integer 4 digit no. in this case
    //radix, digits of base 10
    public static int getDigit(int value,int position,int radix){
        return (value / (int) Math.pow(radix,position)) % radix;
    }



}
