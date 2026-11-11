import java.util.Scanner;
import java.util.Locale;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("=== STUDENT GRADE CALCULATOR ===");
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        double grade1 = readValidGrade(scanner, "Enter the first grade (0-10): ");
        double grade2 = readValidGrade(scanner, "Enter the second grade (0-10): ");
        double grade3 = readValidGrade(scanner, "Enter the third grade (0-10): ");

        double average = (grade1 + grade2 + grade3) / 3.0;

        double highest = Math.max(grade1, Math.max(grade2, grade3));
        double lowest = Math.min(grade1, Math.min(grade2, grade3));

        System.out.println("\n----------------------------------");
        System.out.println("Student: " + name);
        System.out.printf("Student average: %.2f%n", average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);

        if (average >= 5.0) {
            System.out.println("Result: PASSED");
        } else {
            System.out.println("Result: FAILED");
        }

        scanner.close();
    }

    private static double readValidGrade(Scanner scanner, String prompt) {
        double grade;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input! " + prompt);
                scanner.next();
            }
            grade = scanner.nextDouble();
        } while (grade < 0 || grade > 10);
        return grade;
    }
}