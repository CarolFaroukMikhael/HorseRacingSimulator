/**
 * @author Mikhael
 * @version 17 april 24
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainGUI extends JFrame {
    private JButton btnRunRace;
    private JPanel horsePanel; // Panel to display horses

    public MainGUI() {
        // Set title, size, and default close operation for the JFrame
        setTitle("Horse Race Simulator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize "Run Race" button
        btnRunRace = new JButton("Run Race");

        // Create panel to hold the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnRunRace);

        // Add button panel to the JFrame
        add(buttonPanel, BorderLayout.NORTH);

        // Initialize horse panel with FlowLayout
        horsePanel = new JPanel(new FlowLayout());
        add(horsePanel, BorderLayout.CENTER);
        horsePanel.setVisible(false); // Hide horse panel initially

        // Action listener for the "Run Race" button
        btnRunRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load and display horse images
                displayHorses();
            }
        });
    }

    // Method to load horse images from files
    private List<ImageIcon> loadHorseImages() {
        List<ImageIcon> horseImages = new ArrayList<>();
        // Load horse images from files
        horseImages.add(new ImageIcon("images/WhiteHorse.jpg"));
        horseImages.add(new ImageIcon("images/BlackHorse.jpg"));
        horseImages.add(new ImageIcon("images/BrownHorse.jpg"));
        return horseImages;
    }

    // Method to display horse images on the horse panel
    private void displayHorses() {
        // Clear existing components from the horse panel
        horsePanel.removeAll();

        // Load horse images
        List<ImageIcon> horseImages = loadHorseImages();

        // Add horse images to the horse panel
        for (ImageIcon horseImage : horseImages) {
            JLabel horseLabel = new JLabel(horseImage);
            horsePanel.add(horseLabel);
        }

        // Make the horse panel visible
        horsePanel.setVisible(true);

        // Repaint the JFrame to reflect changes
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        // Create and display the MainGUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });
    }
}
