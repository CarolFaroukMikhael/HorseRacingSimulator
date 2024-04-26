/**
 * @author Mikhael
 * @version 13 april 24
 */
import java.util.ArrayList;
import java.util.List;

public void run() {
    // Simulate the horse running by adding its speed to the distance traveled
    Random random = new Random();
    // Add a random factor to simulate variation in speed
    distanceTraveled += speed * (1 + random.nextDouble());
}

public class RaceTrack {
    private List<Horse> horses;

    public RaceTrack() {
        // Initialize the list of horses
        this.horses = new ArrayList<>();
    }

    public void addHorse(Horse horse) {
        // Add a horse to the race track
        horses.add(horse);
    }

    public void simulateRace() {
        // Simulate the race by advancing each horse by a random distance based on its speed
        for (Horse horse : horses) {
            horse.run();
        }
    }

    public List<Horse> getHorses() {
        // Return the list of horses on the race track
        return horses;
    }
}
