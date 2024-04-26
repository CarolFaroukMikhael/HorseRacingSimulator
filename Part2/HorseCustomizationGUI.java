/**
 * @author Mikhael
 * @version 11 april 24
 */
import javax.swing.*;

public class HorseCustomizationGUI extends JFrame {
    private int numTracks;
    private int numHorsesPerTrack;
    private JLabel[] lblBreed;
    private JComboBox<String>[] cmbBreed;
    private JLabel[] lblCoatColor;
    private JTextField[] txtCoatColor;
    private JButton btnCustomize;

    public HorseCustomizationGUI(int numTracks, int numHorsesPerTrack) {
        this.numTracks = numTracks;
        this.numHorsesPerTrack = numHorsesPerTrack;

        // Set title, size, and default close operation for the JFrame
        setTitle("Horse Customization");
        setSize(300, 200 + numTracks * 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize arrays for labels, combo boxes, and text fields
        lblBreed = new JLabel[numTracks * numHorsesPerTrack];
        cmbBreed = new JComboBox[numTracks * numHorsesPerTrack];
        lblCoatColor = new JLabel[numTracks * numHorsesPerTrack];
        txtCoatColor = new JTextField[numTracks * numHorsesPerTrack];
        btnCustomize = new JButton("Customize Horses");

        // Create a panel with a vertical box layout to hold horse customization components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Loop through each track and each horse per track to create customization components
        for (int i = 0; i < numTracks; i++) {
            for (int j = 0; j < numHorsesPerTrack; j++) {
                int index = i * numHorsesPerTrack + j;
                lblBreed[index] = new JLabel("Breed:");
                cmbBreed[index] = new JComboBox<>(new String[]{"Thoroughbred", "Quarter Horse", "Arabian"});
                lblCoatColor[index] = new JLabel("Coat Color:");
                txtCoatColor[index] = new JTextField(10);

                // Create a panel to hold breed and coat color components for each horse
                JPanel horsePanel = new JPanel();
                horsePanel.add(lblBreed[index]);
                horsePanel.add(cmbBreed[index]);
                horsePanel.add(lblCoatColor[index]);
                horsePanel.add(txtCoatColor[index]);
                panel.add(horsePanel);
            }
        }

        // ActionListener for the "Customize Horses" button
        btnCustomize.addActionListener(e -> {
            // Display a message indicating successful horse customization
            JOptionPane.showMessageDialog(this, "Horses customized successfully!");

            // Proceed to the betting system GUI
            BettingGUI bettingGUI = new BettingGUI();
            bettingGUI.setVisible(true);

            // Close the current window
            this.dispose();
        });

        // Add the "Customize Horses" button to the panel
        panel.add(btnCustomize);

        // Add the panel to the JFrame
        add(panel);
    }

    public static void main(String[] args) {
        // Create and display the HorseCustomizationGUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            HorseCustomizationGUI gui = new HorseCustomizationGUI(2, 3); // Example with 2 tracks and 3 horses per track
            gui.setVisible(true);
        });
    }
}
