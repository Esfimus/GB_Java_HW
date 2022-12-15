package lesson06;

public class Dog extends Animal {

    private static int dogCount = 0;

    public static int getDogCount() {
        return dogCount;
    }

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.printf("Dog %s has covered %s m running.\n", name, distance);
        } else {
            System.out.printf("%s m is too much for our dog %s to run.\n", distance, name);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.printf("Dog %s has covered %s m swimming.\n", name, distance);
        } else {
            System.out.printf("%s m is too much for our dog %s to swim.\n", distance, name);
        }
    }
}
