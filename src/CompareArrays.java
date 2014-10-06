import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to compare the values of two arrays. This is Coursework One to be
 * submitted for the purposes of Birkbeck, University of London's module
 * Software and Programming II (2014_15).
 * 
 * @author Gabriel Corinaldesi (gcorin01)
 * @version 1.0, 06/10/2014
 */
public class CompareArrays {
    private static final int ARRAY_SIZE     = 100;
    private static final int SENTINEL_VALUE = 0;

    public static void main(String[] args) {
        int[] array1 = new int[ARRAY_SIZE];
        int[] array2 = new int[ARRAY_SIZE];

        array1 = fillArray("array 1");
        array2 = fillArray("array 2");

        String array1Values = getValueEntered(array1);
        String array2Values = getValueEntered(array2);

        String[] intersection = new String[2];
        intersection = getIntersection(array1, array2);
        String numberOfCommonValues = intersection[0];
        String commonValues = intersection[1];

        String uniqueValuesInArray1 = getUniqueValues(array1, array2);
        String uniqueValuesInArray2 = getUniqueValues(array2, array1);

        if (array1.length == 0 && array2.length == 0) {
            System.out.println("Both arrays are empty");
        } else {
            System.out.println("Value(s) entered in array 1: " + array1Values);
            System.out.println("Value(s) entered in array 2: " + array2Values);
            System.out
                    .println("Value(s) occurring in both arrays (intersection): "
                            + commonValues);
            System.out.println("Number of intersections: "
                    + numberOfCommonValues);
            System.out.println("Values occurring only in the first array: "
                    + uniqueValuesInArray1);
            System.out.println("Values occurring only in the second array: "
                    + uniqueValuesInArray2);
        }
    }

    /**
     * Takes the input from the user and creates and array of integers.
     * <p>
     * The user can enter as many values as wanted but the program is not
     * designed to check when and if it exceeds the max size of the array
     * calling this method which holds the inputs from the user. Also, no input
     * validation is made so the program will crush if a non integer value is
     * entered by the user.
     * <p>
     * This method calls another method
     * <code>removeDuplicates<code> to remove duplicate values entered by the user, if any.
     * <p>
     * This method calls another method <code>listToArray<code> to convert ArrayLists to arrays.
     * 
     * @param arrayNumber
     *            the name of the array to fill.
     * @return the set of numbers entered by the user.
     * @since 0.1
     */
    public static int[] fillArray(String arrayNumber) {
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

        tempArray = removeDuplicates(tempArray);

        int[] outputArray = new int[tempArray.size()];
        outputArray = listToArray(tempArray);

        return outputArray;
    }

    /**
     * Sends the array of values entered by the user to be separated by a comma
     * and a space.
     * 
     * @param array
     *            if any, contains the values to be separated.
     * @return a string of values separated by a comma and a space.
     * @since 0.1
     */
    public static String getValueEntered(int[] array) {
        String output = setValueEntered(array);

        return output;
    }

    /**
     * Separates array values with a comma and a space unless it is the last
     * value of the array.
     * 
     * @param array
     *            if any, contains the values to be separated.
     * @return if any, a string of values separated by a comma and a space.
     * @since 0.1
     */
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

    /**
     * Sends two arrays of values entered by the user to be compared in order to
     * establish whether any intersection if found and, if any, how many are
     * found.
     * 
     * @param array1
     *            the first set of numbers entered by the user.
     * @param array2
     *            the second set of numbers entered by the user.
     * @return if any, the intersection values separated by a comma and a space
     *         together with the number of occurrencies.
     * @since 0.2
     */
    public static String[] getIntersection(int[] array1, int[] array2) {
        String[] intersection = new String[2];
        intersection = setIntersection(array1, array2);

        return intersection;
    }

    /**
     * Compares two arrays to find the common values, if any.
     * 
     * @param array1
     *            the first set of numbers entered by the user.
     * @param array2
     *            the second set of numbers entered by the user.
     * @return a multidimensional array containing the common values found in
     *         both arrays and the number of intersections found, if any.
     * @since 0.2
     */
    private static String[] setIntersection(int[] array1, int[] array2) {
        String[] intersection = new String[2];
        String uniqueInArray1 = "";
        String uniqueInArray2 = "";
        String commonValues = "";
        String numberOfCommonValues = "";
        int matchFound = 0;

        for (int element : array1) {
            for (int value : array2) {
                if (element == value) {
                    commonValues = commonValues + value + ", ";
                    matchFound++;
                    break;
                } else {
                    uniqueInArray1 = uniqueInArray1 + element + ", ";
                    uniqueInArray2 = uniqueInArray2 + value + ", ";
                }
            }
        }

        if (matchFound == 0) {
            commonValues = "No intersection found";
        } else {
            commonValues = commonValues.substring(0,
                    (commonValues.length() - 2));
        }

        numberOfCommonValues = "" + matchFound;
        intersection[0] = numberOfCommonValues;
        intersection[1] = commonValues;

        return intersection;
    }

    /**
     * Takes out from the user inputs any duplicate value if any are found.
     * <p>
     * This method calls another method
     * <code>removeDuplicates<code> to remove duplicate values entered by the user, if any.
     * <p>
     * This method calls another method <code>listToArray<code> to convert ArrayLists to arrays.
     * 
     * @param array
     *            the input from the user with possible duplicated values.
     * @return a set of unique integers.
     * @since 0.3
     */
    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> array) {
        ArrayList<Integer> uniqueValuesArray = new ArrayList<Integer>();

        for (int i = 0; i <= array.size() - 1; i++) {
            int j = i + 1;
            boolean dupe = false;

            while (j <= array.size() - 1) {
                if (array.get(i) == array.get(j)) {
                    dupe = true;
                }
                j++;
            }
            if (!dupe) {
                uniqueValuesArray.add(array.get(i));
            }
        }

        return uniqueValuesArray;
    }

    /**
     * Sends two arrays of values entered by the user to be compared in order to
     * find unique values contained in <code>array1<code>.
     * 
     * @param array1
     *            the first set of numbers entered by the user.
     * @param array2
     *            the second set of numbers entered by the user.
     * @return if any, the unique values found in <code>array1<code>.
     * @since 0.4
     */
    public static String getUniqueValues(int[] array1, int[] array2) {
        String uniqueValues = setUniqueValues(array1, array2);

        return uniqueValues;
    }

    /**
     * Compares two arrays to find <code>array1<code> unique values, if any.
     * 
     * @param array1
     *            the first set of numbers entered by the user.
     * @param array2
     *            the second set of numbers entered by the user.
     * @return a string containing the unique values found in
     *         <code>array1<code>.
     * @since 0.4
     */
    private static String setUniqueValues(int[] array1, int[] array2) {
        String uniqueValues = "";
        ArrayList<Integer> uniqueValuesArray = new ArrayList<Integer>();

        for (int i = 0; i <= array1.length - 1; i++) {
            boolean dupe = false;
            int j = 0;
            while (j <= array2.length - 1) {
                if (array1[i] == array2[j]) {
                    dupe = true;
                }
                j++;
            }
            if (!dupe) {
                uniqueValuesArray.add(array1[i]);
            }
        }

        uniqueValuesArray = removeDuplicates(uniqueValuesArray);

        int index = uniqueValuesArray.size();
        int[] outputArray = new int[index];
        outputArray = listToArray(uniqueValuesArray);

        uniqueValues = setValueEntered(outputArray);

        return uniqueValues;
    }

    /**
     * Converts an ArrayList to array.
     * 
     * @param tempArray
     *            an ArrayList to be converted to an array.
     * @return a converted ArrayList to array.
     * @since 0.4
     */
    private static int[] listToArray(ArrayList<Integer> tempArray) {
        int arrayLength = tempArray.size();
        int[] outputArray = new int[arrayLength];
        int index = 0;

        for (int element : tempArray) {
            outputArray[index] = element;
            index++;
        }

        return outputArray;
    }
}
