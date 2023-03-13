import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
    public List<EmployeeDetails> readData() {
        String sql = "select * from employee_payroll";
        List<EmployeeDetails> employeePayrollList = new ArrayList<>();
        try {
            Connection conn = new DBConnection().getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String department = result.getString("department");
                String phone_number = result.getString("phone_number");
                double basic_pay = result.getDouble("basic_pay");
                employeePayrollList.add(new EmployeeDetails(id, name, department, phone_number, basic_pay));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
}
