package lesson02;

import java.util.Arrays;

import static java.lang.Math.abs;

public class HW02 {
    /**
     * Creates random value between min and max
     * @param min minimum random value
     * @param max maximum random value
     * @return random value
     */
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Creates an array with random values
     * @param arraySize the desired size of array
     * @param min min random value
     * @param max max random value
     * @return the generated array
     */
    public static int[] randomArray(int arraySize, int min, int max) {
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = random(min, max);
        }
        return array;
    }

    /**
     * Changes 0 to 1 and vice versa in a provided array
     * @param array single dimensional array of integers
     */
    public static void task01(int[] array) {
        int[] modifiedArray = new int[array.length];
        System.out.println("Task 01:");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                modifiedArray[i] = 1;
            } else {
                modifiedArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString(modifiedArray));
    }

    /**
     * Creates an array with selected size and values in progression +3
     * @param arraySize the desired size of array
     */
    public static void task02(int arraySize) {
        int[] array = new int[arraySize];
        int initialValue = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
            initialValue += 3;
        }
        System.out.println("\nTask 02:");
        System.out.println(Arrays.toString(array));
    }

    /**
     * Changes array values with condition: double the value if it is lower than 6
     */
    public static void task03() {
        int[] initialArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] modifiedArray = new int[initialArray.length];
        for(int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] < 6) {
                modifiedArray[i] = initialArray[i] * 2;
            } else {
                modifiedArray[i] = initialArray[i];
            }
        }
        System.out.println("\nTask 03:");
        System.out.println(Arrays.toString(initialArray));
        System.out.println(Arrays.toString(modifiedArray));
    }

    /**
     * Creates an array with diagonal elements = 1
     * @param arraySize the desired size of array
     */
    public static void task04(int arraySize) {
        int[][] array = new int[arraySize][arraySize];
        System.out.println("\nTask 04:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Searches for min and max values in a provided array of integers
     * @param array single dimensional array of integers
     */
    public static void task05(int[] array) {
        int minValue = array[0];
        int maxValue = array[0];
        System.out.println("\nTask 05:");
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        System.out.println("Min: " + minValue);
        System.out.println("Max: " + maxValue);
    }

    /**
     * Checks if the sum of left side values is equal to the sum of right side values
     * @param array single dimensional array of integers
     * @return true if both sides of an array are equal
     */
    public static boolean task06(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        System.out.println("\nTask 06:");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                sumLeft += array[j];
            }
            for (int k = i + 1; k < array.length; k++) {
                sumRight += array[k];
            }
            if (sumLeft == sumRight) {
                System.out.println(sumLeft + " = " + sumRight);
                System.out.println("The left side of the array is equal to the right side");
                return true;
            } else {
                sumLeft = 0;
                sumRight = 0;
            }
        }
        System.out.println("The left side of the array is not equal to the right side");
        return false;
    }

    /**
     * Rotates array both ways with any step
     * @param array single dimensional array of integers
     * @param n number of steps to move right or left (positive or negative)
     */
    public static void task07(int[] array, int n) {
        int[] modifiedArray = new int[array.length];
        // defining the starting index with any value
        int newIndex;
        if (n < 0) {
            newIndex = abs(n) % array.length;
        } else if (n % array.length == 0) {
            newIndex = 0;
        } else {
            newIndex = array.length - n % array.length;
        }
        // rotating the array
        for (int i = 0; i < array.length; i++) {
            modifiedArray[i] = array[newIndex];
            newIndex = (newIndex + 1) % array.length;
        }
        System.out.println("\nTask 07:");
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(modifiedArray) + " rotation with step " + n);
    }

    public static void main(String[] args) {
        task01(randomArray(15, 0 , 1));
        task02(8);
        task03();
        task04(5);
        task05(randomArray(15, 0 , 100));
        task06(randomArray(10, 1 , 4));
        task07(randomArray(10, 1 , 20), 38);
    }
}