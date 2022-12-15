package lesson10;

import java.util.*;

public class PhoneBook {

    private final HashMap<String, List<String>> phoneBook = new HashMap<>();

    /**
     * Checks the phonebook's content and adds or rejects entries
     * @param person object from a nested class
     */
    public void add(Person person) {
        String name = person.getName();
        String phone = person.getPhoneNumber();
        if (!phoneBook.containsKey(name)) {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phone);
            phoneBook.put(name, phoneList);
            System.out.printf("New entry was created: %s %s.\n", name, phone);
        } else if (phoneBook.containsKey(name) && phoneBook.get(name).contains(phone)) {
            System.out.printf("%s with phone number %s already exists.\n", name, phone);
        } else {
            phoneBook.get(name).add(phone);
            System.out.printf("New phone number %s was successfully added to the existing entry %s.\n", phone, name);
        }
    }

    /**
     * Checks the phonebook entries for given name and outputs phone numbers
     * @param name for search
     */
    public void get(String name) {
        List<String> phoneNumbers;
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (Objects.equals(entry.getKey(), name)) {
                phoneNumbers = entry.getValue();
                System.out.printf("%s has %d phone number(s):\n", name, phoneNumbers.size());
                System.out.println(phoneNumbers);
                return;
            }
        }
        System.out.printf("No entries with name %s.\n", name);
    }

    /**
     * Displays phonebook with preset formatting
     */
    public void displayPhonebook() {
        System.out.println("\n-= My phonebook =-");
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.printf("%s: ", entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println();
    }

    /**
     * Nested class for creating a person with name and phone number
     */
    static class Person {

        private final String name;
        private String phoneNumber;

        public Person(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}