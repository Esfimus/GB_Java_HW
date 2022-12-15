package lesson01;

public class HW01 {
    // #1
    public static void main(String[] args) {

        // #2
        byte byteType = 5;
        short shortType = 14500;
        int intType = 57425;
        long longType = 987654321L;
        float floatType = 75.3f;
        double doubleType = 35.75;
        boolean booleanType = true;
        char charType = 'N';
        String stringType = "Homework to do";
        System.out.printf(
                "%s, %s, %s, %s, %s, %s, %s, %s, %s\n",
                byteType, shortType, intType, longType, floatType, doubleType, booleanType, charType, stringType
        );

        System.out.println("The expression's result is " + expression(2.5f, 3.4f, 17.5f, 4.4f));

        short num1 = 9;
        short num2 = 14;
        System.out.println("The sum of " + num1 + " and " + num2 + " is within 10...20: " + sumCheck(num1, num2));

        positiveOrNegative(125);

        int posOrNeg = -50;
        System.out.println("The number " + posOrNeg + " is positive: " + positiveOrNegativeCheck(posOrNeg));

        greeting("my friend");

        leapYear(2022);
    }

    // #3
    /**
     * Custom expression calculation method
     * @param a the first argument
     * @param b the second argument
     * @param c the third argument
     * @param d the fourth argument
     * @return the result of custom calculation
     */
    public static float expression(float a, float b, float c, float d) {
        return a * (b + c / d);
    }

    // #4
    /**
     * The method checks if the sum of two components is within the range of 10 to 20
     * @param numToCheck1 the first component
     * @param numToCheck2 the second component
     * @return true or false
     */
    public static boolean sumCheck(short numToCheck1, short numToCheck2) {
        short sumNumbers = (short) (numToCheck1 + numToCheck2);
        boolean checkCorrect;
        checkCorrect = sumNumbers >= 10 && sumNumbers <= 20;
        return checkCorrect;
    }

    // #5
    /**
     * The method identifies positive and negative numbers
     * @param number to identify
     */
    public static void positiveOrNegative(int number) {
        if (number < 0) {
            System.out.println("The number " + number + " is negative");
        } else {
            System.out.println("The number " + number + " is positive");
        }
    }

    // #6
    /**
     * The method identifies positive and negative numbers
     * @param number to identify
     * @return true or false
     */
    public static boolean positiveOrNegativeCheck(int number) {
        boolean positiveIsTrue;
        positiveIsTrue = number >= 0;
        return positiveIsTrue;
    }

    // #7
    /**
     * Friendly greeting method
     * @param name to greet
     */
    public static void greeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    //#8
    public static void leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}
