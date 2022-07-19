package SearchAlgorithms.BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};

        System.out.println(iterativeBinarySearch(intArray, -15));
        System.out.println(iterativeBinarySearch(intArray, 35));
        System.out.println(iterativeBinarySearch(intArray, 888));
        System.out.println(iterativeBinarySearch(intArray, 1));

        System.out.println("------------------------------------------------");

        System.out.println(recursiveBinarySearch(intArray, -15));
        System.out.println(recursiveBinarySearch(intArray, 35));
        System.out.println(recursiveBinarySearch(intArray, 888));
        System.out.println(recursiveBinarySearch(intArray, 1));
    }

    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length; //index - one greater than conventional array 0 based indeixing

        //loop breaks when start<end, meaning, array has been divided (several times) and we are now left with  single element
        while (start < end) {
            int midpoint = (start + end) / 2;
            System.out.println("Midpoint: " + midpoint);
            if (input[midpoint] == value) {
                return midpoint;
            } else if (input[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value); // method overloading // this is so that main method is not burdened with recursive method's requirement of being provided INITIAL start and end values

    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        //break condition for recursion
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;
        System.out.println("Midpoint = " + midpoint);

        if (input[midpoint] == value) {
            return midpoint;
        } else if (input[midpoint] < value) {
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        } else { //if input[midpoint] > value
            return recursiveBinarySearch(input, start, midpoint, value);

        }


    }
}
