package lesson08;

import java.util.Arrays;

public class HW08 {

    public static int random (int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) {

        String[] humanNames = {"Charlie", "Jack", "Scott", "Adam", "Bob", "Frank", "Will", "Noah", "Oliver", "Henry"};
        String[] robotNames = {"Cyborg", "Machina", "Micro", "Automata", "Olympus", "Screwie", "RAM", "Technician", "Antenna", "Chip"};
        String[] catNames = {"Leo", "Tiger", "Buddy", "Smokey", "Felix", "Rocky", "Bandit", "Zeus", "Tucker", "Boo"};

        // new list of random challenges
        Challenge[] challenges = new Challenge[10];
        for (int i = 0; i < challenges.length; i++) {
            int challengeChoice = random(0, 1);
            if (challengeChoice == 0) {
                challenges[i] = new Wall(random(1, 3));
            } else if (challengeChoice == 1){
                challenges[i] = new Racetrack(random(1, 50));
            }
        }
        System.out.println(Arrays.toString(challenges));

        // new list of random creatures
        Competitional[] competitionals = new Competitional[10];
        for (int i = 0; i < competitionals.length; i++) {
            int competingChoice = random(0, 2);
            if (competingChoice == 0) {
                competitionals[i] = new Human(humanNames[random(0, 9)], random(2, 30), random(1, 2));
            } else if (competingChoice == 1) {
                competitionals[i] = new Robot(robotNames[random(0, 9)], random(10, 50), random(1, 4));
            } else {
                competitionals[i] = new Cat(catNames[random(0, 9)], random(1, 5), random(1, 3));
            }
        }
        System.out.println(Arrays.toString(competitionals));
        System.out.println();

        // recognizing creatures and challenges, making creatures pass challenges
        for (Competitional comp : competitionals) {
            for (Challenge chal : challenges) {
                if (comp instanceof Robot robot) {
                    if (chal instanceof Wall wall) {
                        robot.jump();
                        wall.challengePass(robot.getJumpability());
                    } else if (chal instanceof Racetrack track) {
                        robot.run();
                        track.challengePass(robot.getRunability());
                    }
                } else if (comp instanceof Human human) {
                    if (chal instanceof Wall wall) {
                        human.jump();
                        wall.challengePass(human.getJumpability());
                    } else if (chal instanceof Racetrack track) {
                        human.run();
                        track.challengePass(human.getRunability());
                    }
                } else if (comp instanceof Cat cat) {
                    if (chal instanceof Wall wall) {
                        cat.jump();
                        wall.challengePass(cat.getJumpability());
                    } else if (chal instanceof Racetrack track) {
                        cat.run();
                        track.challengePass(cat.getRunability());
                    }
                }
            }
        }
    }
}