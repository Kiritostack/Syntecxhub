package Student;
import java.util.*;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));

        System.out.println("Student added successfully!");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nID    Name            Age   Course");
        System.out.println("-------------------------------------");

        for (Student s : students) {
            s.display();
        }
    }

    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {

                sc.nextLine();

                System.out.print("Enter new name: ");
                s.name = sc.nextLine();

                System.out.print("Enter new age: ");
                s.age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter new course: ");
                s.course = sc.nextLine();

                System.out.println("Student updated!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {

            Student s = it.next();

            if (s.id == id) {
                it.remove();
                System.out.println("Student deleted!");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}