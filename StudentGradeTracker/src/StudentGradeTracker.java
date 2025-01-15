import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        String continueInput;

        System.out.println("=== Welcome to Student Grade Tracker ===");

        // Input Grades
        do {
            System.out.print("Enter the student's grade (0-100): ");
            double grade = scanner.nextDouble();

            // Validate grade input
            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else {
                System.out.println("Invalid grade! Please enter a grade between 0 and 100.");
            }

            System.out.print("Would you like to add another grade? (yes/no): ");
            continueInput = scanner.next();

        } while (continueInput.equalsIgnoreCase("yes"));

        // Calculate average, highest, and lowest
        if (grades.isEmpty()) {
            System.out.println("No grades were entered. Exiting the program.");
        } else {
            calculateAndDisplayStats(grades);
        }

        scanner.close();
    }

    // Method to calculate and display statistics
    private static void calculateAndDisplayStats(ArrayList<Double> grades) {
        double sum = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);

        for (double grade : grades) {
            sum += grade;
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
        }

        double average = sum / grades.size();

        // Display the results
        System.out.println("\n--- Grade Statistics ---");
        System.out.println("Total Students: " + grades.size());
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }
}
