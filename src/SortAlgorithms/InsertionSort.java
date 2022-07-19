package SortAlgorithms;

public class InsertionSort {


    public static void main(String[] args) {

        int[] intArray = {20,35,-15,7,55,1,-22};

        //we assume that index 0 is sorted, so we start for loop at index 1(unsorted)
        for(int firstUnsortedIndex = 1; firstUnsortedIndex<intArray.length; firstUnsortedIndex++){

            //newElement is the firstUnsortedElement that we wish to insert in its sorted place
            int newElement = intArray[firstUnsortedIndex];

            //intiializing i outside the loop, as it has to be used outside the loop later
            int i;

            //loop for shifting elements of the array
            for(i=firstUnsortedIndex; i>0 && intArray[i-1]>newElement; i--){
                intArray[i] = intArray[i-1];
            }

            intArray[i] = newElement;

        }


        for(int i = 0 ; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }

    }

}
