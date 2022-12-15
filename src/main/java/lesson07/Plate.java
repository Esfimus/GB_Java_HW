package lesson07;

public class Plate {

    private int food;
    private final int capacity;

    public Plate(int food, int capacity) {
        this.food = food;
        this.capacity = capacity;
    }

    public int getFood() {
        return food;
    }

    public void refillFood(int addFood) {
        if (addFood < 0) {
            System.out.println("Food units cannot be less than 0");
        } else if (food + addFood > capacity){
            System.out.println("Wrong value, the plate's capacity is " + capacity + " units of food");
        } else {
            this.food = food + addFood;
            System.out.println("The plate has been refilled, now it has " + food + " units of food");
        }
    }

    public void decreaseFood(int removeFood) {
        if (removeFood < 0) {
            System.out.println("Food units cannot be less than 0");
        } else if (food - removeFood < 0){
            System.out.println("There is only " + food + " units of food on the plate");
        } else {
            this.food = food - removeFood;
            System.out.println(removeFood + " units of food were eaten, now the plate has " + food + " units of food");
        }
    }

    public void display() {
        if (food > 0) {
            System.out.println("There is " + food + " units of food on the plate");
        } else if (food == 0) {
            System.out.println("The plate is empty");
        }
    }
}