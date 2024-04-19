import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Race {
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;

    public Race(int distance) {
        raceLength = distance;
        lane1Horse = null;
        lane2Horse = null;
        lane3Horse = null;
    }

    public void addHorse(Horse theHorse, int laneNumber) {
        if (laneNumber == 1) {
            lane1Horse = theHorse;
        } else if (laneNumber == 2) {
            lane2Horse = theHorse;
        } else if (laneNumber == 3) {
            lane3Horse = theHorse;
        } else {
            System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
        }
    }

    public void startRace() {
        Horse winnerHorse = null;
        boolean raceOver = false;

        lane1Horse.goBackToStart();
        lane2Horse.goBackToStart();
        lane3Horse.goBackToStart();

        System.out.println("3... 2... 1... And they're off!");

        while (!raceOver) {
            moveHorse(lane1Horse);
            moveHorse(lane2Horse);
            moveHorse(lane3Horse);

            printRace();

            simulateTrackConditions(lane1Horse);
            simulateTrackConditions(lane2Horse);
            simulateTrackConditions(lane3Horse);

            if (raceWonBy(lane1Horse)) {
                winnerHorse = lane1Horse;
                raceOver = true;
            } else if (raceWonBy(lane2Horse)) {
                winnerHorse = lane2Horse;
                raceOver = true;
            } else if (raceWonBy(lane3Horse)) {
                winnerHorse = lane3Horse;
                raceOver = true;
            }

            try {
                Random rand = new Random();
                int delay = rand.nextInt(200) + 100;
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("And the winner is... " + winnerHorse.getName() + "!");
    }

    private void moveHorse(Horse theHorse) {
        if (!theHorse.hasFallen()) {
            if (Math.random() < theHorse.getConfidence()) {
                theHorse.moveForward();
            }

            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence())) {
                theHorse.fall();
            }
        }
    }

    private boolean raceWonBy(Horse theHorse) {
        return theHorse.getDistanceTravelled() == raceLength;
    }

    private void printRace() {
        System.out.print('\u000C');

        multiplePrint('=', raceLength + 3);
        System.out.println();

        printLane(lane1Horse);
        System.out.println();

        printLane(lane2Horse);
        System.out.println();

        printLane(lane3Horse);
        System.out.println();

        multiplePrint('=', raceLength + 3);
        System.out.println();    
    }

    private void printLane(Horse theHorse) {
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();

        System.out.print('|');

        multiplePrint(' ', spacesBefore);

        if (theHorse.hasFallen()) {
            System.out.print('\u2322');
        } else {
            System.out.print(theHorse.getSymbol());
        }

        multiplePrint(' ', spacesAfter);

        System.out.print('|');
    }

    private void multiplePrint(char aChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(aChar);
        }
    }

    private void simulateTrackConditions(Horse theHorse) {
        double chance = Math.random();

        if (chance < 0.2) {
            theHorse.decreaseConfidence();
            System.out.println(theHorse.getName() + " encounters a muddy patch and slows down!");
        } else if (chance < 0.4) {
            theHorse.increaseConfidence();
            System.out.println(theHorse.getName() + " finds a smoother track and accelerates!");
        } else {
            System.out.println(theHorse.getName() + " continues on the regular track.");
        }
    }
}