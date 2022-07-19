package SortAlgorithms;

public class ShellSort {

    public static void main(String[] args) {

        int[] intArray = {20,35,-15,7,55,1,-22};

        //first gap = arrayLength/2 , MIN gap 1 , every iteration gap HALVES
        for(int gap = intArray.length/2; gap>0; gap = gap/2){


            for(int i = gap; i < intArray.length; i++){

                int newElement = intArray[i]; //i=gap

                int j = i;

                while(j>=gap && intArray[j-gap]>newElement){
                    intArray[j] = intArray[j-gap];
                    j = j-gap;
                }

                intArray[j] = newElement;
            }

        }


        for(int i = 0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }

    }

}
