import java.util.Scanner;

public class CompareArrays {
	private static final int ARRAY_SIZE     = 100;
	private static final int TRIGGER_NUMBER = 0;
	
	public static void main(String[] args)
	{
<<<<<<< HEAD
		int[] Array1 = new int[ARRAY_SIZE];
		int[] Array2 = new int[ARRAY_SIZE];

		
		Scanner input = new Scanner(System.in);
		
		
		// Create empty integer array Array1 that will hold up to 100 integers.

		// Create empty integer arrays Array2 that will hold up to 100 integers.

=======
>>>>>>> 9d86d9d0c1931aa06d8135be7326f1204dd19685

		
		/* Repeatedly read integer values from the keyboard until the user types "0" (zero, without the quotes).
		 * Ignore repeated occurrences of a particular value in the data, so check each value to see whether it already occurs in the array before storing it.
		 * Store those values in the first array Array1
		 * Array should contain a set (which could be empty) of distinct integer value
		 * Exclude the terminating zero from array
		*/
		
		
		/* Repeatedly read integer values from the keyboard until the user types "0" (zero, without the quotes).
		 * Ignore repeated occurrences of a particular value in the data, so check each value to see whether it already occurs in the array before storing it.
		 * Store those values in the first array Array2
		 * Array should contain a set (which could be empty) of distinct integer value
		 * Exclude the terminating zero from array
		*/		
		
		// Loop through both arrays and print out:
		System.out.println("Value entered in the first array: ");
		System.out.println("Value entered in the second array: ");
		System.out.println("Values occurring in both arrays (intersection): ");
		System.out.println("Number of intersections: ");
		System.out.println("Values occurring only in the first array: ");
		System.out.println("Values occurring only in the second array: ");
	}
}
