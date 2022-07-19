package Experiment;

public class Experiment {

    public static void main(String[] args) {

        int[] intArray = {20,35,-15,7,55,1,-22};

        for(int i=0;i<intArray.length-1;i++){
            for(int j=i+1;j<intArray.length;j++){

                if(intArray[i]>intArray[j]){
                    int temp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = temp;

                }

            }
        }

        System.out.println("Bubble sort: ");

        for(int i = 0 ; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }

    }
}
