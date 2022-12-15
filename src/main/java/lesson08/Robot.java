package lesson08;

public class Robot implements Jumpable, Runnable, Competitional {

    public final String type = "Robot";
    private final String name;
    private int runability;
    private int jumpability;

    public Robot(String name, int runability, int jumpability) {
        this.name = name;
        this.runability = runability;
        this.jumpability = jumpability;
    }

    public String getName() {
        return name;
    }

    public int getRunability() {
        return runability;
    }

    public void setRunability(int runability) {
        this.runability = runability;
    }

    public int getJumpability() {
        return jumpability;
    }

    public void setJumpability(int jumpability) {
        this.jumpability = jumpability;
    }

    @Override
    public void jump() {
        System.out.printf("Robot %s is jumping; jumpability is %s.\n", name, jumpability);
    }

    @Override
    public void run() {
        System.out.printf("Robot %s is running; runability is %s.\n", name, runability);
    }

    @Override
    public String toString() {
        return String.format("%s %s (max run %d, max jump %d)", type, name, runability, jumpability);
    }
}
