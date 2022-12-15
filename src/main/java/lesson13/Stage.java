package lesson13;

import java.util.concurrent.Semaphore;

public abstract class Stage {
    protected int length;
    protected String description;

    public void go(Race.Car car) {}

    @Override
    public String toString() {
        return description;
    }
}

class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = String.format("Road %d m", length);
    }

    @Override
    public void go(Race.Car car) {
        try {
            System.out.println(car + " starts " + description);
            Thread.sleep(length / car.getSpeed() * 1000L);
            System.out.println(car + " finished " + description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Tunnel extends Stage {
    Semaphore semaphore;

    public Tunnel(int length, int maxCars) {
        this.length = length;
        this.semaphore = new Semaphore(maxCars);
        this.description = String.format("Tunnel %d m", length);
    }

    @Override
    public void go(Race.Car car) {
        try {
            try {
                System.out.println(car + " waits " + description);
                semaphore.acquire();
                System.out.println(car + " starts " + description);
                Thread.sleep(length / car.getSpeed() * 1000L);
                System.out.println(car + " in " + description);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(car + " finished " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}