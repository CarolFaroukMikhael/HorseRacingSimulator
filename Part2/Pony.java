/**
 * @author Mikhael
 * @version 12 april 24
 */
import java.util.Random;

public class Pony {
    private String breed;
    private String coatColor;
    private double speed; // Speed of the pony
    private double distanceTraveled; // Distance traveled by the pony in the race

    public Pony(String breed, String coatColor, double speed) {
        // Initialize the pony with its breed, coat color, speed, and initial distance traveled
        this.breed = breed;
        this.coatColor = coatColor;
        this.speed = speed;
        this.distanceTraveled = 0.0;
    }

    public void run() {
        // Simulate the pony running by adding its speed to the distance traveled
        Random random = new Random();
        // Add a random factor to simulate variation in speed
        distanceTraveled += speed * (1 + random.nextDouble());
    }

    public double getDistanceTraveled() {
        // Return the distance traveled by the pony in the race
        return distanceTraveled;
    }

    // Other getters and setters as needed
}
