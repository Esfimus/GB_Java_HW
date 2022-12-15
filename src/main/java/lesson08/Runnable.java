package lesson08;

public interface Runnable {
    default void run() {
        System.out.println("Runnable is running");
    }
}