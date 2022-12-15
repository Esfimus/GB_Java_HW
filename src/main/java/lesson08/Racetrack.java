package lesson08;

public class Racetrack extends Challenge{

    private final int distance;

    public Racetrack(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void challengePass(int runability) {
        if (runability >= distance) {
            System.out.printf("Track distance is %d km. Hooray, the distance has been successfully passed running!\n\n", distance);
        } else {
            System.out.printf("Track distance is %d km. Unfortunately, the distance is too long to pass running.\n\n", distance);
        }
    }

    @Override
    public String toString() {
        return String.format("Track %d km", distance);
    }
}