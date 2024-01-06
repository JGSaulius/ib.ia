package CStasksOOP;

import CStasksOOP.BubbleSortTask;
import CStasksOOP.DecimalToBinaryTask;
import CStasksOOP.ImageSizeTask;
import CStasksOOP.LetterToCodeTask;

import java.util.Scanner;
import java.util.Random;
import gui.PasswordCheckGUI;
public class Main {
    public static void main(String[] args) {
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
