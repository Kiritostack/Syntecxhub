package Student;
public class Student {

    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.printf("%-5d %-15s %-5d %-10s\n", id, name, age, course);
    }
}