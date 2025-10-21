import java.util.ArrayList;
import java.util.Scanner;

// Blueprint for Student object
class Student {
    private int studentId;
    private String studentName;
    private double totalMarks;

    public Student(int studentId, String studentName, double totalMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.totalMarks = totalMarks;
    }

    // Getters
    public int getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public double getTotalMarks() { return totalMarks; }

    // Setters
    public void setStudentName(String name) { this.studentName = name; }
    public void setTotalMarks(double marks) { this.totalMarks = marks; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Marks: %.2f", studentId, studentName, totalMarks);
    }
}

public class StudentManager {
    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = input.nextInt();
            input.nextLine(); // consume leftover newline

            switch (option) {
                case 1 -> insertStudent();
                case 2 -> displayAll();
                case 3 -> modifyStudent();
                case 4 -> removeStudent();
                case 5 -> System.out.println(" Exiting program.");
                default -> System.out.println(" Invalid choice. Please try again.");
            }
        } while (option != 5);
    }

    private static void showMenu() {
        System.out.println("\n==============================");
        System.out.println("     STUDENT MANAGEMENT APP   ");
        System.out.println("==============================");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student Details");
        System.out.println("4. Delete Student Record");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void insertStudent() {
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter Student Name: ");
        String name = input.nextLine();
        System.out.print("Enter Marks: ");
        double marks = input.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println(" Student successfully added!");
    }

    private static void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n------ Student Records ------");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    private static void modifyStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = input.nextInt();
        input.nextLine();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getStudentId() == id) {
                System.out.print("Enter new name: ");
                String newName = input.nextLine();
                System.out.print("Enter new marks: ");
                double newMarks = input.nextDouble();

                s.setStudentName(newName);
                s.setTotalMarks(newMarks);
                System.out.println(" Student record updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println(" Student ID not found!");
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = input.nextInt();
        boolean isDeleted = studentList.removeIf(s -> s.getStudentId() == id);

        if (isDeleted)
            System.out.println(" Record deleted successfully!");
        else
            System.out.println(" Student not found!");
    }
}
