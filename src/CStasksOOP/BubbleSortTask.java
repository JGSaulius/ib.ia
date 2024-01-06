package CStasksOOP;

import java.util.Random;
import java.util.Scanner;

class BubbleSortTask extends Task {
    public BubbleSortTask(String studentName) {
        super(studentName);
    }

    @Override
    public void execute() {
        System.out.println("Task 4: Bubble Sort Iterations.");

        final int arraySize = 5;
        int[] numbers = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; ++i) {
            numbers[i] = random.nextInt(100);
        }

        System.out.print("Initial array: ");
        for (int i = 0; i < arraySize; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int[] correctSortedArray = numbers.clone();

        for (int i = 0; i < arraySize - 1; ++i) {
            for (int j = 0; j < arraySize - i - 1; ++j) {
                if (correctSortedArray[j] > correctSortedArray[j + 1]) {
                    int temp = correctSortedArray[j];
                    correctSortedArray[j] = correctSortedArray[j + 1];
                    correctSortedArray[j + 1] = temp;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the state of the array after how many Bubble Sort iterations (1, 2, 3, or 4): ");
        int iterations = scanner.nextInt();

        int[] userArray = numbers.clone();

        for (int i = 0; i < iterations; ++i) {
            System.out.print("Array after iteration " + (i + 1) + ": ");
            for (int j = 0; j < arraySize; ++j) {
                System.out.print(userArray[j] + " ");
            }
            System.out.println();

            System.out.print("Enter the array state after iteration " + (i + 1) + " (space-separated integers): ");
            for (int j = 0; j < arraySize; ++j) {
                userArray[j] = scanner.nextInt();
            }
        }

        boolean isCorrect = true;
        for (int i = 0; i < arraySize; ++i) {
            if (userArray[i] != correctSortedArray[i]) {
                isCorrect = false;
                break;
            }
        }

        if (isCorrect) {
            System.out.println("Congratulations, " + studentName + "! Your solution is correct.");
        } else {
            System.out.println("Sorry, " + studentName + ". Your solution is incorrect.");
        }
    }

}