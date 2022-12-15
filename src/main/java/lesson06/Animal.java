package lesson06;

public abstract class Animal {

    protected final String name;
    private static int animalCount = 0;

    public static int getAnimalCount() {
        return animalCount;
    }

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println("An animal has covered " + distance + " m running.");
    }

    public void swim(int distance) {
        System.out.println("An animal has covered " + distance + " m swimming.");
    }
}
