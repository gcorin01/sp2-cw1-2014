import java.util.Scanner;

public class CompareArrays {
    private static final int ARRAY_SIZE     = 100;
    private static final int TRIGGER_NUMBER = 0;

    public static void main(String[] args) {
        int[] array1 = new int[ARRAY_SIZE];
        int[] array2 = new int[ARRAY_SIZE];
        String output = "";

        array1 = fillArray("array1");
        array2 = fillArray("array2");
        

        for (int element : array1) {
            output = output + ", " + "element";
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
        int[] tempArray = new int[ARRAY_SIZE];
        int currentSize = 0;

        Scanner input = new Scanner(System.in);
        System.out
                .println("INSTRUCTIONS: type each integer you like followed by "
                        + "the ENTER key. To stop type \"0\"(zero, without the quotes) "
                        + "and hit the ENTER key. \n\nType your first integer for "
                        + arrayNumber + ": ");

        while (input.hasNextInt() && input.nextInt() != TRIGGER_NUMBER) {
            tempArray[currentSize] = input.nextInt();
            System.out.println("Please enter the next integer: ");
            currentSize++;
        }
        input.close();
        return tempArray;
        // System.out.println("Both arrays are empty");
    }
}
