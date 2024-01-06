package gui;

import databaseconnect.DatabaseConnectGetSet;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginScreen {
    private String username;
    private char[] password;
    private boolean loginCompleted;
    private DatabaseConnectGetSet databaseConnect;

    public LoginScreen(DatabaseConnectGetSet databaseConnect) {
        this.databaseConnect = databaseConnect;
    }

    public String showLoginScreen() {
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
            loginCompleted = true;
            frame.dispose(); // Close the login window
        });

        frame.add(panel);
        frame.setVisible(true);

        // Wait for login to complete before returning
        while (!loginCompleted) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }

        return isValidLogin(username, new String(password)) ? username : null;
    }

    private boolean isValidLogin(String username, String password) {
        try {
            Connection connection = databaseConnect.getConnection();
            String query = "SELECT * FROM Users WHERE Uname = ? AND Password = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // If a row is returned, the credentials are valid
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
