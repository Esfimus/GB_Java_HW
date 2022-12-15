package lesson10;

import java.util.*;

public class HW10 {
    /**
     * Creates a set with unique string values from given array
     * @param array to process unique values
     */
    public static void uniqueValues(String[] array) {
        Set<String> stringSet = new HashSet<>(List.of(array));
        System.out.printf("Array consists of %d words:\n", array.length);
        System.out.println(Arrays.toString(array));
        System.out.printf("Array has %d unique words:\n", stringSet.size());
        System.out.println(stringSet + "\n");
    }

    /**
     * Creates hashmap with unique words as keys and the occurrences counts as values
     * @param array to process string values
     */
    public static void countWords(String[] array) {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String word : array) {
            if (!wordsMap.containsKey(word)) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, wordsMap.get(word) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {

        String[] stringArray = {"article", "airport", "orange", "chocolate", "variety",
                                "highway", "republic", "revenue", "solution", "orange",
                                "chocolate", "product", "vehicle", "aspect", "nature",
                                "orange", "chocolate", "intention", "highway", "memory"};
        uniqueValues(stringArray);
        countWords(stringArray);

        // Creating a phonebook with some entries
        PhoneBook myPB = new PhoneBook();
        PhoneBook.Person p01 = new PhoneBook.Person("Smith", "319-227-0387");
        myPB.add(p01);
        PhoneBook.Person p02 = new PhoneBook.Person("Parker", "804-965-9821");
        myPB.add(p02);
        PhoneBook.Person p03 = new PhoneBook.Person("Jackson", "503-774-6062");
        myPB.add(p03);
        PhoneBook.Person p04 = new PhoneBook.Person("Blane", "321-567-3824");
        myPB.add(p04);
        PhoneBook.Person p05 = new PhoneBook.Person("McKee", "207-662-4592");
        myPB.add(p05);
        PhoneBook.Person p06 = new PhoneBook.Person("Jackson", "563-456-9769");
        myPB.add(p06);
        PhoneBook.Person p07 = new PhoneBook.Person("Smith", "319-766-9402");
        myPB.add(p07);
        PhoneBook.Person p08 = new PhoneBook.Person("Smith", "319-984-8311");
        myPB.add(p08);
        myPB.add(p01);

        myPB.displayPhonebook();

        myPB.get("Jackson");
    }
}