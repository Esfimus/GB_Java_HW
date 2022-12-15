package lesson13;

public class Race {

    class Car {
        private final int id;
        private final int speed;

        public Car(int id) {
            this.id = id;
            this.speed = random(40, 60);
        }

        public int getSpeed() { return speed; }

        @Override
        public String toString() {
            return String.format("Car #%d speed %d m/s", id, speed);
        }
    }

    private final Car[] carsInRace;
    private final Stage[] stages;

    public Car[] getCarsInRace() { return carsInRace; }

    public Race(int cars, Stage... stages) {
        this.carsInRace = new Car[cars];
        for (int i = 0; i < carsInRace.length; i++) {
            carsInRace[i] =  new Car(i + 1);
        }
        this.stages = stages;
    }

    public void go(Car car) {
        for (Stage stage: stages) {
            stage.go(car);
        }
    }

    public int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

class Winner {
    boolean winState = false;
    synchronized void finish(Race.Car car) {
        if (!winState) {
            winState = true;
            System.out.println("WINNER " + car);
        } else {
            System.out.println("Finisher " + car);
        }
    }
}