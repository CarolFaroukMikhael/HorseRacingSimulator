/**
 * @author Mikhael
 * @version 10 april 24
 */
import javax.swing.*;

public class TrackDesignGUI extends JFrame {
    private JLabel lblNumberOfTracks;
    private JTextField txtNumberOfTracks;
    private JButton btnDesignTracks;

    public TrackDesignGUI() {
        // Set the title, size, and default close operation for the JFrame
        setTitle("Track Design");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components: JLabel, JTextField, and JButton
        lblNumberOfTracks = new JLabel("Number of Tracks:");
        txtNumberOfTracks = new JTextField(10);
        btnDesignTracks = new JButton("Design Tracks");

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.add(lblNumberOfTracks);
        panel.add(txtNumberOfTracks);
        panel.add(btnDesignTracks);

        // Add the JPanel to the JFrame
        add(panel);

        // ActionListener for the "Design Tracks" button
        btnDesignTracks.addActionListener(e -> {
            // Retrieve the number of tracks entered by the user
            int numTracks = Integer.parseInt(txtNumberOfTracks.getText());

            // Prompt the user to enter the number of horses for each track
            String input = JOptionPane.showInputDialog(this, "Enter the number of horses for each track:");
            int numHorses = Integer.parseInt(input);

            // Display a success message
            JOptionPane.showMessageDialog(this, "Tracks designed successfully!");

            // Proceed to horse customization GUI
            HorseCustomizationGUI horseCustomizationGUI = new HorseCustomizationGUI(numTracks, numHorses);
            horseCustomizationGUI.setVisible(true);

            // Close the current window
            this.dispose();
        });
    }

    public static void main(String[] args) {
        // Create and display the TrackDesignGUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            TrackDesignGUI gui = new TrackDesignGUI();
            gui.setVisible(true);
        });
    }
}
