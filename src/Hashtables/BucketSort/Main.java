package Hashtables.BucketSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // i think that we are assuming the intArray will hold only two-digit numbers.... as for hashing we are considering the digit in the 10's position (returning number/10)... also, as we are initializing the bucket array to campacity 10 to HASH the 10's position digit in the respective bucket index
        int[] intArray = {54,46,83,66,95,92,43};

        bucketSort(intArray);

        for(int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }

    }

    public static void bucketSort(int[] input){
        List<Integer>[] buckets = new List[10]; //creating bucket array of class(interface) List

        for(int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList<Integer>(); //initializing an ArrayList at each individual bucket position.. this is possible as the array is made up of List(interface) elements
        }

        //scattering step
        for(int i=0;i<input.length;i++){
            int hashedIndex = hash(input[i]);
            buckets[hashedIndex].add(input[i]);
        }

        //sorting elements in individual buckets
        for(List bucket:buckets){
            Collections.sort(bucket); //this uses adaptive merge sort //STABLE sort
        }

        //merge or gathering step...
        int j = 0; //this index tracks the input[] array
        //traversing the buckets array
        for(int i=0;i<buckets.length;i++){
            //traversing the arraylist in individual buckets
            for(int value:buckets[i]){
                input[j++] = value; //assigning the value into the input[] array
            }
        }


    }

    public static int hash(int value){
        return value / (int) 10;
    }



}
