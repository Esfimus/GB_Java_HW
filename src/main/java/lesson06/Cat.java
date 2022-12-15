package lesson06;

public class Cat extends Animal {

    private static int catCount = 0;

    public static int getCatCount() {
        return catCount;
    }

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.printf("Cat %s has covered %s m running.\n", name, distance);
        } else {
            System.out.printf("%s m is too much for our cat %s to run.\n", distance, name);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.printf("Cat %s cannot swim.\n", name);
    }
}
