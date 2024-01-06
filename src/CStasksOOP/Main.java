package CStasksOOP;

import java.util.Scanner;
import java.util.Random;
import gui.*;
import databaseconnect.*;


public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnectGetSet databaseConnect = new DatabaseConnectGetSet();
            LoginScreen loginScreen = new LoginScreen(databaseConnect);

            String username = loginScreen.showLoginScreen();

            if (username != null) {
                System.out.println("Login successful! Welcome, " + username + "!");
                initializeTasks(username);
            } else {
                System.out.println("Login failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void initializeTasks(String username) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, " + username);


        System.out.println("Welcome to Computer Science practice!");

        Task[] tasks = {
                new ImageSizeTask(username),
                new DecimalToBinaryTask(username),
                new LetterToCodeTask(username),
                new BubbleSortTask(username)
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
