package CStasksOOP;

import java.util.Random;
import java.util.Scanner;

class LetterToCodeTask extends Task {
    public LetterToCodeTask(String studentName) {
        super(studentName);
    }

    @Override
    public void execute() {
        System.out.println("Task 1: Calculate the file size of an image with a given color depth.");
        System.out.println("What is the color depth of the picture (for example 8 or 24)?");
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
                youAreGreat();
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
                    youAreGreat();
                } else {
                    System.out.println("Sorry, " + studentName + ".");
                }
            }
            repeatAgain = 1;
        }
    }
}
