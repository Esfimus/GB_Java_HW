package lesson07;

public class HW07 {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Punk", 10);
        Plate plate1 = new Plate(0, 100);
        cat1.display();
        plate1.display();
        plate1.refillFood(35);
        plate1.display();
        cat1.eat(plate1);
        cat1.display();
        plate1.display();
        System.out.println();

        Cat[] cats = new Cat[] {
                new Cat("Drill", 5),
                new Cat("Reamer", 15),
                new Cat("Mill", 7),
                new Cat("Hatch", 3),
                new Cat("Clutch", 12),
        };
        for (Cat cat : cats) {
            cat.display();
            cat.eat(plate1);
            System.out.println();
        }
    }
}