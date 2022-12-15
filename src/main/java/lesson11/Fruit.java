package lesson11;

public abstract class Fruit {

    final String name = "Fruit";
    private int weight;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

class Apple extends Fruit {

    final String name = "Apple";
    private final int weight;

    public Apple(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Apple %d g", weight);
    }
}

class Orange extends Fruit {

    final String name = "Orange";
    private final int weight;

    public Orange(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Orange %d g", weight);
    }
}