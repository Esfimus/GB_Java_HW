package lesson03;

import java.util.Scanner;

public class HW03 {

    /**
     * Displays the menu and returns the input value
     * @return string value
     */
    public static String mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("________________________");
        System.out.println("""
                Select the game or exit:
                1 - Guess the number
                2 - Guess the word
                exit - close the app
                ________________________
                """);
        boolean isString = scanner.hasNextLine();
        if (isString) {
            return scanner.nextLine().toLowerCase();
        } else {
            return "";
        }
    }

    /**
     * Creates random value between min and max
     * @param min minimum random value
     * @param max maximum random value
     * @return random value
     */
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int winCounter = 0;
    public static int loseCounter = 0;

    /**
     * The game "Guess the number" allows user to enter only integer values, has 3 attempts to win, restarts with submenu and recursive function, allows to exit at any time, shows the result.
     */
    public static void guessNumber() {
        int randomNumber = random(0, 9);
        int tries = 3;
        int inputInt;
        String inputString;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""

                >>> Guess the number <<<

                The number is between 0 and 9.
                You have 3 attempts left.
                For exit type 'back'.
                """);
        System.out.printf("User: %d   Computer: %s\n\n", winCounter, loseCounter);
        do {
            // checking the input for integer values and comparing with the random value
            if (scanner.hasNextInt()) {
                inputInt = scanner.nextInt();
                scanner.nextLine();
                if (inputInt < randomNumber) {
                    System.out.printf("That was close but the number is higher than %d.\n", inputInt);
                    tries--;
                    System.out.printf("Attempts left: %d.\n", tries);
                } else if (inputInt > randomNumber) {
                    System.out.printf("That was close but the number is lower than %d.\n", inputInt);
                    tries--;
                    System.out.printf("Attempts left: %d.\n", tries);
                } else {
                    System.out.printf("\nCongratulations!!! You have pinned that sneaky number %d.\n", randomNumber);
                    winCounter++;
                    break;
                }
            } else {
                // checking for 'back' input (resetting the counters) and any other wrong input
                inputString = scanner.next().toLowerCase(); // option to safely ignore blank lines input
                scanner.nextLine();
                if (inputString.equals("back")) {
                    System.out.println("\nSee you next time!");
                    loseCounter = 0;
                    winCounter = 0;
                    return;
                } else {
                    System.out.println("Wrong input. Please try again.");
                }
            }
            // checking if the user lost the deal
            if (tries == 0) {
                System.out.println("\nSorry, you have lost this time.\n");
                loseCounter++;
            }
        } while (tries != 0);
        // calling the option to continue of exit
        System.out.println("Do you want to continue [y/n]?");
        do {
            inputString = scanner.nextLine().toLowerCase();
            if (inputString.equals("y")) {
                // recursive function call and resetting the counters in case of exiting the function from another recursive call
                guessNumber();
                loseCounter = 0;
                winCounter = 0;
                return;
            } else if (inputString.equals("n")) {
                System.out.println("\nSee you next time!\n");
                loseCounter = 0;
                winCounter = 0;
            } else {
                System.out.println("Wrong input. Please try again.");
            }
        } while (!inputString.equals("n"));
    }

    /**
     * The game "Guess the word" allows user to enter any text, shows hints with hidden characters, restarts with submenu and recursive function, allows to exit at any time.
     */
    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[random(0, words.length - 1)];
        String inputString;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""

                >>> Guess the word <<<
                
                Try to guess the word with as fewer attempts as possible.
                You will be provided with hints.
                For exit type 'back'.
                """);
        do {
            // checking the entered text, offering exit with 'back' keyword
            inputString = scanner.next().toLowerCase(); // option to safely ignore blank lines input
            scanner.nextLine();
            if (inputString.equals("back")) {
                System.out.println("\nSee you next time!");
                return;
            } else if (inputString.equals(word)) {
                System.out.println("\nCongratulations!!! You've got that word '" + word + "' right.\n");
                break;
            } else {
                String hintWord = "";
                String shortestWord;
                // defining the shortest word to avoid exceptions when iterating through words characters
                if (word.length() > inputString.length()) {
                    shortestWord = inputString;
                } else {
                    shortestWord = word;
                }
                // comparing characters and hiding unequal ones
                for (int charInd = 0; charInd < shortestWord.length(); charInd++) {
                    if (word.charAt(charInd) == inputString.charAt(charInd)) {
                        hintWord += inputString.charAt(charInd);
                    } else {
                        hintWord += '#';
                    }
                }
                do {
                    hintWord += '#';
                } while (hintWord.length() != 15);
                System.out.println("Nice try but not good enough.\n" + hintWord);
            }
        } while(true);
        // calling the option to continue of exit
        System.out.println("Do you want to continue [y/n]?");
        do {
            inputString = scanner.nextLine().toLowerCase();
            if (inputString.equals("y")) {
                // recursive function call
                guessWord();
                return;
            } else if (inputString.equals("n")) {
                System.out.println("\nSee you next time!\n");
            } else {
                System.out.println("Wrong input. Please try again.");
            }
        } while (!inputString.equals("n"));
    }

    public static void main(String[] args) {
        String selection;
        boolean close = false;
        do {
            selection = mainMenu();
            switch(selection) {
                case "1" -> guessNumber();
                case "2" -> guessWord();
                case "exit" -> close = true;
                default -> System.out.println("Wrong input. Please try again.");
            }
        } while (!close);
        System.out.println("Closing the app...");
    }
}