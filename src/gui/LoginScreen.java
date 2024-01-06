package gui;


import javax.swing.*;
import java.awt.*;

class LoginScreen {
    private String username;
    private char[] password;

    public boolean showLoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel(""));
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            username = usernameField.getText();
            password = passwordField.getPassword();
            frame.dispose(); // Close the login window
        });

        frame.add(panel);
        frame.setVisible(true);

        // Wait for login to complete before returning
        while (username == null || password == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }

        return isValidLogin(username, new String(password));
    }

    public String getUsername() {
        return username;
    }

    private static boolean isValidLogin(String username, String password) {
        // Perform your login validation logic here
        // For demonstration purposes, accept any non-empty username and password "admin"
        return !username.isEmpty() && password.equals("admin");
    }
}