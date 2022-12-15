package lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class HW11 {
    /**
     * Changes places of two elements in given array
     * @param array of any type
     * @param index1 one index
     * @param index2 another index
     * @return array with the swapped elements
     */
    public static <T> T[] changePlace(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length) {
            System.out.printf("Index %d is out of bounds, provided array has %d elements.\n", index1, array.length);
        } else if (index2 < 0 || index2 >= array.length) {
            System.out.printf("Index %d is out of bounds, provided array has %d elements.\n", index2, array.length);
        } else {
            T element = array[index1];
            array[index1] = array[index2];
            array[index2] = element;
        }
        return array;
    }

    /**
     * Converts array to ArrayList
     * @param array given array
     * @return ArrayList
     */
    public static <T> ArrayList<T> arrayToArrayList (T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"class", "interface", "object", "exception", "collection"};
        System.out.println(Arrays.toString(changePlace(intArray, 1, 3)));
        System.out.println(Arrays.toString(changePlace(strArray, 1, 3)));
        System.out.println(arrayToArrayList(strArray));

        Box<Orange> boxOranges1 = new Box<>();
        Box<Orange> boxOranges2 = new Box<>();
        Box<Apple> boxApples1 = new Box<>();
        boxOranges1.addFruit(new Orange(80));
        boxOranges1.addFruit(new Orange(100));
        boxOranges2.addFruit(new Orange(120));
        boxOranges2.addFruit(new Orange(110));
        boxOranges2.addFruit(new Orange(130));
        boxApples1.addFruit(new Apple(80));
        boxApples1.addFruit(new Apple(110));
        boxApples1.addFruit(new Apple(100));
        boxApples1.addFruit(new Apple(120));
        boxOranges1.displayBox();
        boxOranges2.displayBox();
        boxApples1.displayBox();
        boxOranges1.getBoxWeight();
        boxOranges2.getBoxWeight();
        boxApples1.getBoxWeight();
        System.out.println(boxOranges1.compare(boxApples1));
        System.out.println(boxApples1.compare(boxOranges2));
        boxOranges1.moveToAnotherBox(boxOranges2);
        boxOranges1.displayBox();
        boxOranges2.displayBox();
    }
}