import java.sql.*;

public class PayrollService {

    public void addEmployee(String name, String dept, String desig) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO employees(name, department, designation) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setString(3, desig);

            ps.executeUpdate();
            System.out.println("Employee Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSalary(int empId, double basic, double hra, double da, double bonus, double deductions) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO salaries(emp_id, basic, hra, da, bonus, deductions) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, empId);
            ps.setDouble(2, basic);
            ps.setDouble(3, hra);
            ps.setDouble(4, da);
            ps.setDouble(5, bonus);
            ps.setDouble(6, deductions);

            ps.executeUpdate();
            System.out.println("Salary Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generatePayroll(int empId, String month, int year) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT basic, hra, da, bonus, deductions FROM salaries WHERE emp_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double basic = rs.getDouble("basic");
                double hra = rs.getDouble("hra");
                double da = rs.getDouble("da");
                double bonus = rs.getDouble("bonus");
                double deductions = rs.getDouble("deductions");

                double gross = basic + hra + da + bonus;
                double net = gross - deductions;

                String insert = "INSERT INTO payroll(emp_id, month, year, gross_salary, net_salary) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps2 = conn.prepareStatement(insert);

                ps2.setInt(1, empId);
                ps2.setString(2, month);
                ps2.setInt(3, year);
                ps2.setDouble(4, gross);
                ps2.setDouble(5, net);

                ps2.executeUpdate();

                System.out.println("Payroll Generated!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generatePayslip(int empId) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = """
                SELECT e.name, s.basic, s.hra, s.da, s.bonus, s.deductions,
                       p.gross_salary, p.net_salary
                FROM employees e
                JOIN salaries s ON e.emp_id = s.emp_id
                JOIN payroll p ON e.emp_id = p.emp_id
                WHERE e.emp_id = ?
            """;

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("\n--- PAYSLIP ---");
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Basic: " + rs.getDouble("basic"));
                System.out.println("HRA: " + rs.getDouble("hra"));
                System.out.println("DA: " + rs.getDouble("da"));
                System.out.println("Bonus: " + rs.getDouble("bonus"));
                System.out.println("Deductions: " + rs.getDouble("deductions"));
                System.out.println("Gross: " + rs.getDouble("gross_salary"));
                System.out.println("Net: " + rs.getDouble("net_salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}