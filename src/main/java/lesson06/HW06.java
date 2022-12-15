package lesson06;

public class HW06 {

    public static void animalsCreated() {
        System.out.println("Total animals created: " + Animal.getAnimalCount());
        System.out.println("Total cats created: " + Cat.getCatCount());
        System.out.println("Total dogs created: " + Dog.getDogCount());
    }

    public static void main(String[] args) {
        animalsCreated();
        Cat cat01 = new Cat("Skunk");
        Cat cat02 = new Cat("Punk");
        Cat cat03 = new Cat("Creep");
        Dog dog01 = new Dog("Smack");
        Dog dog02 = new Dog("Dupe");
        animalsCreated();
        cat01.run(150);
        cat02.run(250);
        cat01.swim(5);
        dog01.run(400);
        dog02.run(700);
        dog01.swim(5);
        dog02.swim(15);
    }
}