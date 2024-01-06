package CStasksOOP;

import java.util.Scanner;

class DecimalToBinaryTask extends Task {
    public DecimalToBinaryTask(String studentName) {
        super(studentName);
    }

    @Override
    public void execute() {
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
                youAreGreat();
            } else {
                System.out.println("Try to enter the correct binary representation:");
                studentBinary = scanner.next();
                if (studentBinary.equals(correctBinary)) {
                    youAreGreat();
                } else {
                    System.out.println("Sorry, " + studentName +
                            ". The entered fraction is not in the valid range (0.0 - 1.0). Correct binary is " + correctBinary);
                }
            }
        } else {
            System.out.println("The entered fraction is not in the valid range (0.0 - 1.0).");
        }
    }
}
