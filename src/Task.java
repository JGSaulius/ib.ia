import java.util.Scanner;

class Task {
    protected String studentName;
    protected Scanner scanner;

    public Task(String studentName) {
        this.studentName = studentName;
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        // To be overridden by subclasses
    }

    protected void youAreGreat() {
        System.out.println("You are great, " + studentName + "!");
    }
}