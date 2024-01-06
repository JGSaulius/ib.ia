package CStaskMethods;

import java.util.Scanner;
import java.util.Random;

    public class CStasksMethods {

        static void youAreGreat(String studentName) {
            System.out.println("You are great, " + studentName + "!");
        }

        static void imageSize(String studentName) {
            System.out.println("Task 1: Calculate the file size of an image with a given color depth.");
            System.out.println("What is the color depth of the picture (for example 8 or 24)?");
            Scanner scanner = new Scanner(System.in);
            int colorDepth = scanner.nextInt();

            int minWidth = 640;
            int maxWidth = 1920;
            int minHeight = 480;
            int maxHeight = 1080;
            int xpixels = minWidth + (new Random().nextInt(maxWidth - minWidth + 1));
            int ypixels = minHeight + (new Random().nextInt(maxHeight - minHeight + 1));
            int repeatAgain = 0;

            while (repeatAgain < 1) {
                System.out.println("Calculate the file size of a " + colorDepth + " bits image with a size of " +
                        xpixels + " x " + ypixels + " and express the sizes in bits, bytes, and megabytes.");

                int studentBits, studentBytes;
                double studentMB;
                System.out.println("Your answer in bits?");
                studentBits = scanner.nextInt();
                System.out.println("Your answer in bytes?");
                studentBytes = scanner.nextInt();
                System.out.println("Your answer in megabytes (3 significant numbers)?");
                studentMB = scanner.nextDouble();

                System.out.println("Correct answers:");
                int sizeInBits = xpixels * ypixels * colorDepth;
                System.out.println("Size in bits " + sizeInBits);
                System.out.println("Size in bytes " + sizeInBits / 8);
                double sizeInMegabytes = (double) sizeInBits / 8 / 1024 / 1024;
                System.out.println("Size in megabytes: " + sizeInMegabytes);

                if (studentBits == sizeInBits && studentBytes == sizeInBits / 8 &&
                        Math.abs(studentMB - sizeInMegabytes) < 0.001) {
                    youAreGreat(studentName);
                    break;
                } else {
                    System.out.println("Try to calculate the size again:");
                    System.out.println("Your answer in bits?");
                    studentBits = scanner.nextInt();
                    System.out.println("Your answer in bytes?");
                    studentBytes = scanner.nextInt();
                    System.out.println("Your answer in megabytes (3 significant numbers)?");
                    studentMB = scanner.nextDouble();
                    if (studentBits == sizeInBits && studentBytes == sizeInBits / 8 &&
                            Math.abs(studentMB - sizeInMegabytes) < 0.001) {
                        youAreGreat(studentName);
                    } else {
                        System.out.println("Sorry, " + studentName + ".");
                    }
                }
                repeatAgain = 1;
            }
        }

        static void decimalToBinary(String studentName) {
            System.out.println("Task 2: Convert a decimal fraction to 8 bits binary (4 bits integer + 4 bits fractional).");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a decimal fraction (e.g., 0.5, 0.25, 0.75): ");
            double realNumber = scanner.nextDouble();

            if (realNumber >= 0.0 && realNumber <= 1.0) {
                int intPart = (int) realNumber;
                double fractionalPart = realNumber - intPart;

                String intBinary = String.format("%04d", Integer.parseInt(Integer.toBinaryString(intPart)));

                StringBuilder fracBinary = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    fractionalPart *= 2;
                    int bit = (int) fractionalPart;
                    fracBinary.append(bit);
                    fractionalPart -= bit;
                }

                String studentBinary = intBinary + "." + fracBinary.toString();
                System.out.println("Enter the 8-bit binary representation (for example 0.5 correct answer is 0000.1000): ");
                studentBinary = scanner.next();

                String correctBinary = intBinary + "." + fracBinary.toString();

                if (studentBinary.equals(correctBinary)) {
                    youAreGreat(studentName);
                } else {
                    System.out.println("Try to enter the correct binary representation:");
                    studentBinary = scanner.next();
                    if (studentBinary.equals(correctBinary)) {
                        youAreGreat(studentName);
                    } else {
                        System.out.println("Sorry, " + studentName +
                                ". The entered fraction is not in the valid range (0.0 - 1.0). Correct binary is " + correctBinary);
                    }
                }
            } else {
                System.out.println("The entered fraction is not in the valid range (0.0 - 1.0).");
            }
        }

        static void letterToCode(String studentName) {
            System.out.println("Task 3: Convert letters to binary ASCII codes.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a letter (a to z or A to Z): ");
            char letter = scanner.next().charAt(0);

            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {

                System.out.println("Enter the binary representation, for example A is 01000001, a is 01100001: ");
                String studentBinary = scanner.next();

                char codeToLetter = (char) Integer.parseInt(studentBinary, 2);

                if (letter == codeToLetter) {
                    youAreGreat(studentName);
                } else {
                    System.out.println("Sorry, not correct. Try to reenter binary code: ");
                    String studentBinary2 = scanner.next();
                    char codeToLetter2 = (char) Integer.parseInt(studentBinary2, 2);

                    if (letter == codeToLetter2) {
                        youAreGreat(studentName);
                    } else {
                        System.out.println("Sorry, " + studentName + ". The correct binary representation is: " + Integer.toBinaryString(letter));
                    }
                }
            } else {
                System.out.println("The entered character is not a valid letter (a to z or A to Z).");
            }
        }

        static void bubbleSortTask(String studentName) {
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

        public static void main(String[] args) {
//            Random random = new Random();
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Hi, what is your name?");
//            String studentName = scanner.next();
//            System.out.println("Hi, " + studentName);
//
//            System.out.println("Welcome to Computer Science practice!");
//            System.out.println("Task 1: Calculate the file size of an image with a given color depth.");
//            System.out.println("Task 2: Convert a decimal fraction to 8 bits binary (4 bits integer + 4 bits fractional).");
//            System.out.println("Task 3: Convert letters to binary ASCII codes.");
//            System.out.println("Task 4: Bubble Sort Iterations.");
//
//            while (true) {
//                System.out.print("Please choose a task (1, 2, 3 or 4) or 0 for random:");
//                int taskNumber = scanner.nextInt();
//                if (taskNumber == 0) {
//                    taskNumber = 1 + random.nextInt(3);
//                    System.out.println(taskNumber);
//                }
//                if ((taskNumber > 0) && (taskNumber < 5)) {
//                    switch (taskNumber) {
//                        case 1:
//                            imageSize(studentName);
//                            break;
//                        case 2:
//                            decimalToBinary(studentName);
//                            break;
//                        case 3:
//                            letterToCode(studentName);
//                            break;
//                        case 4:
//                            bubbleSortTask(studentName);
//                            break;
//                    }
//                } else {
//                    System.out.println("Invalid task number.");
//                }
//            }
        }


}
