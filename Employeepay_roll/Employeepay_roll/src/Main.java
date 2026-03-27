import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollService service = new PayrollService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Add Salary");
            System.out.println("3. Generate Payroll");
            System.out.println("4. Generate Payslip");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Dept: ");
                    String dept = sc.nextLine();
                    System.out.print("Designation: ");
                    String desig = sc.nextLine();

                    service.addEmployee(name, dept, desig);
                    break;

                case 2:
                    System.out.print("Emp ID: ");
                    int id = sc.nextInt();
                    System.out.print("Basic: ");
                    double basic = sc.nextDouble();
                    System.out.print("HRA: ");
                    double hra = sc.nextDouble();
                    System.out.print("DA: ");
                    double da = sc.nextDouble();
                    System.out.print("Bonus: ");
                    double bonus = sc.nextDouble();
                    System.out.print("Deductions: ");
                    double ded = sc.nextDouble();

                    service.addSalary(id, basic, hra, da, bonus, ded);
                    break;

                case 3:
                    System.out.print("Emp ID: ");
                    int eid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Month: ");
                    String month = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    service.generatePayroll(eid, month, year);
                    break;

                case 4:
                    System.out.print("Emp ID: ");
                    int pid = sc.nextInt();

                    service.generatePayslip(pid);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
