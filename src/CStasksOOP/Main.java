package CStasksOOP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Random;
import gui.*;
import databaseconnect.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            DatabaseConnectGetSet databaseConnect = new DatabaseConnectGetSet();
            Connection connection = databaseConnect.getConnection();

            if (connection != null) {
                System.out.println("Connected to the database!");

                // Example: Create a statement and execute a simple query
                try (Statement statement = connection.createStatement()) {
                    String query = "SELECT * FROM Users";
                    ResultSet resultSet = statement.executeQuery(query);
                    boolean usersFound = false;

                    while (resultSet.next()) {
                        usersFound = true;
                        String uname = resultSet.getString("Uname");
                        System.out.println("Username: " + uname);
                    }

                    if (!usersFound) {
                        System.out.println("No users found in the Users table.");
                    }
                    // Process the result set or perform other operations
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // Close the connection when done
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//        SwingUtilities.invokeLater(() -> {
//            LoginScreen loginScreen = new LoginScreen();
//            if (loginScreen.showLoginScreen()) {
//                initializeTasks(loginScreen.getUsername());
//            }
//        });
//    }

    private static void initializeTasks(String username) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, what is your name?");
        String studentName = scanner.next();
        System.out.println("Hi, " + studentName);

        System.out.println("Welcome to Computer Science practice!");

        Task[] tasks = {
                new ImageSizeTask(studentName),
                new DecimalToBinaryTask(studentName),
                new LetterToCodeTask(studentName),
                new BubbleSortTask(studentName)
        };

        while (true) {
            System.out.print("Please choose a task (1, 2, 3 or 4) or 0 for random:");
            int taskNumber = scanner.nextInt();
            if (taskNumber == 0) {
                taskNumber = 1 + random.nextInt(3);
                System.out.println(taskNumber);
            }
            if ((taskNumber > 0) && (taskNumber < 5)) {
                tasks[taskNumber - 1].execute();
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
