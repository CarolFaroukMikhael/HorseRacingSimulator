/**
 * @author Mikhael
 * @version 14 april 24
 */
import javax.swing.*;

public class StatisticsGUI extends JFrame {
    private JTextArea txtStatistics;

    public StatisticsGUI() {
        // Set title, size, and default close operation for the JFrame
        setTitle("Statistics and Analytics");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JTextArea for displaying statistics
        txtStatistics = new JTextArea(15, 30);
        JScrollPane scrollPane = new JScrollPane(txtStatistics);

        // Create a JPanel to hold the JTextArea with scrolling capability
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        // Add the panel to the JFrame
        add(panel);

        // Implement functionality to display initial statistics
        txtStatistics.setText("Statistics will be displayed here...");
        
        // Prompt the user to proceed to the betting system or not
        int option = JOptionPane.showConfirmDialog(this, "Do you want to proceed to the betting system?", "Betting System", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Proceed to the betting system
            BettingGUI bettingGUI = new BettingGUI();
            bettingGUI.setVisible(true);
        } else {
            // Close the window
            this.dispose();
        }
    }

    public static void main(String[] args) {
        // Create and display the StatisticsGUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            StatisticsGUI gui = new StatisticsGUI();
            gui.setVisible(true);
        });
    }
}
