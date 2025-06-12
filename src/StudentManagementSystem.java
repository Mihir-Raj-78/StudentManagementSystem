import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    String department;
    double marks;

    Student(int rollNumber, String name, String department, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Marks      : " + marks);
        System.out.println("-------------------------------");
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n---- Student Management System ----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewAllStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(roll, name, dept, marks);
        students.add(s);
        System.out.println("Student added successfully!");
    }

    static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll Number to Search: ");
        int roll = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.rollNumber == roll) {
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    static void updateStudent() {
        System.out.print("Enter Roll Number to Update: ");
        int roll = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.rollNumber == roll) {
                sc.nextLine(); // clear buffer
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter New Department: ");
                s.department = sc.nextLine();
                System.out.print("Enter New Marks: ");
                s.marks = sc.nextDouble();
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number to Delete: ");
        int roll = sc.nextInt();
        boolean removed = students.removeIf(s -> s.rollNumber == roll);

        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}
