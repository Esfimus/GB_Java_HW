package lesson13;

import java.util.logging.*;

public class HW13 {

    public static void main(String[] args) {

        // logging initialisation
        Logger logger = Logger.getLogger(HW13.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("myLog.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new XMLFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Race starts!!!");
        int cars = 5;
        Race race = new Race(cars, new Road(200), new Tunnel(200, cars));
        Winner winner = new Winner();
        Thread[] threads = new Thread[cars];
        logger.info("Objects created");
        for (int i = 0; i < cars; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                race.go(race.getCarsInRace()[finalI]);
                winner.finish(race.getCarsInRace()[finalI]);
            });
            threads[i].start();
        }
        logger.warning("All threads started");
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Race finished!!!");
    }
}