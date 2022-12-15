package lesson09;

import java.util.Random;

public class HW09 {

    /**
     * Checks given array and calculates the sum of all elements
     * only if all the elements are numbers. Exceptions are included.
     * @param array incoming string array
     */
    public static void multiDimArray(String[][] array) {
        try {
            int sum = 0;

            // checking array size
            for (String[] strings : array) {
                if (strings.length != 4 || array.length != 4) {
                    throw new MyArraySizeException("Wrong array size", strings.length, array.length);
                }
            }

            // checking if all elements are integers, calculating the sum
            for (int y = 0; y < array.length; y++) {
                for (int x = 0; x < array[y].length; x++) {
                    try {
                        sum += Integer.parseInt(array[y][x]);
                    } catch (Exception e) {
                        throw new MyArrayDataException("Wrong data", array[y][x], y, x);
                    }
                }
            }
            System.out.printf("Good, the sum of all numbers in this array is %d\n\n", sum);

        } catch (MyArraySizeException e) {
            System.out.printf("Wrong array size: %d x %d (should be 4 x 4).\n\n", e.getyTotal(), e.getxTotal());;
        } catch (MyArrayDataException e) {
            System.out.printf("Wrong data at x = %d, y = %d. \"%s\" is not a number\n\n", e.getX(), e.getY(), e.getCell());
        }
    }

    /**
     * Checks given array and calculates the sum of all elements
     * only if all the elements are numbers. Exceptions are thrown from other methods.
     * @param array incoming string array
     * @throws MyArraySizeException when the size of array is not 4 x 4
     * @throws MyArrayDataException when a cell contains anything but an integer
     */
    public static void multiDimArrayNoExceptions(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        // checking array size
        for (String[] strings : array) {
            if (strings.length != 4 || array.length != 4) {
                throw new MyArraySizeException("Wrong array size", strings.length, array.length);
            }
        }

        // checking if all elements are integers, calculating the sum
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                try {
                    sum += Integer.parseInt(array[y][x]);
                } catch (Exception e) {
                    throw new MyArrayDataException("Wrong data", array[y][x], y, x);
                }
            }
        }
        System.out.printf("Good, the sum of all numbers in this array is %d\n\n", sum);
    }

    /**
     * Displays the given array as a matrix
     * @param array incoming string array
     */
    public static void displayArray(String[][] array) {
        for (String[] strings : array) {
            for (String i : strings) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        // creating 4 x 4 array with random numbers
        String[][] arr1 = new String[4][4];
        for (int y = 0; y < arr1.length; y++) {
            for (int x = 0; x < arr1[y].length; x++) {
                arr1[y][x] = String.valueOf(random.nextInt(10));
            }
        }

        // creating an array with random numbers and wrong size
        String[][] arr2 = new String[3][5];
        for (int y = 0; y < arr2.length; y++) {
            for (int x = 0; x < arr2[y].length; x++) {
                arr2[y][x] = String.valueOf(random.nextInt(10));
            }
        }

        // creating 4 x 4 array with random numbers and one wrong value
        String[][] arr3 = new String[4][4];
        for (int y = 0; y < arr3.length; y++) {
            for (int x = 0; x < arr3[y].length; x++) {
                arr3[y][x] = String.valueOf(random.nextInt(10));
            }
        }
        arr3[1][2] = "j";

        // running the first method with two arrays
        displayArray(arr1);
        multiDimArray(arr1);
        displayArray(arr2);
        multiDimArray(arr2);

        // running the second method with one array
        try {
            displayArray(arr3);
            multiDimArrayNoExceptions(arr3);
        } catch (MyArraySizeException e) {
            System.out.printf("Wrong array size: %d x %d (should be 4 x 4).\n\n", e.getyTotal(), e.getxTotal());;
        } catch (MyArrayDataException e) {
            System.out.printf("Wrong data at x = %d, y = %d. \"%s\" is not a number\n\n", e.getX(), e.getY(), e.getCell());
        }
    }
}