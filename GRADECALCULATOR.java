import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradeCalculator {

    public static double calculateAverageGrade(String filename) {
        int total = 0;
        int count = 0;

        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int grade = Integer.parseInt(parts[1]);
                total += grade;
                count++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        if (count == 0) {
            return 0;
        }

        return (double) total / count;
    }

    public static void printStudentGrades(String filename) {
        System.out.println("Student Grades:");
        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line.replace(" ", ": "));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void main(String[] args) {
        String filename = "grades.txt";

        printStudentGrades(filename);
        double average = calculateAverageGrade(filename);
        System.out.printf("Average Grade: %.2f", average);
    }
}
