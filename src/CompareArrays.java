import java.util.ArrayList;
import java.util.Scanner;

public class CompareArrays {
    private static final int ARRAY_SIZE     = 100;
    private static final int TRIGGER_NUMBER = 0;

    public static void main(String[] args) {
        int[] array1 = new int[ARRAY_SIZE];
        int[] array2 = new int[ARRAY_SIZE];
        String output = "";

        array1 = fillArray("array1");
        // array2 = fillArray("array2");

        int arraySize = array1.length;
        System.out.println("Initial size: " + arraySize); // debug
        for (int element : array1) {

            if (arraySize != 1) {
                output = output + element + ", ";
                arraySize = arraySize--;
                System.out.println("Loop: " + (arraySize--));  // debug
            } else {
                output = output + element;
            }

        }

        if (array1.length == 0 && array2.length == 0) {
            System.out.println("Both arrays are empty");
        } else {
            System.out.println("Value entered in array1: " + output);
            System.out.println("Value entered in array2: " + array2);
            // System.out.println("Values occurring in both arrays (intersection): ");
            // System.out.println("Number of intersections: ");
            // System.out.println("Values occurring only in the first array: ");
            // System.out.println("Values occurring only in the second array: ");
        }

        /*
         * Repeatedly read integer values from the keyboard until the user types
         * "0" (zero, without the quotes). Ignore repeated occurrences of a
         * particular value in the data, so check each value to see whether it
         * already occurs in the array before storing it. Store those values in
         * the first array array1 Array should contain a set (which could be
         * empty) of distinct integer value Exclude the terminating zero from
         * array
         */

        /*
         * Repeatedly read integer values from the keyboard until the user types
         * "0" (zero, without the quotes). Ignore repeated occurrences of a
         * particular value in the data, so check each value to see whether it
         * already occurs in the array before storing it. Store those values in
         * the first array array2 Array should contain a set (which could be
         * empty) of distinct integer value Exclude the terminating zero from
         * array
         */

        // Loop through both arrays and print out:

    }

    public static int[] fillArray(String arrayNumber) {
        int currentSize = 0;
        ArrayList<Integer> tempArray = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);
        System.out
                .println("INSTRUCTIONS: type each integer you like followed by "
                        + "the ENTER key. To stop type \"0\"(zero, without the quotes) "
                        + "and hit the ENTER key. \n\nType your first integer for "
                        + arrayNumber + ":");

        int tempInput = input.nextInt();
        
        if (tempInput != TRIGGER_NUMBER) {
            do {
                tempArray.add(tempInput);
                System.out.println(currentSize + " " + tempInput);  // debug
                currentSize++;
                System.out.println("Enter your next integer:");
                tempInput = input.nextInt();
            } while (tempInput != TRIGGER_NUMBER);
        } else {
            input.close();            
        }

        int[] array = new int[tempArray.size()];
        int index = 0;

        for (int element : tempArray) {
            array[index] = element;
            index++;
        }
        return array;
        // System.out.println("Both arrays are empty");
    }
}
