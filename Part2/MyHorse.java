/**
 * @author Mikhael
 * @version 17 april 24
 */
import javax.swing.*;
import java.awt.*;

public class MyHorse {
    private ImageIcon image;
    private double speed;
    private double position;

    public MyHorse(ImageIcon image, double speed) {
        // Initialize the horse with its image and speed
        this.image = image;
        this.speed = speed;
        this.position = 0; // Initialize position to start of the race track
    }

    public ImageIcon getImage() {
        // Return the horse's image icon
        return image;
    }

    public double getPosition() {
        // Return the horse's current position
        return position;
    }

    public void move() {
        // Simulate the horse's movement
        position += speed * Math.random();
        // Ensure that the position doesn't exceed certain bounds
        // For example, if the race track's length is known, you can check if the position exceeds it
        // Example: if (position > raceTrackLength) { position = raceTrackLength; }
    }
}
