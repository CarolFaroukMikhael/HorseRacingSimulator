/**
 * @author Mikhael
 * @version 16 april 24
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RaceSimulation extends JFrame {
    private List<Horse> horses;
    private JPanel racePanel;

    public RaceSimulation(List<Horse> horses) {
        this.horses = horses;

        // Set title, size, and default close operation for the JFrame
        setTitle("Horse Race Simulation");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize race panel
        racePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw horses at their current positions
                for (Horse horse : horses) {
                    int x = (int) horse.getPosition();
                    int y = 50; // Fixed y position for simplicity
                    g.drawImage(horse.getImage().getImage(), x, y, null);
                }
            }
        };

        // Add race panel to the JFrame
        add(racePanel, BorderLayout.CENTER);

        // Start the race animation
        startRaceAnimation();
    }

    private void startRaceAnimation() {
        // Create a timer to update horse positions and repaint the race panel
        Timer timer = new Timer(100, e -> {
            // Simulate the movement of each horse
            for (Horse horse : horses) {
                horse.move();
            }
            // Repaint the race panel to update horse positions
            racePanel.repaint();
        });
        timer.start();
    }
}
