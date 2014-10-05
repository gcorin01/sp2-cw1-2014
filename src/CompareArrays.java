import java.util.ArrayList;
import java.util.Scanner;

public class CompareArrays {
	private static final int ARRAY_SIZE     = 100;
	private static final int SENTINEL_VALUE = 0;

	public static void main(String[] args) {
		int[] array1 = new int[ARRAY_SIZE];
		int[] array2 = new int[ARRAY_SIZE];

		array1 = fillArray("array 1");
		array2 = fillArray("array 2");

		if (array1.length == 0 && array2.length == 0) {
			System.out.println("Both arrays are empty");
		} else {
			System.out.println("Value(s) entered in array 1: "
			        + getValueEntered(array1));
			System.out.println("Value(s) entered in array 2: "
			        + getValueEntered(array2));
			System.out
			        .println("Value(s) occurring in both arrays (intersection): "
			                + getintersection(array1, array2));
			// System.out.println("Number of intersections: ");
			// System.out.println("Values occurring only in the first array: ");
			// System.out.println("Values occurring only in the second array: ");
		}

		/*
		 * Ignore repeated occurrences of a particular value in the data, so
		 * check each value to see whether it already occurs in the array before
		 * storing it. Store those values in the first array array1 and array2.
		 * Arrays should contain a set (which could be empty) of distinct
		 * integer value Exclude the terminating zero from array
		 */
	}

	// Enter method comment here
	private static int[] fillArray(String arrayNumber) {
		ArrayList<Integer> tempArray = new ArrayList<Integer>();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your first integer for " + arrayNumber
		        + " (To finish, enter \"0\" (zero, without quotes):");

		int tempInput = input.nextInt();

		if (tempInput != SENTINEL_VALUE) {
			do {
				tempArray.add(tempInput);

				System.out.println("Enter your next integer for " + arrayNumber
				        + "(Enter 0 to finish):");
				tempInput = input.nextInt();
			} while (tempInput != SENTINEL_VALUE);
		} else {
			// input.close();
		}

		int[] outputArray = new int[tempArray.size()];
		int index = 0;

		for (int element : tempArray) {
			outputArray[index] = element;
			index++;
		}
		return outputArray;
	}

	// Enter method comment here
	private static String setValueEntered(int[] array) {
		int arraySize = array.length;
		String output = "";

		for (int element : array) {
			if (arraySize == 1) {
				output = output + element;
			} else {
				output = output + element + ", ";
			}
			arraySize--;
		}
		return output;
	}

	// Enter method comment here
	private static String getValueEntered(int[] array) {
		String output = setValueEntered(array);
		return output;
	}

	// Enter method comment here
	private static String setIntersection(int[] array1, int[] array2){
        String intersection = "";
        int matchFound = 0;
        
        for (int element : array1) {
            for (int value : array2) {
              if (element == value) {
                  intersection = intersection + value + ", ";
                  matchFound++;
                break;
              }
          }
        }
        
        if (matchFound == 0) {
        	intersection = "No intersection found";
        } else {
        	intersection = intersection.substring(0, (intersection.length()-2));
        }
        return intersection;
    }

	// Enter method comment here
	private static String getintersection(int[] array1, int[] array2) {
		String intersection = setIntersection(array1, array2);

		return intersection;
	}
}
