package lesson08;

public class Wall extends Challenge {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void challengePass(int jumpability) {
        if (jumpability >= height) {
            System.out.printf("Wall height is %d m. Hooray, the wall has been successfully jumped over!\n\n", height);
        } else {
            System.out.printf("Wall height is %d m. Unfortunately, the wall is too high to jump over.\n\n", height);
        }
    }

    @Override
    public String toString() {
        return String.format("Wall %d m", height);
    }
}