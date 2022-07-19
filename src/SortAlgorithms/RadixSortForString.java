package SortAlgorithms;

public class RadixSortForString {

    public static void main(String[] args) {
        String[] stringArray = {"bcdef","dbaqc","abcde","omadd","bbbbb"};

        radixSort(stringArray,5,26);

        for(int i=0;i<stringArray.length;i++){
            System.out.println(stringArray[i]);
        }
    }

    //input is the entire array // Radix is base 26 // width is 5 (length of each individual element of the array)
    public static void radixSort(String[] input, int width, int radix){

        //not traversing the array
        //initializing the position wrt the width, starting at the end of the width and then decrementing
        for(int i=width-1;i>=0;i--){
            radixSingleSort(input,i,radix);
        }

    }

    //input = passing the entire input array
    //position is "i"  // radix is base 26
    public static void radixSingleSort(String[] input, int position, int radix){

        //number of items in input array //eg 5
        int numItems = input.length;
        //initializing the countArray to the size of the radix, eg 26 (0 - 25)
        int[] countArray = new int[radix];

        //for - each loop over the input array
        // value eg 4725
        for(String value : input){
            int STRING = getString(value,position);
            countArray[STRING]++;
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
        String[] temp = new String[numItems];

        //traversing over the input and temp arrays
        //starting at the right most of the arrays and then decrementing
        for(int INDEX = numItems - 1; INDEX>=0; INDEX--){

            int STRING = getString(input[INDEX],position);
            //decrementing the count array for that particular digit //for array 0 based indexing
            //resulting count is the index in temp array where we place the input[INDEX] value
            int tempINDEX = --countArray[STRING];
            temp[tempINDEX] = input[INDEX];

        }

        //copying the elements of the temp array to the input array

        for(int INDEX=0;INDEX<numItems;INDEX++){
            input[INDEX] = temp[INDEX];
        }



    }


    //position  = 0 ,10s,100s,1000s etc
    //value = the string element of width 5
    public static int getString(String value,int position){
        //assume that the input array will have all lower case letters
        //subtracting a from value.charAt(position) to return array 0 based index value
        //eg c-a = 99-97 = 2 //2 will thus be the index of the count array whose count will be incremented
        return value.charAt(position) - 'a';
    }



}
