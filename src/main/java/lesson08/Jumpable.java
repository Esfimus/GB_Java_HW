package lesson08;

public interface Jumpable {

    default void jump() {
        System.out.println("Jumpable is jumping");
    }
}