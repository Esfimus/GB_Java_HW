package lesson07;

public class Cat {

    private final String name;
    private int appetite;
    private Boolean isHungry = true;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        if (appetite > 0 && appetite <= 100) {
            this.appetite = appetite;
        } else {
            System.out.println("Cat's appetite must be more than 0 and less than 100");
        }
    }

    public Boolean getHungry() {
        return isHungry;
    }

    public void setHungry(Boolean hungry) {
        isHungry = hungry;
    }

    public void display() {
        if (isHungry) {
            System.out.println(name + " is hungry and usually it consumes " + appetite + " units of food");
        } else {
            System.out.println(name + " is satisfied but usually it consumes " + appetite + " units of food");
        }
    }

    public void eat(Plate plate) {
        if (plate.getFood() < appetite) {
            System.out.println("Not enough food for this cat on the plate");
        } else if (!isHungry) {
            System.out.println("The cat " + name + " is not hungry");
        } else {
            plate.decreaseFood(appetite);
            isHungry = false;
            System.out.println("The cat " + name + " has eaten and now is satisfied");
        }
    }

    @Override
    public String toString() {
        return "Cat " + name;
    }
}