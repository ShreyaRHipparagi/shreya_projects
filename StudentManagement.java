import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    double marks;

    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // if user enters something non-numeric
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number between 1–5: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateMarks();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter roll number: ");
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid roll number: ");
            sc.next();
        }
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter valid marks: ");
            sc.next();
        }
        double marks = sc.nextDouble();
        students.add(new Student(rollNo, name, marks));
        System.out.println("Student added!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("\nList of Students:");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateMarks() {
        System.out.print("Enter roll number to update marks: ");
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid roll number: ");
            sc.next();
        }
        int rollNo = sc.nextInt();
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.print("Enter new marks: ");
                while (!sc.hasNextDouble()) {
                    System.out.print("Please enter valid marks: ");
                    sc.next();
                }
                s.marks = sc.nextDouble();
                System.out.println("Marks updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid roll number: ");
            sc.next();
        }
        int rollNo = sc.nextInt();
        boolean removed = students.removeIf(s -> s.rollNo == rollNo);
        if (removed) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found!");
        }
    }
}
