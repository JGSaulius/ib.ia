package gui;

import javax.swing.*;

public class PasswordCheckGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create and show the GUI on the Event Dispatch Thread
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        String name = JOptionPane.showInputDialog("Type your user name");
        String start = name.substring(0, 3);

        if (start.equals("Adm")) {
            JOptionPane.showMessageDialog(null, "You are Administrator");
            String password = JOptionPane.showInputDialog("Type your password");
            if (password.equals("Kryptonite")) {
                JOptionPane.showMessageDialog(null, "Correct");
            } else {
                JOptionPane.showMessageDialog(null, "Bad password");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bad user name");
        }
    }
}
