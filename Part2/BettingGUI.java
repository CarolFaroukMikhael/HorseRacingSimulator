/**
 * @author Mikhael
 * @version 15 april 24
 */
import javax.swing.*;

public class BettingGUI extends JFrame {
    private JLabel lblBetAmount;
    private JLabel lblSelectHorse;
    private JTextField txtBetAmount;
    private JComboBox<String> horseComboBox;
    private JButton btnPlaceBet;

    public BettingGUI() {
        // Set title, size, and default close operation for the JFrame
        setTitle("Virtual Betting System");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components: JLabels, JTextField, JComboBox, and JButton
        lblBetAmount = new JLabel("Bet Amount:");
        lblSelectHorse = new JLabel("Select Horse Breed:");
        txtBetAmount = new JTextField(10);
        horseComboBox = new JComboBox<>(new String[]{"Thoroughbred", "Quarter Horse", "Arabian"});
        btnPlaceBet = new JButton("Place Bet");

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.add(lblBetAmount);
        panel.add(txtBetAmount);
        panel.add(lblSelectHorse);
        panel.add(horseComboBox);
        panel.add(btnPlaceBet);

        // Add the panel to the JFrame
        add(panel);

        // ActionListener for the "Place Bet" button
        btnPlaceBet.addActionListener(e -> {
            // Get the bet amount entered by the user
            String betAmount = txtBetAmount.getText();

            // Get the selected horse breed from the JComboBox
            String selectedHorseBreed = (String) horseComboBox.getSelectedItem();

            // Display a confirmation message with the selected horse breed and bet amount
            JOptionPane.showMessageDialog(this, "Bet placed successfully on " + selectedHorseBreed + " for $" + betAmount);
        });
    }

    public static void main(String[] args) {
        // Create and display the BettingGUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            BettingGUI gui = new BettingGUI();
            gui.setVisible(true);
        });
    }
}
